package MapReduce;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MapReduce mapReduce1 = new MapReduce("host1");
        MapReduce mapReduce2 = new MapReduce("host2");
        mapReduce1.start();
        mapReduce2.start();
        Reduce.reduce();
    }
}
