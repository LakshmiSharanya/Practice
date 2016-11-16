
public class RecursionDemo {

    public static void main(String args[]) {
        String s = "Bhanu";
        System.out.println(search(s, 'a'));
    }

    private static boolean search(String word, char ch) {
        System.out.println(word);
        if (word == null || word.isEmpty()) {
            return false;
        }

        if (word.charAt(0) == ch)
            return true;
        else
            return search(word.substring(1), ch);
    }

}
