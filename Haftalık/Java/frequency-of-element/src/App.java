import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        int numbers[] = {10, 20, 20, 10, 10, 20, 5, 20};

        System.out.print("[");
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + ",");
        System.out.print("]\n");

        Map<Integer, Integer> frekanslar = getFrequency(numbers);

        for (Map.Entry<Integer, Integer> entry : frekanslar.entrySet()) {
            int eleman = entry.getKey();
            int frekans = entry.getValue();
            System.out.println(eleman + " elemanı " + frekans + " kez tekrarlanıyor.");
        }
    }
    public static Map<Integer, Integer> getFrequency(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int item : array) {
            if (frequencyMap.containsKey(item)) {
                int oldFrequency = frequencyMap.get(item);
                frequencyMap.put(item, oldFrequency + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }

        return frequencyMap;
    }
}
