import org.junit.Test;
import static org.junit.Assert.*;

public class TimeCalculatorTest {

    @Test
    public void testCalculateTimeNormalCase() {
        TimeCalculator calculator = new TimeCalculator();
        assertEquals(2.0, calculator.calculateTime(100.0, 50.0), 0.0001);
    }

    @Test
    public void testCalculateTimeLargeDistanceAndSpeed() {
        TimeCalculator calculator = new TimeCalculator();
        assertEquals(0.5, calculator.calculateTime(1000000.0, 2000000.0), 0.0001);
    }

    @Test
    public void testCalculateTimeZeroSpeed() {
        TimeCalculator calculator = new TimeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateTime(100, 0);
        });
    }

    @Test
    public void testCalculateTimeNegativeSpeed() {
        TimeCalculator calculator = new TimeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateTime(100, -10);
        });
    }

    @Test
    public void testCalculateTimeVeryLargeNumbers() {
        TimeCalculator calculator = new TimeCalculator();
        assertEquals(5.0, calculator.calculateTime(1e12, 2e11), 0.0001);
    }
}
