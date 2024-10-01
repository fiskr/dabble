/*
 * Date: 2012-12-25
 * Problem:
 *  2520 is the smallest number that can be divided by 
 *  each of the numbers from 1 to 10 without any remainder.
 *  What is the smallest positive number that is evenly divisible by all of the
 *  numbers from 1 to 20?

 */
package euler;


public class problem5 {
    public static void main(String[] args){
        boolean isSearching = true;
        int i = 1;
        int count = 0;
        while(isSearching){
            count = 0;
            for(int z = 1; z < 21; z++){
                if(i % z == 0){
                    count ++;
                }
            }
            if(count == 20){
                System.out.println(i + " is divisible up to " + count);
                isSearching = false;
            }
            if(count > 10){
                System.out.println(i + " is divisible up to " + count);
                //isSearching = false;
            }
            i++;
        }
    }
}
