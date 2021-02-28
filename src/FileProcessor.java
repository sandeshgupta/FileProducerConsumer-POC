import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class FileProcessor implements Runnable {
    private String sessionId;

    private final BlockingQueue<String> fileQueue;

    FileProcessor(BlockingQueue fileQueue) {
        System.out.println("In processor constructor");
        this.fileQueue = fileQueue;
        this.sessionId = createSession();
    }

    private String createSession() {
        String sessionId = getAlphaNumericString(5);
        System.out.println("Create session - " + sessionId);
        return sessionId;
    }

    @Override
    public void run() {
        while (true){
            try {
                String file = fileQueue.take();
                processFile(file);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processFile(String file) {
        System.out.println(String.format("File  processed %s, Session id used: %s", file, sessionId));
    }


    static String getAlphaNumericString(int n) {

        // lower limit for LowerCase Letters
        int lowerLimit = 97;

        // lower limit for LowerCase Letters
        int upperLimit = 122;

        Random random = new Random();

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer(n);

        for (int i = 0; i < n; i++) {

            // take a random value between 97 and 122
            int nextRandomChar = lowerLimit
                    + (int) (random.nextFloat()
                    * (upperLimit - lowerLimit + 1));

            // append a character at the end of bs
            r.append((char) nextRandomChar);
        }

        // return the resultant string
        return r.toString();
    }
}
