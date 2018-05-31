/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import Food.Order;
import business.Enterprise.Enterprise;
import business.Enterprise.Restaurant;
import business.UserAccount.UserAccount;
import Address.Address;
import Food.FoodServe;
import java.io.Serializable;
//import java.util.Objects;

/**
 *
 * @author liuch
 */
public class FoodOrderRequest extends WorkRequest implements Serializable{
    Order order;
    Restaurant receiver;
   // private static int count = 1;
   // private int FoodOrderID;
   private static final long serialVersionUID = 1L;

  /*  public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
      
   /* public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        FoodOrderRequest.count = count;
    }

    public int getFoodOrderID() {
        return FoodOrderID;
    }

    public void setFoodOrderID(int FoodOrderID) {
        this.FoodOrderID = FoodOrderID;
    }
    */
   public FoodOrderRequest(Restaurant restaurant)
    {
        super(RequestType.FoodOrderRequest);
        order = new Order();
        receiver = restaurant;
     //   this.FoodOrderID = count;
       // count++;
        
    }

    public Order getOrder() {
        return order;
    }

    

    public void setOrder(Order order) {
        this.order = order;
    }
/*
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.order);
        return hash;
    }
*/
   /* @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FoodOrderRequest other = (FoodOrderRequest) obj;
        return true;
    }*/
public  int returnSize(){
    int size = 0;
    for(FoodServe f:order.getOrderList())
    {
        size = size +f.getNumber();
    }
    for(FoodServe f:order.getDiscountFoodList())
    {
        size = size+f.getNumber();
    }
    return size;
}
    public Restaurant getReceiver() {
        return receiver;
    }
public WorkQueue getReceiverWorkQueue()
{
    return receiver.getFoodOrderqueue();
}
    public void setReceiver(Restaurant receiver) {
        this.receiver = receiver;
    }
    
  /*  @Override
    public String toString()
    {
        return String.valueOf(FoodOrderID);
    }*/
    
}
