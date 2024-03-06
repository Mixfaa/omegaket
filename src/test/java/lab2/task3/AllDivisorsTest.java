package lab2.task3;

import com.mixfa.lab2.task3.AllDivisors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllDivisorsTest {
    @Test
    public void test() {
        Assertions.assertArrayEquals(AllDivisors.findAllDivisors(30),
                new int[]{1, 2, 3, 5, 6, 10, 15, 30});

        Assertions.assertArrayEquals(AllDivisors.findAllDivisors(5),
                new int[]{1, 5});
    }
}
