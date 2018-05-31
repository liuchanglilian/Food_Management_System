/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import Food.Order;
import business.Enterprise.Enterprise;
import business.Enterprise.Restaurant;
import business.Enterprise.SuperMarket;
import business.UserAccount.UserAccount;
import java.util.ArrayList;
import SuperMarketItem.SuperMarketItem;
import SuperMarketItem.SuperMarketServe;
import java.io.Serializable;

/**
 *
 * @author liuch
 */
public class SuperMarketOrderRequest extends WorkRequest implements Serializable {

    ArrayList<SuperMarketServe> itemList;
    SuperMarket receiver;
    private static final long serialVersionUID = 1L;

    public SuperMarketOrderRequest(SuperMarket s) {
        super(RequestType.SuperMarketOrderRequest);
        itemList = new ArrayList<>();
        receiver = s;

    }

    public ArrayList<SuperMarketServe> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<SuperMarketServe> itemList) {
        this.itemList = itemList;
    }

    public Enterprise getReceiver() {
        return receiver;
    }

    public void setReceiver(SuperMarket receiver) {
        this.receiver = receiver;
    }

    public WorkQueue getReceiverWorkQueue() {
        return receiver.getFoodOrderqueue();
    }

    public int returnSize() {
        return itemList.size();
    }

}
