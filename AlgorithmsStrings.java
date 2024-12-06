import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AlgorithmsStrings {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("words.txt");
        int twoLetter = twoLetter();
        int numLong = numLongest();
        int numPal = numPalindromes();

        System.out.print("Number of two letter words: ");
        System.out.println(twoLetter);
        System.out.print("Number of longest letter words: ");
        System.out.println(numLong);
        System.out.print("Number of palindromes: ");
        System.out.println(numPal);
        s.close();
    }

    public static int twoLetter() throws FileNotFoundException{
        s = new Scanner(f);
        int twoLetter = 0;
        while(s.hasNext()){
            String nextWord = s.nextLine();
            if(nextWord.length() == 2){
                twoLetter++;
                // System.out.println(nextWord);
            }
        }
        return twoLetter;
    }

    public static int numLongest() throws FileNotFoundException{
        s = new Scanner(f);
        int count = 0;
        int longLength = 0;
        while(s.hasNext()){
            String nextWord = s.nextLine();
            int length = nextWord.length();
            if(length > longLength){
                count = 0;
                longLength = length;
                //System.out.println(longLength);
            }
            if(length == longLength){
                count++;
                //System.out.println(nextWord);
            }
        }
        return count;
    }

    public static int numPalindromes() throws FileNotFoundException{
        s = new Scanner(f);
        int numPal = 0;
        while(s.hasNext()){
            String nextWord = s.nextLine();
            String firstHalf = nextWord.substring(0, nextWord.length()/2);
            String secondHalf = "";
            for(int i=1;i<=nextWord.length()/2;i++){
                secondHalf += nextWord.substring((nextWord.length())-i, (nextWord.length())-i+1);
            }
            if(firstHalf.equals(secondHalf)){
                numPal++;
                System.out.println(nextWord);
            }
        }
        return numPal;
    }
}