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
public class SuperMarketServe implements Serializable {

    private SuperMarketItem item;
    private int number;
    private static final long serialVersionUID = 1L;

    public SuperMarketItem getItem() {
        return item;
    }

    public void setItem(SuperMarketItem item) {
        this.item = item;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return item.getName();
    }
}
