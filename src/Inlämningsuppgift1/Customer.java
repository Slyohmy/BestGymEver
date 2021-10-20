package Inlämningsuppgift1;

import java.time.LocalDate;

public class Customer {

    protected String personalID;
    protected String name;
    protected LocalDate lastPayment;

    public Customer(String personalID, String name, LocalDate lastPayment) {
        this.personalID = personalID;
        this.name = name;
        this.lastPayment = lastPayment;
    }

    public String getPersonalID() {
        return personalID;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLastPayment() {
        return lastPayment;
    }
}
