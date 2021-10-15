package Inlämingsuppgift1Test;

import org.junit.Test;

import java.time.LocalDate;
import static org.junit.Assert.assertFalse;

public class BestGymEverTest {

    LocalDate date = LocalDate.now();
    LocalDate dateMinusTwelveMonths = date.minusMonths(12);

    @Test
    public final void dateTest(){

        assertFalse(LocalDate.now() == dateMinusTwelveMonths );
        System.out.println("The date today minus 12 months is: " + dateMinusTwelveMonths);
    }
}
