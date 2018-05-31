/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Food;

import java.io.Serializable;
import java.util.Date;
import picutill.OnlineDish;

/**
 *
 * @author liuch
 */
public class FoodServe implements Serializable {
    //private RestaurantDish dish;
    OnlineDish onlineDish;
    private int number;
    private Date date;
 private static final long serialVersionUID = 1L;

   /* public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
      
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
 /*   public FoodServe(RestaurantDish dish,int number)
    {
        this.dish = dish;
        this.number = number;
    }
*/
      public FoodServe(OnlineDish dish,int number)
    {
        this. onlineDish = dish;
        this.number = number;
    }
   
    public OnlineDish getDish() {
        return onlineDish;
    }

    public void setDish(OnlineDish dish) {
        this.onlineDish = dish;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString()
    {
        return onlineDish.getName();
    }

    public OnlineDish getOnlineDish() {
        return onlineDish;
    }

    public void setOnlineDish(OnlineDish onlineDish) {
        this.onlineDish = onlineDish;
    }
}
