package MapReduce;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class Utility {
    public static void main(String[] args) {


    Random rand = new Random();
    Path path = Path.of("C:\\Users\\SWAPNILJ\\Documents\\Personal Stuff\\JAVA LEARNING\\SystemDesign\\src\\MapReduce\\host2\\latencies.txt");
    Path path2 = Path.of("C:\\Users\\SWAPNILJ\\Documents\\Personal Stuff\\JAVA LEARNING\\SystemDesign\\src\\MapReduce\\host1\\latencies.txt");

    // Writing data to the file
            new Thread(() -> {
        for (int i = 0; i < 1000; i++) {

            int input = rand.nextInt(50000) + 5000;
            try {
                Files.write(path, (input + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }).start();
            new Thread(() -> {
        for (int i = 0; i < 1000; i++) {

            int input = rand.nextInt(50000) + 5000;
            try {
                Files.write(path2, (input + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }).start();

}}
