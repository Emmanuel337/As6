 import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoviePassTest {
MoviePass m1, m2;

@Before
public void setUp() throws Exception {
m1 = new MoviePass("Deadpool", "NR", 5,19, "NONE", 22222, 1,0,0);
}

@After
public void tearDown() throws Exception {
m1=null;
}

@Test
public void test() {
assertEquals(11.50,m1.calculateTicketPrice(), .01);
}

}