import java.util.Scanner;
import  java.util.ArrayList;
public class item {
    private String itemName;
    private float price;
    private int stockNum;
    private String itemType;
  
    public item(String itemName, float price, int stockNum, String itemType) {
        this.itemName = itemName;
        this.price = price;
        this.stockNum = stockNum;
        this.itemType = itemType; 
    }

    public item(String csv){
      String[] fields = csv.split(",");
      String name = fields[1];
      int id = Integer.parseInt(fields[0]);
    }
  
  @Override
  public String toString(){
    return itemName + " , "+ price + " , "+ stockNum + " , "+ itemType;
  }
  
  public String getItemName(){
    return itemName;
  }
  public float getPrice(){
    return price;
  }
  public int getStockNum(){
    return stockNum;
  }
  public String getItemType(){
    return itemType;
  }
}
