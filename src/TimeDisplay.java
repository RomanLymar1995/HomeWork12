import java.util.Timer;
import java.util.TimerTask;

public class TimeDisplay {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int secondsPassed = 0;

            @Override
            public void run() {
                System.out.println("Time passed: " + secondsPassed + " seconds.");
                secondsPassed++;
            }
        };

        // Schedule the timer to run every second
        timer.scheduleAtFixedRate(task, 0, 1000);

        // Create and start a second thread to display the message every 5 seconds
        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        messageThread.start();
    }
}