package src.main.java.com.revature.P1.Service;

import src.main.java.com.revature.P1.Model.ReimbursementTicket;

import java.util.ArrayList;
import java.util.List;

public class SubmitTicket {

    List<ReimbursementTicket> reimbursementTicketList;

    public SubmitTicket(){
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
