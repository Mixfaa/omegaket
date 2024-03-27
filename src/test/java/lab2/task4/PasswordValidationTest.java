package lab2.task4;

import com.mixfa.lab2.task4.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {

    @Test
    public void test() {
        Assertions.assertTrue(PasswordValidator.isPasswordValid("q8*2E/M2iLzFe(t|j="));
        Assertions.assertTrue(PasswordValidator.isPasswordValid("%AJTz.6167I/i"));
        Assertions.assertTrue(PasswordValidator.isPasswordValid("5n0X8ga@IL)Lxd=lAx"));

        Assertions.assertFalse(PasswordValidator.isPasswordValid("<!n#HHKkmmbSY:£-rt")); // no number
        Assertions.assertFalse(PasswordValidator.isPasswordValid("IRkl3pKg10p2jUQHc3")); // no symbols
        Assertions.assertFalse(PasswordValidator.isPasswordValid("-4tt(.<35w8n{<1q'8")); // no uppercase

    }
}