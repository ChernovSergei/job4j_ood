package kiss.fool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class FoolTest {
    @Test
    public void whenFizzBuzz() {
        String expected = "FizzBuzz";
        Assertions.assertEquals(expected, Fool.getCorrectAnswer(15));
    }

    @Test
    public void whenFizz() {
        String expected = "Fizz";
        Assertions.assertEquals(expected, Fool.getCorrectAnswer(9));
    }

    @Test
    public void whenBuzz() {
        String expected = "Buzz";
        Assertions.assertEquals(expected, Fool.getCorrectAnswer(25));
    }

    @Test
    public void whenNoFizzBuzz() {
        int input = 4;
        String expected = String.valueOf(input);
        Assertions.assertEquals(expected, Fool.getCorrectAnswer(input));
    }
}