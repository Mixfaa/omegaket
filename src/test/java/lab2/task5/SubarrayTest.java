package lab2.task5;

import com.mixfa.lab2.task5.Subarray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubarrayTest {
    @Test
    public void test() {
        Assertions.assertArrayEquals(
                Subarray.stringBetweenDigits("testString124testString7564testString"),
                new String[]{
                        "testString",
                        "testString",
                        "testString"
                }
        );
    }
}
