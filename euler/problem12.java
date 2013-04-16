/*
 * Author: Brandon Foster
 * Date: 12/25/2012
 * Problem:
 * 
 */
package euler;


public class problem12 {
    public static void main(String[] args){
        int tNum = 0;
        int i = 1;
        int iHolder = 0;
        int divCount = 0;
        boolean isSearching = true;
        while(isSearching){
            
            tNum = (i * (i + 1)) / 2;

            divCount = 0;
            
            for(int g = 1; g <= tNum; g++){
                if(tNum % g == 0){
                    divCount++;
                }
            }

            System.out.println(tNum + " " + divCount);
       
            if(divCount > 500){
                System.out.println("\t\t" + tNum + " " + divCount);
                isSearching = false;
            }

            
            i++;
        }
    }
}
