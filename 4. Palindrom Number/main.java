import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigInteger;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            try {
                String num = sc.nextLine();
                if(num == "-1"){
                    break;
                }
                System.out.println(palindrome(num));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    private static String palindrome(String num){
        if(new StringBuilder(num).reverse().toString().equals(num)){
            num = String.valueOf(new BigInteger(num).add(new BigInteger("1")));
        }
        if(new StringBuilder(num).reverse().toString().equals(num)){
            return num;
        }
        int numLength = num.length();
        if(numLength == 1){
            return String.valueOf(new BigInteger(num).add(new BigInteger("1")));
        }
        if(numLength % 2 == 0){
            String left = num.substring(0,numLength/2);
            String leftReversed = String.valueOf(new StringBuilder(left).reverse());
            String right = num.substring((numLength/2), numLength);
            if((new BigInteger(leftReversed).compareTo(new BigInteger(right)) >= 0 ? true : false)){
                return left  + leftReversed;
            }
            else {
                left = String.valueOf (new BigInteger(left).add(new BigInteger("1")));
                leftReversed = String.valueOf(new StringBuilder(left).reverse());
                return left+leftReversed;
            }
        }
        else {
            String left = num.substring(0,numLength/2);
            String middle = num.substring((numLength/2), (numLength/2)+1);
            String leftReversed = String.valueOf(new StringBuilder(left).reverse());
            String right = num.substring((numLength/2)+1, numLength);
            if(Long.valueOf(middle) != 9){
                if((new BigInteger(left).compareTo(new BigInteger(right)) > 0 ? true : false)){
                    if((new BigInteger(leftReversed).compareTo(new BigInteger(right)) > 0 ? true : false)){
                        return left + middle + leftReversed;
                    }
                    else {
                        return left + String.valueOf(new BigInteger(middle).add(new BigInteger("1"))) + leftReversed;
                    }
                }
                else {
                    return left + String.valueOf(new BigInteger(middle).add(new BigInteger("1"))) + leftReversed;
                }
            }
            else {
                left = String.valueOf(new BigInteger(left).add(new BigInteger("1")));
                leftReversed = String.valueOf(new StringBuilder(left).reverse());
                middle = "0";
                return left + middle + leftReversed;
            }
        }
    }
}