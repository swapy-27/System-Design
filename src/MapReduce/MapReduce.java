package MapReduce;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MapReduce {
    String host;
    Map map ;
    Shuffle shuffle;
    MapReduce() {

    }
    MapReduce(String host) {
        this.host = host;
        map= new Map(host);
        shuffle=new Shuffle(host);
    }


    public void start() throws  IOException  {
        //Map
        Path latencyFile = Path.of("C:\\Users\\SWAPNILJ\\Documents\\Personal Stuff\\JAVA LEARNING\\SystemDesign\\src\\MapReduce\\"+host+"\\latencies.txt");

            map.map(latencyFile);
            //Shuffle
            shuffle.Shuffle();
            //Reduce
    }

}

