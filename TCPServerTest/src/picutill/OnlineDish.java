/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picutill;

import java.io.Serializable;

/**
 *
 * @author liuch
 */
public class OnlineDish implements Serializable {
    private int id;
    private String Name;
    private double Price;
    private byte[] pic;
     private static final long serialVersionUID = 1L;
      
    public OnlineDish(int id, String Name,double Price, byte[] pic)
    {
        this.id = id;
        this.Name = Name;
        this.pic = pic;
        this.Price = Price;
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
    public String toString()
    {
        return Name;
    }
}
