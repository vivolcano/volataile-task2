import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

public class Report  {
    private final LongAdder adder = new LongAdder();

    public void addStoreData(int[] array) {
        int sum = Arrays.stream(array).sum();
        System.out.println("Загрузка данных из " + Thread.currentThread().getName() + " = " + sum);
        adder.add(sum);
    }

    public int getAdder() {
        return (int) adder.sum();
    }

}

