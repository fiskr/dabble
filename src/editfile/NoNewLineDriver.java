/*
 * 2012-11-30
 * Driver to:
 * Convert .txt files into kindle friendly reading by removing unnecessary newlines
 */
package editfile;

import java.io.File;


public class NoNewLineDriver {
    
    
    
    public static void main(String[] args){
        String filename = "fightclub";
        File directory = new File("C:\\Users\\UserName\\Documents\\NetBeansProjects\\ProjectName");
        File[] files = directory.listFiles();
        
        for(int index = 0; index < files.length; index++){
            if(files[index].toString().matches("^.*txt$")){
                System.out.println(files[index].toString());
            }
            
        }
        NoNewLine nnl = new NoNewLine();
        nnl.convertFile(filename);
    }
}
