 import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdultTest {
	
	Adult a1,a2,a3,a4,a5,a6;
	

	@Before
	public void setUp() throws Exception {
		
		//Evening Movie before 6 pm
		a1 = new Adult("Star Wars", "PG13", 6,12, "NONE");
		
		a2 = new Adult("Jump Street 22", "R", 3,21, "IMAX");
		
		a3 = new Adult("Hunger Games", "G", 2,14, "3D");
		
		a4 = new Adult("Hotel Transylvania", "PG", 1,20, "IMAX");
		
		a5 = new Adult("66nd Street", "NR", 5,17, "3D");
		
		a6 = new Adult("Alvin and Chipmunks", "PG13", 4,8, "NONE");
	}

	@After
	public void tearDown() throws Exception {
		
		a1=a2=a3=a4=a5=a6=null;
	}

	@Test
	public void test() {
		assertEquals(11.51, a1.calculateTicketPrice(),.01);
		assertEquals(18.08, a2.calculateTicketPrice(),.01);
		assertEquals(14.25, a3.calculateTicketPrice(),.01);
		assertEquals(18.08, a4.calculateTicketPrice(),.01);
		assertEquals(14.25, a5.calculateTicketPrice(),.01);
		assertEquals(11.51, a6.calculateTicketPrice(),.01);
	}

}
