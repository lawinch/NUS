package plagiator;

import java.util.Scanner;

public class Utils {
    public static String getWords(String file) {
        Scanner s = new Scanner(file);
        String words = "";
        while (s.hasNext()) {
            words = words + s.next();
        }
        return words;
    }
}
