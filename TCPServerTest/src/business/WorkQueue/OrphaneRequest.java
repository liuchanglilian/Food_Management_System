/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import Food.Order;
import Network.Network;
import business.Enterprise.Enterprise;
import business.Enterprise.Orphane;
import java.io.Serializable;

/**
 *
 * @author liuch
 */
public class OrphaneRequest extends WorkRequest implements Serializable{
    //Order order;
   // Enterprise receiver;
     Network receiver;
    int numberOfFood;
    Orphane orphane;
    Enterprise enterprise;
   // private static int count = 1;
    //private int FoodOrderID;
   private static final long serialVersionUID = 1L;

  /*  public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
    /*  
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        OrphaneRequest.count = count;
    }*/
    
    public OrphaneRequest(Network network,Orphane orphane)
    {
        super(RequestType.OrphaneRequest);
        //order = new Order();
       // receiver = e;
       this.orphane = orphane;
        this.receiver = network;
      //  this.FoodOrderID = count;
        //count++;
    }

    public Network getReceiver() {
        return receiver;
    }

    public void setReceiver(Network receiver) {
        this.receiver = receiver;
    }

    public Orphane getOrphane() {
        return orphane;
    }

    public void setOrphane(Orphane orphane) {
        this.orphane = orphane;
    }

   
   /* public int getFoodOrderID() {
        return FoodOrderID;
    }

    public void setFoodOrderID(int FoodOrderID) {
        this.FoodOrderID = FoodOrderID;
    }*/
    
    public int returnSize()
    {
        return numberOfFood;
    }
    public int getNumberOfFood() {
        return numberOfFood;
    }

    public void setNumberOfFood(int numberOfFood) {
        this.numberOfFood = numberOfFood;
    }

   public Enterprise approvedEnterprise()
   {
       return enterprise;
   }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

   
 /*   
    @Override
    public String toString()
    {
        return String.valueOf(FoodOrderID);
    }
*/
    @Override
    public WorkQueue getReceiverWorkQueue() {
        return receiver.getQueueOphan();//To change body of generated methods, choose Tools | Templates.
    }
    
}
