/**
* File: Problem Set Unit 5
* Author: Weiya
* Date Created: May 26, 2026
* Date Last Modified: May 31, 2026
*/

import java.util.Scanner;
import java.util.HashMap;

public class TextAnalyzer {

	public static void main(String[] args) {
	    
	    Scanner input = new Scanner(System.in);
	    
	    //welcome message
	    System.out.println("Welcome to the Text Analyzer.\n");
	    
	    //user input
	    System.out.print("Please enter a sentence or paragraph: ");
	    String text = input.nextLine();
	    
	    //converting eeverything to lowercase
	    String str = text.toLowerCase();
	    
	    //removing punctuatuion
	    str = str.replace(",", "");
        str = str.replace(".", "");
        str = str.replace("!", "");
        str = str.replace("?", "");
        str = str.replace(";", "");
        str = str.replace(":", "");
	    
	    //character counter
	    int charCount = text.length();
        
	    //word counter
	    String[] words = str.split(" "); 
        int wordCount = words.length;
        
        // vowel counter
        int vowelCount = 0;
        
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            //check if character is a vowel
            if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                vowelCount++;
            }
        }
        
        //space counter
        int spaceCount = 0;
        
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        
        //word frequency hashmap
        HashMap<String, Integer> freq = new HashMap<String, Integer>();

        for (int i=0; i<words.length; i++) {

            String word = words[i];

            // check if word already exists 
            if (freq.containsKey(word)) {
                
                int currentCount = freq.get(word);
                freq.put(word, currentCount + 1);
            }
            else {
                // first occurrence
                freq.put(word, 1);
            }
        }
        
        //output results
        System.out.println("\nTotal Characters: " + charCount);
        System.out.println("Total Words: " + wordCount);
        System.out.println("Total Vowels: " + vowelCount);
        System.out.println("Total Spaces: " + spaceCount);

        System.out.println("\nWord Frequency:\n");

        //each word and its frequency 
        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            
            //ignore common words
            if (!(word.equals("the") || word.equals("a") || word.equals("an") ||
                  word.equals("and") || word.equals("is"))) {

                boolean firstTime = true;
                
                //check if the word is already printed
                for (int j=0; j<i&&firstTime; j++) {
                    if (words[j].equals(word)) {
                        firstTime = false;
                    }
                }

                if (firstTime) {
                    System.out.println(word + " - " + freq.get(word));
                }

            }
        }
        
    input.close();
	}
}
// i did to 90%, sorry im so behind :(
