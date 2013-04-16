/*
 * Author: Brandon Foster
 * Date: 12/25/2012
 * Problem: 
 *  The prime factors of 13195 are 5, 7, 13 and 29.
 *  What is the largest prime factor of the number 600851475143 ?
 */
package euler;


public class problem3 {
    
    public problem3(){
        
    }
    
   protected void printPrime(long num){
       for(long i = 1L; i < num; i++){
            if(num % i == 0){
                
                if(isPrime(i)){
                    System.out.println("Prime: " + i);
                }
                //System.out.println("Divisor: " + i);
                //isPrime(i);
            }
        }
   }
    
   protected boolean isPrime(long number){
        int divisors = 0;
        for(long i = 1L; i < number || i <= Math.sqrt(number); i++){
            
            if(number % i == 0){
                System.out.println("Divisors of " + number + ": " + i);
                divisors++;
            }
            
        }
        if(divisors > 1){
            return false;
        }else{
            return true;
        }
        
        
    }
    

    


    
}
