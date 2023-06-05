import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class LocalizationServiceImplTest {
    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @Test
    public void testLocale() {
        //  Arrange
        localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";
        //  Act
        String result = localizationService.locale(Country.RUSSIA);

        //  Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testLocale1() {
        //  Arrange
        localizationService.locale(Country.BRAZIL);
        localizationService.locale(Country.USA);
        localizationService.locale(Country.GERMANY);
        String expected = "Welcome";

        //  Act
        String result = localizationService.locale(Country.USA);
        String result1 = localizationService.locale(Country.BRAZIL);
        String result2 = localizationService.locale(Country.GERMANY);
        //  Assert
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(expected, result1);
        Assertions.assertEquals(expected, result2);

    }
}
