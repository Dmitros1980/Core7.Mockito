import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GeoServiceImplTest {
    GeoService geoService = new GeoServiceImpl();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void testLocationByIp(String ip, Country expected) {
        GeoService geoService = new GeoServiceImpl();

        Country result = geoService.byIp(ip).getCountry();

        Assertions.assertEquals(expected, result);

    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("172.",  Country.RUSSIA),
                Arguments.of("96.", Country.USA)
        );
    }


    @Test
    public void testLocationByCoordinates() {

        GeoService geoService = new GeoServiceImpl();

        Class<RuntimeException> expected = RuntimeException.class;
        double longitude=0;
        double latitude = 0;
        Assertions.assertThrows(expected, () -> geoService.byCoordinates(latitude, longitude));
    }
}
