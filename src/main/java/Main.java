import java.util.Random;

public class Main {
    public static void main(String[] args)  {

        Report report = new Report();

        Thread store1 = new Thread(null, () -> report.addStoreData(createRandomArray()), "Магазин №1");
        Thread store2 = new Thread(null, () -> report.addStoreData(createRandomArray()), "Магазин №2");
        Thread store3 = new Thread(null, () -> report.addStoreData(createRandomArray()), "Магазин №3");

        startThreads(store1, store2, store3);
        joinThreads(store1, store2, store3);

        System.out.println("SUM with LongerAdder = " + report.getAdder());

    }

    private static int[] createRandomArray() {
        Random random = new Random();
        int purchasesPerDay = random.nextInt(10);
        int[] array = new int[purchasesPerDay];

        for (int i = 0; i < array.length; i++) {
            int maxPrice = random.nextInt(10_000);
            array[i] = random.nextInt(maxPrice);
        }
        return array;
    }

    private static void startThreads(Thread... threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void joinThreads(Thread... threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
