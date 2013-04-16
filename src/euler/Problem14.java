/*
 * Author: fiskr
 * Date: 12/30/2012
 * Problem:
 * The following iterative sequence is defined for the set of positive integers:
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) 
 *  contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 */
package euler;

public class Problem14 {
    public static void main(String[] args){
        //variable to count how many numbers are in a string.
        int chainLength = 0;
        //variable to hold the current value in the chain
        //this variable must be long, the numbers it will hold get pretty big
        long chainVal = 0;
        //variable to hold the largest chain length
        int highestChain = 0;
        //variable to hold the largest chain's starting number
        int answer = 0;
        
        //we will loop through each starting number to find the starting number
        //with the longest chain
        for(int i = 500000; i < 1000000; i++){
            chainLength = 1;
            System.out.println("\n\n" + "\n" + i);
            //to start off, if our first number in the chain is even
            if(i % 2 == 0){
                //n → n/2 (n is even)
                chainVal = i/2;
                chainLength++;
                //System.out.println(chainVal + " " + chainLength);
            }else{
                //n → 3n + 1 (n is odd)
                chainVal = (3 * i) + 1;
                chainLength++;
                //System.out.println(chainVal + " " + chainLength);
            }
            //we will continue the chain until the last number is 1
            while(chainVal != 1){
                if(chainVal % 2 == 0){
                    chainVal = chainVal/2;
                    chainLength++;
                    //System.out.println(chainVal + " " + chainLength);
                }else{
                    chainVal = (3 * chainVal) + 1;
                    chainLength++;
                    //System.out.println(chainVal + " " + chainLength);
                }
            }
            if(chainLength > highestChain){
                highestChain = chainLength;
                answer = i;
            }
            System.out.println("Length: " + chainLength + "\nHighest: " + highestChain);
        }
        System.out.println("\t\tWith a length of " + highestChain + "\n\t\tthe Answer: " + answer);
    }
}
