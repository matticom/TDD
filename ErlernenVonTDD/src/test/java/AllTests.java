import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Euro.EuroTest;
import customer.CustomerTest;
import customer.MovieTest;

@RunWith(Suite.class)
@SuiteClasses({
	CustomerTest.class,
	MovieTest.class,
	EuroTest.class
})

public class AllTests {

}
