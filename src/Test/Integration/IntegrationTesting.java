package Test.Integration;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Server.DAO.PopulateTestDatabase;

@RunWith(Suite.class)
@SuiteClasses({UC01.class, UC02.class, UC03.class, UC04.class, UC05.class })
public class IntegrationTesting {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
	}

}
