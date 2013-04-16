/*
 * Author: Brandon Foster
 * Date: 01/04/2013
 * Purpose:
 * count the frequency of words in a text file and return the top five
 * most frequent words
 */
package viewfile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;


public class FrequentWords {
    
    String textFileName;
    //we will catch each token in a String Buffer
    StringBuffer newToken = new StringBuffer();
    //will catch the filtered word from a regexp
    StringBuffer filteredWord = new StringBuffer();
    //to catch frequencies from the hash map
    StringBuffer frequencySB = new StringBuffer();
    //we will store each unique word in a hashmap and
    //associate a the frequency value to each unique string
    HashMap words = new HashMap();
    int frequencyInt;
    //top five
    
    HashMap topWords = new HashMap();
    ArrayList<String> exceptions = new ArrayList();
    boolean isException = false;
    private void loadExceptions(){
        exceptions.add("TO");
        exceptions.add("THE");
        exceptions.add("OF");
        exceptions.add("A");
        exceptions.add("HE");
        exceptions.add("IN");
        exceptions.add("IT");
        exceptions.add("HAD");
        exceptions.add("FOR");
        exceptions.add("THAT");
        exceptions.add("THEY");
        exceptions.add("AT");
        exceptions.add("WITH");
        exceptions.add("AS");
        exceptions.add("BUT");
        exceptions.add("WOULD");
        exceptions.add("FROM");
        exceptions.add("HIS");
        exceptions.add("IS");
        exceptions.add("TO");
        exceptions.add("AND");
        exceptions.add("WAS");
        exceptions.add("ON");
        exceptions.add("");
        exceptions.add("WERE");
        exceptions.add("HIM");
        exceptions.add("BE");
        exceptions.add("AN");
        exceptions.add("INTO");
        exceptions.add("NOT");
        exceptions.add("BY");
        exceptions.add("HAVE");
        exceptions.add("THIS");
        exceptions.add("ALL");
        exceptions.add("THIS");
        exceptions.add("WHICH");
        exceptions.add("I");
        exceptions.add("MY");
        exceptions.add("ME");
        exceptions.add("YOUR");
        exceptions.add("WE");
        exceptions.add("OUT");
        exceptions.add("OR");
        exceptions.add("IF");
        exceptions.add("ARE");
        exceptions.add("SO");
        exceptions.add("DONT");
        
    }
    
    
    public FrequentWords(){
        //when no file name is specified in instantiation, the default file name
        //is .txt
        textFileName = ".txt";
    }
    public FrequentWords(String textFile){
        //when you instantiate your class, the passed argument is
        //the name of the file you want to count frequencies of
        textFileName = textFile;
    }
    
    public void listTop(int numberOfTopWords){
        try{
            int[] topFrequencies = new int[numberOfTopWords];
            
            File file = new File(textFileName);
            //make scanner object to read the file
            Scanner read = new Scanner(file);

            //clearing the hash map in case a previous execution of this
            //method didn't clear it already
            if(!words.isEmpty()){
                words.clear();
            }
            
            //loads an arraylist of exceptions of candidacy of most frequent words
            loadExceptions();
            //processing the text file by tokens
            while(read.hasNext()){

                if(newToken.length() > 0){
                        newToken.delete(0, newToken.length());
                    }

                //extracting the next token
                newToken.append(read.next());

                //System.out.print(newToken.toString());

                //we want to purify anything we catch into a real word
                //using regular expressions, 
                //keeping it in the filtered word string buffer
                filteredWord.delete(0, filteredWord.length());

                filteredWord.append(newToken.toString().replaceAll("[^A-Za-z]", ""));
                
                //refresh isException variable
                isException = false;
                //check to see if 
                for(int i = 0; i < exceptions.size(); i++){
                    isException = filteredWord.toString().toUpperCase().equals(exceptions.get(i).toUpperCase());
                    if(isException){
                        break;
                    }
                }
                //System.out.println(" " + filteredWord.toString());
                if(!isException){
                //if there is no word already accounted for in our hash map,
                if(!words.containsKey(filteredWord.toString().toUpperCase())){
                    //we will create one and associate the value 1 for its first
                    //frequency
                    words.put(filteredWord.toString().toUpperCase(), 1);

                }else{//if not the first time this word is seen,
                    //clear the frequency string buffer
                    frequencySB.delete(0, frequencySB.length());
                    //accept the current word's frequency in the string buffer
                    frequencySB.append(words.get(filteredWord.toString().toUpperCase()));
                    //parse the string of this string buffer into an intege
                    frequencyInt = Integer.parseInt(frequencySB.toString());
                    //iterate the frequency
                    frequencyInt++;
                    //check to see if this frequency is the highest we've seen so far
                    for(int i = 0; i < topFrequencies.length; i++){
                        if(frequencyInt > topFrequencies[i]){
                            topFrequencies[i] = frequencyInt;
                            System.out.println(i + " " + frequencyInt + " " + filteredWord.toString().toUpperCase());
                            topWords.put(i, filteredWord.toString().toUpperCase());
                            //if(topWords[i].length() > 0){
                           //     topWords[i].delete(0, topWords[i].length());
                           // }
                           // topWords[i].append(filteredWord.toString());
                            break;
                        }
                    }
                    
                    //put it back in the hashmap
                    words.put(filteredWord.toString().toUpperCase(), frequencyInt);
                }
                }//end of word exceptions condition


            }
            //after processing, spit out the results
            System.out.println(words.toString());

            //let's show the top five results
            System.out.println(topWords.toString());

        }catch(IOException ioe){
            System.err.println("Uh oh, bats in the belfry: \n" + ioe);
        }
        
    }
    
    
}
