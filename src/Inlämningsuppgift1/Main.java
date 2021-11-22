package Inlämningsuppgift1;

public class Main {
    public static void main(String[] args){
        BestGymEver bestGymEver = new BestGymEver();
        String namn = bestGymEver.checkIfCustomerExist();
        bestGymEver.checkIn(namn);
    }
}
