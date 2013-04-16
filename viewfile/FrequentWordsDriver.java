/*
 * Author: Brandon Foster
 * Date: 01/04/2013
 * Purpose:
 * count the frequency of words in a text file and return the top five
 * most frequent words
 */
package viewfile;


public class FrequentWordsDriver {
    public static void main(String[] args){
        FrequentWords fw = new FrequentWords("fightclub.txt");
        fw.listTop(5);
    }
}
