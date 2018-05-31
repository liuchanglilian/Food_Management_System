/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import Food.Order;
import business.Enterprise.Enterprise;
import business.Enterprise.Restaurant;
import business.Enterprise.SuperMarket;
import business.UserAccount.UserAccount;
import java.util.ArrayList;
import SuperMarketItem.SuperMarketItem;
import SuperMarketItem.SuperMarketServe;
import java.io.Serializable;

/**
 *
 * @author liuch
 */
public class SuperMarketOrderRequest extends WorkRequest implements Serializable {
    //Order order;
    ArrayList<SuperMarketServe> itemList;
    SuperMarket receiver;
   // private static int count = 1;
   // private int FoodOrderID;
   
    private static final long serialVersionUID = 1L;
      
    public SuperMarketOrderRequest(SuperMarket s)
    {
        super(RequestType.SuperMarketOrderRequest);
        itemList = new ArrayList<>();
        receiver = s;
      //  this.FoodOrderID = count;
        //count++;
    }

    public ArrayList<SuperMarketServe> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<SuperMarketServe> itemList) {
        this.itemList = itemList;
    }

    public Enterprise getReceiver() {
        return receiver;
    }

    public void setReceiver(SuperMarket receiver) {
        this.receiver = receiver;
    }

  /*  public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        SuperMarketOrderRequest.count = count;
    }*/
public WorkQueue getReceiverWorkQueue()
{
    return receiver.getFoodOrderqueue();
}
/*    public int getFoodOrderID() {
        return FoodOrderID;
    }

    public void setFoodOrderID(int FoodOrderID) {
        this.FoodOrderID = FoodOrderID;
    }*/

    public int returnSize()
    {
        return itemList.size();
    }
  /*    @Override
    public String toString()
    {
        return String.valueOf(FoodOrderID);
    }*/
}
