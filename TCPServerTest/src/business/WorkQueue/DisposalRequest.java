/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.Enterprise.BioFactory;
import business.Enterprise.Restaurant;
import business.Organization.EnterpriseLevelOrganization;
import java.io.Serializable;

/**
 *
 * @author sunwen
 */
public class DisposalRequest extends WorkRequest implements Serializable{
    private double weight;
    private BioFactory receiver;
    private Restaurant sendRestaurant;
    private EnterpriseLevelOrganization sendOrganization;
    //private static int count = 1;
    //private int DisposalID;
   private static final long serialVersionUID = 1L;

  /*  public static long getSerialVersionUID() {
        return serialVersionUID;
    }
      */
    public DisposalRequest(double weight, BioFactory receiver) {
        super(RequestType.DisposalRequest);
        this.weight = weight;
        this.receiver = receiver;
      //  DisposalID = count;
       // count++;
    }

    public EnterpriseLevelOrganization getSendOrganization() {
        return sendOrganization;
    }

    public void setSendOrganization(EnterpriseLevelOrganization sendOrganization) {
        this.sendOrganization = sendOrganization;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BioFactory getReceiver() {
        return receiver;
    }

    public void setReceiver(BioFactory receiver) {
        this.receiver = receiver;
    }

   /* public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        DisposalRequest.count = count;
    }

    public int getDisposalID() {
        return DisposalID;
    }

    public void setDisposalID(int DisposalID) {
        this.DisposalID = DisposalID;
    }*/

    public Restaurant getSendRestaurant() {
        return sendRestaurant;
    }

    public void setSendRestaurant(Restaurant sendRestaurant) {
        this.sendRestaurant = sendRestaurant;
    }  
    
  /*  @Override
    public String toString()
    {
        return String.valueOf(DisposalID);
    }
*/
    @Override
    public int returnSize() {
        return 1; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WorkQueue getReceiverWorkQueue() {
        return receiver.getRequestQueue(); //To change body of generated methods, choose Tools | Templates.
    }
}
