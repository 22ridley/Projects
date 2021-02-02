import java.util.*;
import java.io.*;

/**
 * SubWordFinder is a class that creates a dictionary of words from a given text file by using 26
 * buckets, one for each letter, to make it easier to find words. Then, for every word in each bucket,
 * it word is split in each possible spot to find the subwords contained in the word, and then the
 * entire subword, including the root word, front word, and back word are added to an ArrayList of
 * SubWord objects. The most common subwords are then printed, and all the subwords are printed into
 * sarah_subwords.txt file.
 * @author 22ridley
 * @version 02/02/2021
 */

public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;
    private String alpha;

    /**
     * Constructor for SubWordFinder class
     * Creates the alpha string, makes a bucket for each letter, and populates the buckets
     */
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
            in = new Scanner(new File("subwords/words_all_os.txt"));
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
        mostSubWords(subwords);
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

    // Recursive indexOf method, binary searches the correct bucket to find a word
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
     * This is how I compared the output from my program to the correct output files
     * @param arr An array of SubWords generated in the main method
     */
    public void filePrinter(ArrayList<SubWord> arr) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("subwords/sarah_subwords.txt"));
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
     * EXTRA
     * mostSubWords is a method called in the getSubWords method that goes through the array of SubWords
     * and maps each root word into a dictionary that stores a String key (the word) and an Integer value
     * (number of combos), increasing its value each time it finds another combo using the root word,
     * then finds the highest number of appearances of any one root word, and prints every root word
     * with that many appearances.
     * @param subwords An array of SubWords whose root words are counted to see how many combos they have
     */
    public void mostSubWords(ArrayList<SubWord> subwords) {
        HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
        for (int j = 0; j < subwords.size(); j++) {
            String word = subwords.get(j).getRoot();
            if (freqMap.containsKey(word)) {
                int num = freqMap.get(word);
                freqMap.replace(word, num+1);
            }
            else {
                freqMap.put(word, 1);
            }
        }
        int frequency = 0;
        System.out.print("The words: ");
        for (String key : freqMap.keySet()) {
            if(freqMap.get(key) > frequency) {
                frequency = freqMap.get(key);
            }
        }
        for (String key : freqMap.keySet()) {
            if(freqMap.get(key) == frequency) {
                System.out.print(key + ", ");
            }
        }
        System.out.println("can all make " + frequency + " different subword combinations.");
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
