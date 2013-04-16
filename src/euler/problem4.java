/*
 * Author: Brandon Foster
 * Date: 12/25/2012
 * Problem:
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of 
 *      two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.

 */
package euler;

public class problem4 {
    public static void main(String[] args){
        
        //x and y represent the two digit numbers used to make the palindrome
        //p is the product of these two digits, and the potential palindrome
        int p = 0;
        //sb is the string buffer to reverse second half of product to eval
        StringBuffer sb = new StringBuffer();
        StringBuffer firstHalf = new StringBuffer();
        StringBuffer secondHalf = new StringBuffer();
        StringBuffer reversedSecondHalf = new StringBuffer();
        //int x = 999;
        //int y = 999;
        for(int x = 999; x > 0; x--){
            
            for(int y = 999; y > 0; y--){
		
                if(sb.length() > 0){
                    sb.delete(0, sb.length());
                    //System.out.println("Deleted sb");
                }
                		
                if(firstHalf.length() > 0){
                    firstHalf.delete(0, firstHalf.length());
                    //System.out.println("Deleted first half");
                }
                		
                if(secondHalf.length() > 0){
                    
                    secondHalf.delete(0, secondHalf.length());
                    
                    //System.out.println("Deleted second half");
                }
                
                
                if(reversedSecondHalf.length() > 0){
                    reversedSecondHalf.delete(0, reversedSecondHalf.length());
                    //System.out.println("Deleted reversedSecondHalf");
                }
                
                p = x * y;
                
                sb.append(p);
                if((sb.length()) % 2 == 0){
                    firstHalf.append(sb.substring(0, (sb.length()/2)));
                    secondHalf.append(sb.substring((sb.length()/2), sb.length()));
                    for(int f = secondHalf.length(); f > 0 ; f --){
                        reversedSecondHalf.append(secondHalf.charAt(f-1));
                    }
                    if(firstHalf.toString().equals(reversedSecondHalf.toString())){
                        System.out.println("\nX: " + x + 
                            "\nY: " + y +
                            "\nP: " + p +
                            "\nSB: " + sb +
                            "\nlength: " + sb.length() +
                            "\nFirst Half: " + firstHalf +
                            "\nSecond Half: " + secondHalf +
                            "\nReversed second half: " + reversedSecondHalf);
                        System.out.println("\n\n\nWE'VE GOT A WINNER GIRLS AND BOYS!!!!\n\n");
                        
                        
                    }

                    
                    
                }
                
            }
                
            
        }
    }
}
