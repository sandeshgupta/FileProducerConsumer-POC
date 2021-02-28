import java.util.concurrent.BlockingQueue;

public class FileProducer implements Runnable{

    private final BlockingQueue fileQueue;

    private int latestFileNumber;

    FileProducer(BlockingQueue fileQueue, int initialNoOfFiles){
        System.out.println("In producer constructor");
        this.fileQueue = fileQueue;
        this.latestFileNumber = initialNoOfFiles;
        addFiles(initialNoOfFiles);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
                addFileToQueue(latestFileNumber++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addFiles(int initialNoOfFiles) {
        for (int i = 0; i < initialNoOfFiles; i++) {
            addFileToQueue(i);
        }
    }

    private void addFileToQueue(int i) {
        System.out.println("File created "+i);
        fileQueue.add("File - " + i);
    }


}
