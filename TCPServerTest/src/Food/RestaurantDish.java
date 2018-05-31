/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Food;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class RestaurantDish implements Serializable{
    private String dishName;
    private double price;
    private ArrayList<String> commendOfDish;
    private int point;
   private static final long serialVersionUID = 1L;

  /*  public static long getSerialVersionUID() {
        return serialVersionUID;
    }
      */
    public String getDishName() {
        return dishName;
    }

    public ArrayList<String> getCommendOfDish() {
        return commendOfDish;
    }

    public void setCommendOfDish(ArrayList<String> commendOfDish) {
        this.commendOfDish = commendOfDish;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString()
    {
        return dishName;
    }
}
