package cf.mindaugas.sdademos._02_junitmockito;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ex02_CalculatorTest {

    private Ex02_Calculator calc = new Ex02_Calculator();

    @Test
    // [the name of the tested method]_[expected input / tested state]_[expected behavior]
    public void add_givenTwoPositiveIntegers_correctPositiveSum(){
        // given / arrange
        int firstNum = 1;
        int secondNum = 2;

        // when / act
        int result = calc.add(firstNum, secondNum);

        // then / assert
        // assert result == 3;
        assertEquals(3, result);

        // teardown

        // GWTT / AAAT
    }

    @Test
    // [the name of the tested method]_[expected input / tested state]_[expected behavior]
    public void add_givenTwoNegativeIntegers_correctNegativeSum(){
        // given, when
        int result = calc.add(-1, -2);

        // then
        // assert result == -3;
        assertEquals(-2, result);
    }
}
