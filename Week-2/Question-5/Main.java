import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        HashMap<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            boolean skip = false;
            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    skip = true;
                    break;
                }
            }
            if (skip) {
                continue;
            }
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        List<String> keys = new ArrayList<>(counts.keySet());
        keys.sort((left, right) -> counts.get(right) - counts.get(left));
        for (String key : keys) {
            System.out.println(key + ": " + counts.get(key));
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
