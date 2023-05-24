import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.Map;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MessegeSenderImplTest {


     private  GeoServiceImpl geoService;
     String ip;
     String messege;
     private LocalizationService localizationService;
    @Test
    public String send(Map<String, String> headers) {
        String ipAddress = String.valueOf(headers.get(MessageSenderImpl.IP_ADDRESS_HEADER));
        if (ipAddress != null && !ipAddress.isEmpty()) {
            Location location = geoService.byIp(ipAddress);
            System.out.printf("Отправлено сообщение: %s", localizationService.locale(location.getCountry()));
            return localizationService.locale(location.getCountry());
        }
        return localizationService.locale(Country.USA);
    }
//    @ParameterizedTest
//    @CsvSource({
//            "172.0.32.11,Привет!"
//        //    "172.,Привет!"
//    })
    @Test
    public void testSendRussian(){
        Map<String ,String>expected=Map.of("172.0.32.11","Привет!");
        MockitoAnnotations.initMocks(this);
        MessageSender messageSender=  Mockito.mock(MessageSender.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        messageSender.send(messege);
        verify(messageSender).send(messege);

        Map<String,String>headers=Map.of("172.0.32.11","Привет!");

        Assertions.assertEquals(expected,headers);

    }
}
