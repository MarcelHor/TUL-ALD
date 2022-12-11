import java.util.Locale;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String word = sc.nextLine();
            if(new StringBuilder(word).reverse().toString().toUpperCase().equals(word.toUpperCase(Locale.ROOT))){
                System.out.println("ano");
            }
            else {
                System.out.println("ne");
            }
        }
    }
}