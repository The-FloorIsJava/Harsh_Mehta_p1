package com.revature.P1.Service;

import com.revature.P1.Model.ReimbursementTicket;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementTicketService {

    List<ReimbursementTicket> reimbursementTicketList;

    public ReimbursementTicketService(){
        reimbursementTicketList = new ArrayList<>();
    }

    public void addReimbursementTicket(String userName, int ticketId, int ticketNumbers, String status, String description, double amount){
        ReimbursementTicket newReimbursementTicket = new ReimbursementTicket(userName, ticketId, ticketNumbers, status, description, amount);
        reimbursementTicketList.add(newReimbursementTicket);
    }
    //    overloaded method (method with the same name but different parameters)
    public void addReimbursementTicket(ReimbursementTicket reimbursementTicket){
        reimbursementTicketList.add(reimbursementTicket);
    }



    public List<ReimbursementTicket> submitAllTickets() {
        return reimbursementTicketList;
    }

}
