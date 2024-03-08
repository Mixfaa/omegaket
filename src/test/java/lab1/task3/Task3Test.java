package lab1.task3;

import com.mixfa.lab1.task3.Task3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task3Test {
    @Test
    public void test() {
        var random = new Random();
        var integeres = new ArrayList<BigInteger>(
                List.of(
                        new BigInteger(32, random),
                        new BigInteger(32, random),
                        new BigInteger(32, random),
                        new BigInteger(32, random)
                )
        );

        var rawResult = Task3.doJob_raw(new ArrayList<>(integeres));
        var collectionsResult = Task3.doJob_collections(new ArrayList<>(integeres));
        var streamsResult = Task3.doJob_streams(new ArrayList<>(integeres));

        Assertions.assertEquals(rawResult, collectionsResult);
        Assertions.assertEquals(rawResult, streamsResult);
        Assertions.assertEquals(collectionsResult, streamsResult);
    }
}
