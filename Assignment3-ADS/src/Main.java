import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        MyHashTable<MyTestingClass, String> myHashTable = new MyHashTable<>();
        String str = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            String model = generateStr(random, str, 15);
            String value = generateStr(random, str, 10);
            int price = random.nextInt(0, 1000000);
            int year = random.nextInt(1800, 2023);
            myHashTable.put(new MyTestingClass(year, model, price), value);
        }

        MyTestingClass mers = new MyTestingClass(2022, "Maybach", 500000);
        myHashTable.put(mers, "TEST");
        System.out.println("Number of elements in each basket:" + Arrays.toString(myHashTable.getBucketSize()) + "  total: " + myHashTable.getSize());
        System.out.println("Contain value 'TEST': " + myHashTable.contains("TEST"));
        System.out.println("Get Key: " + myHashTable.getKey("TEST"));
        System.out.println("Get value: " + myHashTable.get(mers));
        myHashTable.remove(mers);
        System.out.println("Number of elements in each basket:" + Arrays.toString(myHashTable.getBucketSize()) + "  total: " + myHashTable.getSize());
    }

    public static String generateStr(Random r, String characters, int l) {
        char[] text = new char[l];
        for (int i = 0; i < l; i++) {
            text[i] = characters.charAt(r.nextInt(characters.length()));
        }

        return new String(text);
    }
}