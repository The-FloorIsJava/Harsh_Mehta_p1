package com.revature.P1.Service;

import com.revature.P1.Model.Reimbursement;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementService {

    List<Reimbursement> reimbursementList;

    public ReimbursementService(){
        reimbursementList = new ArrayList<>();
    }

    public void addReimbursementTicket(String userName, int ticketId, int ticketNumbers, String status, String description, double amount){
        Reimbursement newReimbursement = new Reimbursement();
        reimbursementList.add(newReimbursement);
    }
    //    overloaded method (method with the same name but different parameters)
    public void addReimbursementTicket(Reimbursement reimbursement){
        reimbursementList.add(reimbursement);
    }



    public List<Reimbursement> submitAllTickets() {
        return reimbursementList;
    }

}
