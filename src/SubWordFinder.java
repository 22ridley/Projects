import java.util.*;
import java.io.*;

public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;
    private String alpha;

    public SubWordFinder() {
        alpha = "abcdefghijklmnopqrstuvwxyz";
        dictionary = new ArrayList<>(alpha.length());
        for (int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * Populates the dictionary from the text file contents
     * The dictionary object should contain 26 buckets, each
     * bucket filled with an ArrayList<String>
     * The String objects in the buckets are sorted A-Z because
     * of the nature of the text file words.txt
     */
    public void populateDictionary() {
        Scanner in = null;
        try {
            String word;
            in = new Scanner(new File("subwords/new_scrabble.txt"));
            while (in.hasNext()) {
                word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            for(ArrayList<String> bucket : dictionary)
                Collections.sort(bucket);
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve all SubWord objects from the dictionary.
     * A SubWord is defined as a word that can be split into two
     * words that are also found in the dictionary.  The words
     * MUST be split evenly, e.g. no unused characters.
     * For example, "baseball" is a SubWord because it contains
     * "base" and "ball" (no unused characters)
     * To do this, you must look through every word in the dictionary
     * to see if it is a SubWord object
     *
     * @return An ArrayList containing the SubWord objects
     * pulled from the file words.txt
     */
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subwords = new ArrayList<>();
        for (ArrayList<String> bucket : dictionary) {
            for (String word : bucket) {
                for (int index = 2; index <= word.length() - 2; index++) {
                    String front = word.substring(0, index);
                    String back = word.substring(index);
                    if (inDictionary(front) && inDictionary(back))
                        subwords.add(new SubWord(word, front, back));
                }
            }
        }
        return subwords;
    }


    /**
     * Look through the entire dictionary object to see if
     * word exists in dictionary
     *
     * @param word The item to be searched for in dictionary
     * @return true if word is in dictionary, false otherwise
     * NOTE: EFFICIENCY O(log N) vs O(N) IS A BIG DEAL HERE!!!
     * You MAY NOT use Collections.binarySearch() here; you must use
     * YOUR OWN DEFINITION of a binary search in order to receive
     * the credit as specified on the grading rubric.
     */
    public boolean inDictionary(String word) {
        ArrayList<String> bucket = dictionary.get(alpha.indexOf(word.charAt(0)));
        return indexOf(bucket, word, 0, bucket.size() -1) != -1;
    }

    // Recursive indexOf method
    private int indexOf(ArrayList<String> bucket, String word, int low, int high) {
        int mid = (low+high)/2;
        String item = bucket.get(mid);
        if(low > high)
            return -1;
        else   {
            if(word.compareTo(item) == 0)
                return mid;
            else if(word.compareTo(item) < 0)
                return indexOf(bucket, word, low, mid-1);
            else
                return indexOf(bucket, word, mid+1, high);
        }
    }

    /**
     * filePrinter is a method that prints the array of SubWords to a file
     * @param arr An array of SubWords generated in the main method
     */
    public void filePrinter(ArrayList<SubWord> arr) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("subwords/printed.txt"));
            for (SubWord combo : arr) {
                pw.println(combo);
            }
            pw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main method for class SubWordFinder
     * @param args Command line arguments if needed
     */
    public static void main(String[] args) {
        SubWordFinder finder = new SubWordFinder();
        finder.filePrinter(finder.getSubWords());
    }
}
