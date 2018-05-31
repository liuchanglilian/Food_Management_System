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
public class Menu implements Serializable {

    private ArrayList<RestaurantDish> menuList;
    private static final long serialVersionUID = 1L;

    public Menu() {
        this.menuList = new ArrayList<>();
    }

    public void addMenu(RestaurantDish rd) {
        menuList.add(rd);
    }

    public ArrayList<RestaurantDish> getMenuList() {
        return menuList;
    }

    public void setMenu(ArrayList<RestaurantDish> menu) {
        this.menuList = menu;
    }

    public void setMenuList(ArrayList<RestaurantDish> menuList) {
        this.menuList = menuList;
    }

}
