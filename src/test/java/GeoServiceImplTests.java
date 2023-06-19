import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.Objects;

import static jdk.internal.vm.PostVMInitHook.run;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeoServiceImplTests {
    private String city;
    private Country country;
    private String street;
    private int builing;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (!Objects.equals(city, location.getCity())) return false;
        if (!Objects.equals(country, location.getCountry())) return false;
        if (!Objects.equals(street, location.getStreet())) return false;
        if (!Objects.equals(builing, location.getBuiling())) return false;
        return true;
    }

    @ParameterizedTest
    @CsvSource({"172.0.32.11", "175.0.32.11"})
    public void test_byIp(String argument) {
        // given:
        final GeoServiceImpl original = new GeoServiceImpl();
        final Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        // when:
        Location result = original.byIp(argument);
        // then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_byCoordinates() throws RuntimeException {
        Throwable thrown = assertThrows(IllegalAccessError.class, () -> {
            run();
        });

        assertNotNull(thrown.getMessage());

    }

}
