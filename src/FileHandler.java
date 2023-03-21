import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class FileHandler{
  
  public static ArrayList<item> Products = new ArrayList<item>();

  public static ArrayList<item> getList(){
    return Products;
  }
  public static void clearList(){
    Products.clear();
  }
  
  public static void addItem(){
    Scanner UserInput = new Scanner(System.in);
    System.out.println("Insert Item name");
    String fieldItemName = UserInput.nextLine();
    System.out.println("Insert Price");
    float fieldPrice = Float.parseFloat(UserInput.nextLine());
    System.out.println("Insert how much of the item is in stock");
    int fieldStockNum = Integer.parseInt(UserInput.nextLine());
    System.out.println("Insert ItemType");
    String fieldItemType = UserInput.nextLine();
    item addedProduct = new item(fieldItemName, fieldPrice, fieldStockNum,fieldItemType);
    Products.add(addedProduct);
  }
  public static void displayProducts(){
    System.out.println("Item Name, Price, Stock Number, Item Type ");
    for (int i = 0; i < Products.size(); i++) {
            item itemIndex = Products.get(i);
            String itemToPrint = itemIndex.toString();
            System.out.println(itemToPrint + " ");
        }
  }
}