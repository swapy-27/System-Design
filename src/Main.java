import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String key= "abcdefg";
        final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        final byte[] hashbytes = digest.digest(
                key.getBytes(StandardCharsets.UTF_8));
        System.out.println( key.getBytes(StandardCharsets.UTF_8));
        System.out.println(hashbytes);
        // Convert the hashbytes array to an integer
        int hashValue = 0;
        for (byte b : hashbytes) {
            hashValue = (hashValue << 8) | (b & 0xFF);
        }

        // Make sure the hash value is positive
        hashValue = Math.abs(hashValue);

        System.out.println(hashValue);
        System.out.println("Hello world!");
    }
}