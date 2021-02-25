package thread;

import com.gmail.yuramitryahin.thread.ExecutorServiceImpl;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExecutorServiceImplTest {
    private List<Integer> numbers;
    private ExecutorServiceImpl executorService;

    @Before
    public void init() {
        numbers = new ArrayList<>();
    }

    @Test
    public void correctValues() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        executorService = new ExecutorServiceImpl(numbers);
        BigInteger expected = BigInteger.valueOf(15);
        BigInteger actual = executorService.findSum();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void negativeValues() {
        numbers.add(-1);
        numbers.add(-1);
        numbers.add(-1);
        numbers.add(-5);
        numbers.add(-5);
        executorService = new ExecutorServiceImpl(numbers);
        BigInteger expected = BigInteger.valueOf(-13);
        BigInteger actual = executorService.findSum();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nullValues() {
        executorService = new ExecutorServiceImpl(numbers);
        BigInteger expected = BigInteger.valueOf(0);
        BigInteger actual = executorService.findSum();
        Assert.assertEquals(expected, actual);
    }
}
