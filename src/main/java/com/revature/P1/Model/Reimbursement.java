package com.revature.P1.Model;

public class Reimbursement {

    private String userName;
    private int ticketId;

    private String status;
    private String description;
    private double amount ;

    public Reimbursement() {

        this.userName = userName;
        this.ticketId = ticketId;

        this.status = "pending";
        this.description = description;
        this.amount = amount;
    }

    public String getUserName(){

        return userName;
    }

    public void setUserName(String userName){

        this.userName = userName;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }




   /* public boolean isValidAmount(double amount) {
        if (amount == 0) {
            return false;
        }
        return Objects.equals(this.amount, amount);
    }

    public boolean isValid(String description) {
        if (description == null) {
            return false;
        }
        return this.description != null && this.description.equals(description);
    }
*/
    @Override
    public String toString() {
        return "ReimbursementTicket{" +
                "User Name=" + userName +
                "Ticket Id=" + ticketId +
                ", Status='" + status + '\'' +
                ", Description=" + description +
                ", Amount=" + amount +
                '}';
    }

}
