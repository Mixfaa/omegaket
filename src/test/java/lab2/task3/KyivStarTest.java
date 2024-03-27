package lab2.task3;

import com.mixfa.lab2.task3.KyivstarPhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KyivStarTest {

    @Test
    public void test() {
        // with 96
        Assertions.assertTrue(KyivstarPhoneNumber.check("+380 96 256 67 35"));
        Assertions.assertTrue(KyivstarPhoneNumber.check("096 256 67 35"));
        Assertions.assertTrue(KyivstarPhoneNumber.check("0962566735"));
        Assertions.assertTrue(KyivstarPhoneNumber.check("+380962566735"));
        Assertions.assertTrue(KyivstarPhoneNumber.check("(096) 256 67 35"));
        Assertions.assertTrue(KyivstarPhoneNumber.check("+380 (96) 256 67 35"));

        // with 67
        Assertions.assertTrue(KyivstarPhoneNumber.check("+380 67 256 67 35"));
        Assertions.assertTrue(KyivstarPhoneNumber.check("067 256 67 35"));
        Assertions.assertTrue(KyivstarPhoneNumber.check("0672566735"));
        Assertions.assertTrue(KyivstarPhoneNumber.check("+380672566735"));
        Assertions.assertTrue(KyivstarPhoneNumber.check("(067) 256 67 35"));
        Assertions.assertTrue(KyivstarPhoneNumber.check("+380 (67) 256 67 35"));

        Assertions.assertFalse(KyivstarPhoneNumber.check("+380 00 256 00 35"));
        Assertions.assertFalse(KyivstarPhoneNumber.check("000 256 00 35"));
        Assertions.assertFalse(KyivstarPhoneNumber.check("0002560035"));
        Assertions.assertFalse(KyivstarPhoneNumber.check("+380002560035"));
        Assertions.assertFalse(KyivstarPhoneNumber.check("(000) 256 00 35"));
        Assertions.assertFalse(KyivstarPhoneNumber.check("+380 (00) 256 00 35"));
    }

}