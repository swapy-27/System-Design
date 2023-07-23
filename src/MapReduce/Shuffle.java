package MapReduce;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Shuffle {
    String host;
    Shuffle(String host) {
        this.host = host;
    }
    public  void Shuffle() {

        try {
            Path tmpDirectory = Path.of("C:\\Users\\SWAPNILJ\\Documents\\Personal Stuff\\JAVA LEARNING\\SystemDesign\\src\\MapReduce\\"+host+"\\map_results");
            Stream<Path> files = Files.list(tmpDirectory);
            // Read all lines from the source file
            files.forEach(path->{
               String[] destinationFile =  path.toString().split("\\\\");
                String destinationFilePath = "C:\\Users\\SWAPNILJ\\Documents\\Personal Stuff\\JAVA LEARNING\\SystemDesign\\src\\MapReduce\\map_results\\"+destinationFile[destinationFile.length-1];

                try {
                    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                    // Append the content of the source file to the destination file
                    Path destinationPath = Paths.get(destinationFilePath);
                    Files.write(destinationPath, lines, StandardCharsets.UTF_8, java.nio.file.StandardOpenOption.APPEND);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }



            });
            System.out.println("Content added to the destination file successfully.");

        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }

}
