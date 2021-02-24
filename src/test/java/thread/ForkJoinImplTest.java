package thread;

import com.gmail.yuramitryahin.thread.ForkJoinImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForkJoinImplTest {
    private List<Integer> numbers;
    private ForkJoinImpl forkJoinImpl;

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
        forkJoinImpl = new ForkJoinImpl(numbers);
        Integer actual = forkJoinImpl.compute();
        Assert.assertEquals(15, actual.intValue());
    }

    @Test
    public void negativeValues() {
        numbers.add(-1);
        numbers.add(-1);
        numbers.add(-1);
        numbers.add(-5);
        numbers.add(-5);
        forkJoinImpl = new ForkJoinImpl(numbers);
        Integer actual = forkJoinImpl.compute();
        Assert.assertEquals(-13, actual.intValue());
    }

    @Test
    public void nullValues() {
        forkJoinImpl = new ForkJoinImpl(numbers);
        Integer actual = forkJoinImpl.compute();
        Assert.assertEquals(0, actual.intValue());
    }
}
