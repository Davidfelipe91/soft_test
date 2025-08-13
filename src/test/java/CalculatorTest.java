import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void sum(){
        assertEquals(3.3, calculator.sum(1.2, 2.1));
    }
}
