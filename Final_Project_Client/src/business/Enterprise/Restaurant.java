/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import Food.FoodServe;
import Food.Menu;
import Food.RestaurantDish;
import Role.RestaurantManagerRole;
import SuperMarketItem.SuperMarketItem;
import SuperMarketItem.SuperMarketServe;
import business.Organization.Organization;
import business.Organization.RestaurantWorkersOrganization;
import business.Person.Person;
import business.UserAccount.UserAccount;
import business.WorkQueue.FoodOrderRequest;
import business.WorkQueue.WorkQueue;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author liuch
 */
public class Restaurant extends Enterprise implements Serializable {

    private WorkQueue queueOphan;
    private ArrayList<FoodServe> unfreshfoodList;
    private WorkQueue foodOrderqueue;
    private transient Connection con;
    private double leftover;
    private ArrayList<SuperMarketServe> rawfoodList;
    private int mark = 1;
    private int markTimes;
    private static final long serialVersionUID = 1L;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getName() {
        return name;
    }

    public void makeMark(int newMark) {

        mark = (mark * markTimes + newMark) / (markTimes + 1);
        markTimes = markTimes + 1;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant(String name, String personName, String userName, String password) {

        super(name, EnterpriseType.Restaurant, personName, userName, password);
        super.userAccount.setRole(new RestaurantManagerRole());
        this.queueOphan = new WorkQueue();
        this.foodOrderqueue = new WorkQueue();
        unfreshfoodList = new ArrayList<>();
        rawfoodList = new ArrayList<>();
        leftover = 0;
        this.mark = 1;
        markTimes = 0;
        createTable();
    }

    public ArrayList<SuperMarketServe> getRawfoodList() {
        return rawfoodList;
    }

    public void setRawfoodList(ArrayList<SuperMarketServe> rawfoodList) {
        this.rawfoodList = rawfoodList;
    }

    public void getConnection() throws SQLException {
        String DB_URL = "jdbc:mysql://35.185.14.219:3306/new_schema";
        String DB_DRV = "com.mysql.jdbc.Driver";
        String DB_USER = "root";
        String DB_PASSWD = "8466";
        con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

    }

    public void createTable() {
        try {
            getConnection();
            String query1 = "CREATE TABLE IF NOT EXISTS new_schema.`" + userAccount.getUsername() + "`(`id` INT NOT NULL AUTO_INCREMENT,`Name` VARCHAR(45) NULL DEFAULT NULL,`Price` DOUBLE NULL DEFAULT NULL,`pic` LONGBLOB NULL DEFAULT NULL,PRIMARY KEY (`id`));";
            Statement st = (Statement) con.createStatement();
            st.executeUpdate(query1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
        }

    }

    public void addToUnfreshList(ArrayList<FoodServe> foodList) {
        unfreshfoodList.addAll(foodList);
    }

    public boolean checkFresh(FoodServe food) {
        Date now = new Date();
        if ((now.getTime() - food.getDate().getTime()) > 3 * 60 * 1000) {
            return false;
        } else {
            return true;
        }

    }

    public ArrayList<FoodServe> returnStillEatableUnfreshFoodList() {
        ArrayList<FoodServe> stillEatable = new ArrayList<>();
        for (FoodServe f : unfreshfoodList) {
            if (checkFresh(f)) {
                stillEatable.add(f);
            }

        }
        return stillEatable;
    }

    public ArrayList<FoodServe> returnNotEatableUnfreshFoodList() {
        ArrayList<FoodServe> notEatable = new ArrayList<>();
        for (FoodServe f : unfreshfoodList) {
            if (checkFresh(f)) {
                notEatable.add(f);
            }

        }
        return notEatable;
    }

    public double getLeftover() {
        return leftover;
    }

    public void setLeftover(double leftover) {
        this.leftover = leftover;
    }

    public ArrayList<FoodServe> getUnfreshfoodList() {
        return unfreshfoodList;
    }

    public void setUnfreshfoodList(ArrayList<FoodServe> unfreshfoodList) {
        this.unfreshfoodList = unfreshfoodList;
    }

    public WorkQueue getFoodOrderqueue() {
        return foodOrderqueue;
    }

    public void setFoodOrderqueue(WorkQueue foodOrderqueue) {
        this.foodOrderqueue = foodOrderqueue;
    }

    public WorkQueue getQueueOphan() {
        return queueOphan;
    }

    public void setQueueOphan(WorkQueue queueOphan) {
        this.queueOphan = queueOphan;
    }

    @Override
    public ArrayList<Organization> getSupportedOrganization() {
        ArrayList<Organization> list = new ArrayList<Organization>();
        list.add(new RestaurantWorkersOrganization());
        return list;

    }

    public UserAccount authanticate(String name, String password) {
        return userAccount.checkAccount(name, password);
    }
}
