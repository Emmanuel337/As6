import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;






public class MovieTicketManager implements MovieTicketManagerInterface {
private ArrayList<Ticket> ticketList;

	
	
   public MovieTicketManager() {
	   ticketList = new ArrayList<Ticket>();
	   
   }
	
	
	
	
	
	@Override
	public int numVisits(int id) {
		 int visits = 0;
		 for(int i = 0; i < ticketList.size(); i++) {
			 if(ticketList.get(i).getId() ==  id) 
			 {
				 visits += 1;
			 }	 
			 
		 }
		return visits;
	}

	@Override
	public int numThisMovie(int id, String movie) {
		 int visits = 0;
		 for(int i = 0; i < ticketList.size(); i++) {
			 if(ticketList.get(i).getId() ==  id && ticketList.get(i).getMovieName() == movie) 
			 {
				 visits += 1;
			 }	 
			 
		 }
		return visits;
	}

	@Override
	public int numMoviesToday(int id, int date) {
		 int visits = 0;
		 for(int i = 0; i < ticketList.size(); i++) {
			 if(ticketList.get(i).getId() ==  id && ticketList.get(i).getDay() == date) 
			 {
				 visits += 1;
			 }	 
			 
		 }
		return visits;
	}

	@Override
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
		double cost; 
		switch (type.toUpperCase()) {
		case "ADULT":
		Adult a = new Adult(movieN,rating,d,t,f);
		ticketList.add(a);
		cost = a.calculateTicketPrice();
		break;
		
		case "CHILD":
			Child c = new Child(movieN,rating,d,t,f);
			ticketList.add(c);
			cost = c.calculateTicketPrice();	
		break;
		
		case "EMPLOYEE":
			Employee e = new  Employee(movieN,rating,d,t,f,id,numVisits(id));
			ticketList.add(e);
			cost = e.calculateTicketPrice();	
		break;
			 
		case "MOVIEPASS":
		MoviePass m;
		if(numVisits(id) < 1 && f.equals("NONE")) {
			m = new MoviePass(movieN,rating,d,t,f,id,true,false);

		}
		else if(numMoviesToday(id,d) < 1 && numThisMovie(id, movieN) < 1 && f.equals("NONE")){	
			m = new MoviePass(movieN,rating,d,t,f,id,false,true);
			
		}
		else {
			m = new MoviePass(movieN,rating,d,t,f,id,false,false);
		}
		ticketList.add(m);
		cost = m.calculateTicketPrice();	
		break;
			 	 
		default:
			
		cost =-1; 
		
		
		}
 
		return cost;
	}

	@Override
	public double totalSalesMonth() {
		double sales = 0;
		 for(int i = 0; i < ticketList.size(); i++) {
			 sales += ticketList.get(i).calculateTicketPrice();
			 
		 }
		return sales;
	 
	}

	@Override
	public String monthlySalesReport() {
		int adult =0;
		int child =0;
		int employee =0;
		int MoviePass =0;
		
		double adultSales =0;
		double childSales =0;
		double employeeSales =0;
		double MoviePassSales =0;
		
		String s;
		
		 for(int i = 0; i < ticketList.size(); i++) {
			 if(ticketList.get(i).toString().startsWith( "MOVIEPASS") ) {
					 MoviePass++;
					 MoviePassSales  += ticketList.get(i).calculateTicketPrice();
				}
			 else if(ticketList.get(i).toString().startsWith( "EMPLOYEE") ) {
				 employee++;
				 employeeSales   += ticketList.get(i).calculateTicketPrice();	 
			}
			 else if(ticketList.get(i).toString().startsWith( "CHILD") ) {
				 child++;
				 childSales    += ticketList.get(i).calculateTicketPrice();
				 
			}
			 else if(ticketList.get(i).toString().startsWith( "ADULT") ) {
				 adult++;
				 adultSales   += ticketList.get(i).calculateTicketPrice();
				 
			}
			 
			 
		 }
		s = String.format("Monthly Sales Report\n\n Sales  Number\n ADULT $%.2f %d\n  CHILD $%.2f %d\n EMPLOYEE $%.2f %d\n MOVIEPASS $%.2f %d" , adultSales,adult,childSales,child,employeeSales,employee,MoviePassSales,MoviePass);
		
		
		return s;
	}

	@Override
	public ArrayList<String> get3DTickets() {
		sortByDay();
		
		ArrayList<String> Tickets = new ArrayList<String>();
		for(int i = 0; i < ticketList.size(); i++) {
			if(ticketList.get(i).getFormat() == Format.THREE_D) {
				Tickets.add(ticketList.get(i).toString());

			}
	 	
		}
  
		return Tickets;
	}

	@Override
	public ArrayList<String> getAllTickets() {
		sortByDay();
		ArrayList<String> Tickets = new ArrayList<String>();
		for(int i = 0; i < ticketList.size(); i++) {
			  {
				Tickets.add(ticketList.get(i).toString());

			}
	 	
		}
  
		return Tickets;

	}

	@Override
	public ArrayList<String> getMoviePassTickets() {
		sortByID();
		ArrayList<String> Tickets = new ArrayList<String>();
		for(int i = 0; i < ticketList.size(); i++) {
			if(ticketList.get(i).toString().startsWith( "MOVIEPASS") ) {
				Tickets.add(ticketList.get(i).toString());

			}
	 	
		}
  
		return Tickets;
	}

	@Override
	public void readFile(File file) throws FileNotFoundException {
	Scanner inputFile = new Scanner(file);
    String l,r,m,f,t;
    int day,time,id;
    
    while(inputFile.hasNext()) {
    	l = inputFile.nextLine();
    String[] array = l.split(":");
    m = array[0];
    r = array[1];
    day = Integer.parseInt( array[2]);
    time = Integer.parseInt( array[3]);
    f = array[4];
    t = array[5];
    id =  Integer.parseInt( array[6]);
    addTicket(m,r,day,time,f,t,id);
    }
	}
	
	private void sortByID()
	{
		Ticket temp;
		for(int i = 1; i < ticketList.size(); i++)
		{
			for(int j = i; j > 0; j--)
			{
				if(ticketList.get(j).getId() < ticketList.get(j - 1).getId())
				{
					temp = ticketList.get(j);
					ticketList.set(j, ticketList.get(j -1));
					ticketList.set((j - 1), temp);
				}
				
			}
		}
	}
	
	/**
	 * Sorts the ArrayList of Tickets by day.
	 */
	private void sortByDay()
	{
		Ticket temp;
		for(int i = 1; i < ticketList.size(); i++)
		{
			for(int j = i; j > 0; j--)
			{
				if(ticketList.get(j).getDay() < ticketList.get(j - 1).getDay())
				{
					temp = ticketList.get(j);
					ticketList.set(j, ticketList.get(j -1));
					ticketList.set((j - 1), temp);
				}
				
			}
		}
	}

}
