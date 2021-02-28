import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerController {
    public static void main(String[] args) {
        BlockingQueue<String> fileQueue = new LinkedBlockingQueue<>();

        //initialise producer
        new Thread(new FileProducer(fileQueue, 50)).start();

        //initialise consumers
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new FileProcessor(fileQueue));
        }
    }




}
