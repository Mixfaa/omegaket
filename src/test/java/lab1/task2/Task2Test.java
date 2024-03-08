package lab1.task2;

import com.mixfa.lab1.task2.Task2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Task2Test {
    @Test
    public void test() {
        for (int i = 2; i < 15; i++) {
            BigInteger bi = new BigInteger(32, new SecureRandom());

            Assertions.assertEquals(bi.pow(i), Task2.powByMultiply(bi, i));

        }
    }
}
