package Inlämningsuppgift1;

import org.junit.Test;
import static org.junit.Assert.*;


public class BestGymEverTest {

    BestGymEver bestGymEver = new BestGymEver();

    @Test
    public void checkCurrentCustomers(){

        bestGymEver.checkIfCustomerExist();
        assertTrue(bestGymEver.getCurrentCustomer().size() > 0);

    }
}

