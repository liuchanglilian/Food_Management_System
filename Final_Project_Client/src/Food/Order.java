/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Food;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author liuch
 */
public class Order implements Serializable {

    private ArrayList<FoodServe> orderList;
    private ArrayList<FoodServe> discountFoodList;
    private static final long serialVersionUID = 1L;

    public Order() {
        orderList = new ArrayList<>();
        discountFoodList = new ArrayList<>();
    }

    public ArrayList<FoodServe> getDiscountFoodList() {
        return discountFoodList;
    }

    public void setDiscountFoodList(ArrayList<FoodServe> discountFoodList) {
        this.discountFoodList = discountFoodList;
    }

    public ArrayList<FoodServe> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<FoodServe> orderList) {
        this.orderList = orderList;
    }

}
