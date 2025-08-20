import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void assertionsMethodsEqual(){
        assertEquals(3.3, calculator.sum(1.2, 2.1));
        assertNotEquals(4.1, calculator.multiply(2.0, 2.0));
    }

    @Test
    public void assertionsMethodsPrimitive(){
        Double result = calculator.divide(10.0, 2.0);
        assertTrue(result == 5.0);
    }

    @Test
    public void assertionsMethodsRef(){
        Double result = calculator.subtract(2.0, 1.0);
        assertNull(result == 3.0);
    }
}
