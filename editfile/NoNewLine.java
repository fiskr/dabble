/*
 * 11/30/2012
 * Convert .txt files into kindle friendly reading by removing unnecessary newlines
 */
package editfile;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NoNewLine {
    
    public NoNewLine(){
        
    }
    
    public NoNewLine(String fileName){
        convertFile(fileName);
    }
    
    public void convertFile(String fileName){
        try{
            //take fileName as input to make File object so we can read it
            File oldFile = new File(fileName+".txt");
            
            //another file object to write the result
            File newFile = new File(fileName + "_edit.txt");
            
            //make scanner object to read this file
            Scanner read = new Scanner(oldFile);
            
            //make FileWriter to make the new file
            FileWriter writer = new FileWriter(newFile);
            
            StringBuffer currentToken = new StringBuffer();
            while(read.hasNext()){
                if(currentToken.length() > 0){
                    currentToken.delete(0, currentToken.length());
                }
                currentToken.append(read.next());
                //System.out.println(currentToken);
                if(currentToken.toString().toUpperCase().equals("CHAPTER")){
                    //System.out.println("LOOK, IT'S A NEW CHAPTER!");
                    
                    writer.write("\n");
                    writer.write(currentToken.toString() + read.nextLine());
                    writer.write("\n");
                }else{
                   writer.write(" " + currentToken.toString());
                    //System.out.println(currentToken);
                }
                    
                //clean the pipes (read buffer) for more output
                writer.flush();
            }
            System.out.println(currentToken.toString());
            writer.close();
            
        }catch(FileNotFoundException fnfe){
            System.out.print("File not found: " + fnfe);
            
        }
        catch(IOException ioe){
            System.out.print("I/O exception: " + ioe);
            
        }
        
        
        
    }
}
