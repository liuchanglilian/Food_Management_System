/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.UserAccount.UserAccount;
import Address.Address;
import business.Enterprise.Enterprise;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author liuch
 */
public abstract class WorkRequest implements Serializable {

    private String message;
    private UserAccount sender;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private Address address;
    private UserAccount deliveryMan;
    private RequestType requestType;
    private static final long serialVersionUID = 1L;
    private static int count = 1;
    private int ID;

    /*public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
    public enum RequestType implements Serializable {
        DisposalRequest("DisposalRequest"), FoodOrderRequest("FoodOrderRequest"), OrphaneRequest("OrphaneRequest"), SuperMarketOrderRequest("SuperMarketOrderRequest");
        private String value;
        private static final long serialVersionUID = 1L;

        private RequestType(String value) {
            this.value = value;
        }

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;

        }

        @Override
        public String toString() {
            return value;
        }
    }

    public Address getAddress() {
        return address;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserAccount getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(UserAccount deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public WorkRequest(RequestType requestType) {
        requestDate = new Date();
        this.requestType = requestType;
        ID = count;
        count++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return message;
    }

    public abstract int returnSize();

    public abstract Object getReceiver();

    public void setMessage(String message) {
        this.message = message;
    }

    public abstract WorkQueue getReceiverWorkQueue();

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }
}
