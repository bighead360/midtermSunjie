import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 5/17/16.
 */
public class Solutionb {


    public static HashSet<HashSet<String>> checkanagram(String[] text){
        HashSet<HashSet<String>> wordSet = new HashSet<HashSet<String>>();
    for (int i = 0; i< text.length; i++) {
        HashSet<String> pickup = new HashSet<String>();
        pickup.add(text[i]);

        for (int j = 1; j <= text.length-1; j++) {

            if (text[i].length() == text[j].length()) {

                char[] s1Array = text[i].toLowerCase().toCharArray();

                char[] s2Array = text[j].toLowerCase().toCharArray();

                Arrays.sort(s1Array);

                Arrays.sort(s2Array);

                //Checking whether s1Array and s2Array are equal

                if (Arrays.equals(s1Array, s2Array)) {
                    pickup.add(text[j]);

                }



            }


        }  wordSet.add(pickup);
        System.out.println(wordSet);
    }
        return wordSet;

    }

    public static void main(String[] args) {
        String[] text = {"cat", "boat","act", "obta","oabt", "money", "nomey", "michael"};
        HashSet<HashSet<String>> wordSet = new HashSet<HashSet<String>>();
        wordSet = checkanagram(text);
        System.out.println(wordSet);


    }


}
