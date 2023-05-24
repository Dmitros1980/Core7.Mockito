import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GeoServiceImplTest {
    //Здравствуйте!у меня возникла проблемма с ParameterizedTest не понять почему он
    //не работает причем не первый раз пробую создать? Москито тоже пока не всё понятно.
    //может для начала подскажете пораметризации.
    static GeoServiceImpl geoServiceImpl = new GeoServiceImpl();
    @ParameterizedTest
    @MethodSource("argumenty")
    public void testLocationByIp(String ip,Location expected){

        Location result=geoServiceImpl.byIp(ip);

        Assertions.assertEquals(expected.toString(),result.toString());
    }
    @Test
    public static  Stream<Object> argumenty(){

        return Stream.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15));
    }


    @Test
    public void testByIp1() {
        String ip = GeoServiceImpl.MOSCOW_IP;
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        Location result = geoServiceImpl.byIp(ip);

        Assertions.assertEquals(expected.toString(), result.toString());
    }
    @Test
    public void testByIp2() {
        String ip = "172.";
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);

        Location result = geoServiceImpl.byIp(ip);

        Assertions.assertEquals(expected.toString(), result.toString());
    }
    @Test  //выброс ошибки
    public void testByCoordinates() {
        double latitude=10;
        double longitude=10;
       Class<RuntimeException>expected=RuntimeException.class;
       //Act
       // Location resalt=geoServiceImpl.byCoordinates(latitude,longitude);

        Assertions.assertThrows(expected,()->geoServiceImpl.byCoordinates(latitude,longitude));

    }

}
