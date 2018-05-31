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

/**
 *
 * @author liuch
 */
public class FoodOrderRequest extends WorkRequest implements Serializable {

    Order order;
    Restaurant receiver;
    boolean marked;
    private static final long serialVersionUID = 1L;

    public FoodOrderRequest(Restaurant restaurant) {
        super(RequestType.FoodOrderRequest);
        order = new Order();
        receiver = restaurant;
        marked = false;

    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int returnSize() {
        int size = 0;
        for (FoodServe f : order.getOrderList()) {
            size = size + f.getNumber();
        }
        for (FoodServe f : order.getDiscountFoodList()) {
            size = size + f.getNumber();
        }
        return size;
    }

    public Restaurant getReceiver() {
        return receiver;
    }

    public WorkQueue getReceiverWorkQueue() {
        return receiver.getFoodOrderqueue();
    }

    public void setReceiver(Restaurant receiver) {
        this.receiver = receiver;
    }

}
