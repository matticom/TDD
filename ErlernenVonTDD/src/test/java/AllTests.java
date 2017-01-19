import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Euro.EuroTest;
import customer.CustomerTest;
import customer.MovieTest;
import customer.PriceTest;
import customer.RentalTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	CustomerTest.class, 
	MovieTest.class, 
	EuroTest.class,
	PriceTest.class,
	RentalTest.class
})

public class AllTests {

}
