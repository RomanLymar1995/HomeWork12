import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {
    public static void main(String[] args) {
        int n = 15;
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    try {
                        queue.put("fizz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    try {
                        queue.put("buzz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(() -> {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    try {
                        queue.put("fizzbuzz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadD = new Thread(() -> {
            for (int i = 1; i <= n; i++) {
                try {
                    String output = queue.take();
                    System.out.println(output.isEmpty() ? i : output);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}