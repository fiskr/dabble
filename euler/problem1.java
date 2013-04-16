/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;


public class problem1 {
    public static void main(String[] args){
        //s represents the sum, which will ultimately serve to give use the sum of multiples of 3 and 5 below 1000
        int s = 0;
        for(int i = 0; i < 1000; i++){
            if(i % 3 == 0 || i % 5 == 0){
            s+=i;
            }

        }
        System.out.println("Final sum of multiples of 3 and 5 below 1000: " + s );
    }
}
