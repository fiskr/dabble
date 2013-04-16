/*
 * Author: Brandon Foster
 * Date: 12/25/2012
 */
package euler;


public class problem2 {
    public static void main(String[] args){
        int sum = 0;
        int prevcar = 0;
        int cdr = 1;
        int car = 1;
        while(car < 4000000){
            
            prevcar = car;
            
            car = car + cdr;
            
            if(car > 4000000){
                break;
            }
            if(car % 2 == 0){
                sum += car;
            }
            cdr = prevcar;
            
            System.out.println(car + "\n");
            
            
        }
        
        System.out.println("Sum: " + sum);
    }
}
