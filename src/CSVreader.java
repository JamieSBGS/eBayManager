import java.io.FileReader;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
public class CSVreader{
  public static String fileNameInput(){
    Scanner CSVNameInput = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Insert File Name:");
    System.out.println("File name MUST include .csv at the end to be read successfully.");
    String CSVfileName = CSVNameInput.nextLine();
    return CSVfileName;
  }
  public static final String delimiter = ",";
  
  public static void readCSV(){
    try{
         String CSVname = fileNameInput();
         String[] tempArray = new String[4];
         int listIndex = 0;
         FileReader fr = new FileReader(CSVname);
         BufferedReader br = new BufferedReader(fr);
         String line = "";
         while((line = br.readLine()) != null) {
            tempArray = line.split(delimiter);
            for(String tempStr : tempArray) {
               System.out.print(tempStr + " ");
            }
            System.out.println();
         }
         br.close();
    }catch(IOException c){
      c.printStackTrace();
    }
    
    
  }
}