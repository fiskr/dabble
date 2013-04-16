/*
 * Author: Brandon Foster
 * Date: 12/25/2012
 * Problem: 
 *  The prime factors of 13195 are 5, 7, 13 and 29.
 *  What is the largest prime factor of the number 600851475143 ?
 */
package euler;

/**
 *
 * @author Brandon
 */
public class problem3Driver {
        public static void main(String[] args){

        final long NUMBER = 600851475143L;
        
        problem3 p3 = new problem3();
        
        p3.printPrime(NUMBER);

    
    }
}
