import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.Map;


import static org.mockito.Mockito.description;
import static org.mockito.Mockito.verify;

public class MessegeSenderImplTest {



    @Test
    public void testMessageSenderImpl() {

        GeoService geoService=Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn
                (new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService=Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn( "Добро пожаловать");

    }
}
