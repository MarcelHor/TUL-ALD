import java.util.*;
import java.util.stream.Collectors;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> uniqueNumbers = new TreeMap<>();
        while (sc.hasNextLine()){
            String input = sc.nextLine().trim();
            if(input.isEmpty()) break;
            int[] numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < numbers.length; i++) {
                int value = 1;
                if(uniqueNumbers.containsKey(numbers[i])){
                    value = uniqueNumbers.get(numbers[i]);
                    value++;
                }
                uniqueNumbers.put(numbers[i], value);
            }
        }
        System.out.println("all: "+ uniqueNumbers.keySet().toString().replaceAll("[\\[\\](){}]","").replaceAll("\\s+",""));
        System.out.println(">1x: " + uniqueNumbers.entrySet().stream().filter(entry -> entry.getValue() >= 2).map(Map.Entry::getKey).collect(Collectors.toSet()).toString().replaceAll("[\\[\\](){}]","").replaceAll("\\s+",""));
        System.out.println("=1x: " + uniqueNumbers.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toSet()).toString().replaceAll("[\\[\\](){}]","").replaceAll("\\s+",""));
    }
}
