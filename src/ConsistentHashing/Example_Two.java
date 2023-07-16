package ConsistentHashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * consisting hashing is done by creating a pre defined space for every key possible
 * [0,2^218-1]
 * now again the problem arises in case of scaling or scale down we need to rehash complete array
 * to solve this the ring method was approved
 * we will place every server on ring at random spacing
 * and every key in btw two server will belongs to next clockwise server
 * in any case of downsizing or upsizing only key belongs till prev server need to rehash
 * the intermediate size btw to server can get very small or large and there can be undistributed keys
 * this was eliminated using server virtual node so instead of s1 --> we have s1_0 s1_2 s1_3 .....
 **/
public class Example_Two {
    //Storage space for keys
    //Storage space for nodes
    private ArrayList<Integer> keys;

    private ArrayList<StorageNode> nodes;

    private int hash_fn(String key, int total_slots) throws NoSuchAlgorithmException {

        final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        final byte[] hashbytes = digest.digest(
                key.getBytes(StandardCharsets.UTF_8));
        // Convert the hashbytes array to an integer
        int hashValue = 0;
        for (byte b : hashbytes) {
            hashValue = (hashValue << 8) | (b & 0xFF);
        }

        // Make sure the hash value is positive
        hashValue = Math.abs(hashValue);

        // Modulo the hash value with the total number of slots to get the final hash slot
        int hashSlot = hashValue % total_slots;

        return hashSlot;

    }

    ;
//    private static String bytesToHex(byte[] hash) {
//        StringBuilder hexString = new StringBuilder(2 * hash.length);
//        for (int i = 0; i < hash.length; i++) {
//            String hex = Integer.toHexString(0xff & hash[i]);
//            if(hex.length() == 1) {
//                hexString.append('0');
//            }
//            hexString.append(hex);
//        }
//        return hexString.toString();
//    }

    //hashFn

    //add_node

    public int add(StorageNode node) throws Exception {

//        if len(self._keys) == self.total_slots:
//        raise Exception("hash space is full")

        int key = hash_fn(node.getHostName(), this.total_slots);

//    # find the index where the key should be inserted in the keys array
//    # this will be the index where the Storage Node will be added in the
//    # nodes array.
        int index = bisect(this.keys, key);

//    # if we have already seen the key i.e. node already is present
//    # for the same key, we raise Collision Exception
        if (index > 0 && this.keys.get(index - 1) == key) {
            throw new Exception("collision occurred");
        }


//    # Perform data migration
//
//    # insert the node_id and the key at the same `index` location.
//    # this insertion will keep nodes and keys sorted w.r.t keys.
        this.nodes.add(index, node);
        this.keys.add(index, key);

        return key;

    }

    //remove_node
    public int remove_node(StorageNode node) throws Exception {
        /** remove_node removes the node and returns the key
         from the hash space on which the node was placed.
         **/

//    handling error when space is empty
        if (this.keys.size() == 0) {
            throw new Exception("hash space is empty");
        }


        int key = hash_fn(node.getHostName(), this.total_slots);

//    #we find the index where the key would reside in the keys
        int index = bisect_left(this.keys, key);

//    #if key does not exist in the array we raise Exception
        if index >= len(self._keys) or self._keys[index] != key:
        raise Exception ("node does not exist")

//    #Perform data migration

//    #now that all sanity checks are done we popping the
//    #keys and nodes at the index and thus removing the presence of the node.
        this.keys.remove(index);
        this.nodes.remove(index);

        return key;
    }

    //assign
    public StorageNode assign(String item) {


        /**    Given an item, the function returns the node it is associated with.
         **/
        int key = hash_fn(item, this.total_slots);

//    #we find the first node to the right of this key
//    #if bisect_right returns index which is out of bounds then
//    #we circle back to the first in the array in a circular fashion.
        int index = bisect_right(this.keys, key) % this.keys.size();

// #return the node present at the index
        return this.nodes.get(index);
    }
}
