package ConsistentHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Example {

    //array which will hold the details of server we can connect--> each server has two fun put_file , get_file
    private ArrayList<StorageNode> servers = new ArrayList<>(Arrays.asList(

            new StorageNode("A", "10.131.213.12"),
            new StorageNode("B", "10.131.217.11"),
            new StorageNode("C", "10.131.142.46"),
            new StorageNode("D", "10.131.114.17"),
            new StorageNode("E", "10.131.189.18")));


    public Integer hash_fn(String file_path) {
        /***The function sums the bytes present in the `key` and then
         take a mod with 5. This hash function thus generates output
         in the range [0, 4].
         ***/
        return file_path.hashCode() % 5;
    }

    //upload-data
    public void upload(String file_path) {
        int index = hash_fn(file_path);
        StorageNode server = servers.get(index);
        server.put_file(file_path);
    }


    //fetch-data
    public void fetch(String file_path) {
        int index = hash_fn(file_path);
        StorageNode server = servers.get(index);
        server.get_file(file_path);

    }


}
