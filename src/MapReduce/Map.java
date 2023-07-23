package MapReduce;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;

public class Map {
    String host;
    Map(String host) {
        this.host = host;
    }

    public void emitMapResult(String key) {
        Path path = Path.of("C:\\Users\\SWAPNILJ\\Documents\\Personal Stuff\\JAVA LEARNING\\SystemDesign\\src\\MapReduce\\"+host+"\\map_results\\"+key+".txt");
        try {
            Files.write(path, (1 + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("some exception occurred");
        }
    }


    public void map(Path path) throws IOException {

        List<String> latencies = Files.readAllLines(path);

        for (String line : latencies) {
            int latency = Integer.parseInt(line);
            if (latency <= 10000) {
                emitMapResult("under_10_seconds");
            } else {
                emitMapResult("over_10_seconds" );
            }
        }
    }
}
