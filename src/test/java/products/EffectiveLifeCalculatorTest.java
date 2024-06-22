package products;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EffectiveLifeCalculatorTest {

    @Test
    public void whenReferenceDayRightInTheMiddle() {
        Calendar creation = new GregorianCalendar(2024, 6, 1, 0, 1);
        Calendar expiration = new GregorianCalendar(2024, 6, 30, 23, 59);
        Calendar reference = new GregorianCalendar(2024, 6, 16, 0, 0);
        EffectiveLifeCalculator calculator = new EffectiveLifeCalculator();
        assertThat(calculator.calcStoreLife(creation, expiration, reference)).isEqualTo(50);
    }

    @Test
    public void whenExpirationIsEarlierThanCreationThanError() {
        Calendar creation = new GregorianCalendar(2024, 6, 30, 0, 1);
        Calendar expiration = new GregorianCalendar(2024, 6, 1, 23, 59);
        Calendar reference = new GregorianCalendar(2024, 6, 15, 23, 59);
        EffectiveLifeCalculator calculator = new EffectiveLifeCalculator();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calcStoreLife(creation, expiration, reference));
        assertThat(exception.getMessage()).isEqualTo("Creation date should precede expiration date");
    }

    @Test
    public void whenReferenceIsEarlierThanCreationThanError() {
        Calendar creation = new GregorianCalendar(2024, 6, 1, 0, 1);
        Calendar expiration = new GregorianCalendar(2024, 6, 30, 23, 59);
        Calendar reference = new GregorianCalendar(2024, 5, 15, 23, 59);
        EffectiveLifeCalculator calculator = new EffectiveLifeCalculator();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calcStoreLife(creation, expiration, reference));
        assertThat(exception.getMessage()).isEqualTo("Creation date should precede reference date");
    }
}