import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fifo lifo = new Fifo();
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.isEmpty()) break;
            lifo.push(input);
        }
        while (!lifo.isEmpty()){
            System.out.println(capitalize(lifo.pop().value));
        }
    }
    public static String capitalize(String input) {
        String[] arr = input.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
}