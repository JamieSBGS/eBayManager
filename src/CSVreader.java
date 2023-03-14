import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
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
    String CSVname = fileNameInput();
    try{
      
    }catch(IOException c){
      c.printStackTrace();
    }
    
    
  }
}