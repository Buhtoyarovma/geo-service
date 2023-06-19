import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;


public class LocalizationServiceImplTests {

    @Test
    public void test_locale(){
        // given:
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";
        Country country = Country.RUSSIA;
        // when:
        String result = localizationService.locale(country);
        // then:
        Assertions.assertEquals(expected,result);
    }

}
