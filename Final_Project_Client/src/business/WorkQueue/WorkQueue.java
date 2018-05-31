/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class WorkQueue implements Serializable {

    private ArrayList<WorkRequest> workRequestList;
    private static final long serialVersionUID = 1L;

    public void setWorkRequestList(ArrayList<WorkRequest> workRequestList) {
        this.workRequestList = workRequestList;
    }

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}
