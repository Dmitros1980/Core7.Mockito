import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Map;

public class MessegeSenderImplTest implements MessageSender{
      LocalizationServiceImpl localizationServiceImpl;
      MessageSenderImpl messageSender;
      Location location;

    @Test
    public void testSendRus() {
        String expected="Добро пожаловать" ;

       GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
       Mockito.when(geoServiceImpl.byIp("172.")).thenReturn(
               new Location("Moscow", Country.RUSSIA, null, 0));


        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        String resalt = localizationService.locale(Country.RUSSIA);

        Assertions.assertEquals(expected,resalt);
    }

    @Test
    public void testUsMessageSenderImpl() {
        String expected="Welcome";

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.")).thenReturn
                (new Location("New York", Country.USA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        String resalt=localizationService.locale(Country.USA);

        Assertions.assertEquals(expected,resalt);

    }


    @Override
    public String send(String headers) {
        return null;
    }
}
