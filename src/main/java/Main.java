import java.util.HashMap;
import java.util.Map;
public class Main {

    //Тестовый пример
    public static void main(String[] args) {
        GeoService geoService = (GeoService) new GeoServiceImpl();
        LocalizationService localizationService = (LocalizationService)
                new LocalizationServiceImpl();
        MessageSender messageSender = (MessageSender)
                new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        messageSender.send(headers.toString());
    }
}