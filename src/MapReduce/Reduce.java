package MapReduce;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Reduce {
    public static void reduce() {
        Path destinationFilePath =Path.of( "C:\\Users\\SWAPNILJ\\Documents\\Personal Stuff\\JAVA LEARNING\\SystemDesign\\src\\MapReduce\\reduce_results\\results.txt");


        try {
            Path tmpDirectory = Path.of("C:\\Users\\SWAPNILJ\\Documents\\Personal Stuff\\JAVA LEARNING\\SystemDesign\\src\\MapReduce\\map_results");
            Stream<Path> files = Files.list(tmpDirectory);

            // Read all lines from the source file
            files.forEach(path->{
                String[] destinationFile =  path.toString().split("\\\\");
               String key = destinationFile[destinationFile.length-1];

                try {
                    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                    Files.write(destinationFilePath, (key+"   "+lines.size()+"\n").getBytes(), StandardOpenOption.APPEND);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
            System.out.println("Content added to the destination file successfully.");

        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
}}
