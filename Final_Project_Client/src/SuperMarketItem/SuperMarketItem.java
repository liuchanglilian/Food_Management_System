/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMarketItem;

import java.io.Serializable;

/**
 *
 * @author liuch
 */
public class SuperMarketItem implements Serializable {

    private int id;
    private String Name;
    private int calorie;
    private double Price;
    private byte[] pic;
    private double discount;
    private int inventory;
    private int saleHistory;
    private static final long serialVersionUID = 1L;

    public SuperMarketItem(int id, String Name, int calorie, double Price, byte[] pic, double discount, int inventory, int saleHistory) {
        this.id = id;
        this.Name = Name;
        this.calorie = calorie;
        this.Price = Price;
        this.pic = pic;
        this.discount = discount;
        this.inventory = inventory;
        this.saleHistory = saleHistory;
    }

    public int getSaleHistory() {
        return saleHistory;
    }

    public void setSaleHistory(int saleHistory) {
        this.saleHistory = saleHistory;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return Name;
    }
}
