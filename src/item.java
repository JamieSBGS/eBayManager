import java.util.Scanner;
import  java.util.ArrayList;
public class item {
    private String itemName;
    private float price;
    private int stockNum;
    private String itemType;
    private double itemID;
  
    public item(String itemName, float price, int stockNum, String itemType, double itemID) {
        this.itemName = itemName;
        this.price = price;
        this.stockNum = stockNum;
        this.itemType = itemType;
        this.itemID = itemID;
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
  public double getItemID(){
    return itemID;
  }
}
