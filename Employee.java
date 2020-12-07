
public class Employee extends Ticket {
	private final double Adult_EARLY = 10.50;
	private final double Adult_NORMAL = 13.50;
	private final double tax = .096;
	private final double IMAX = 3.00;
	private final double THREE_D = 2.50;
    private int id;
    private int movieViews;
    
    
	public Employee (String movieName, String movieRating, int day, int time,String format, int id, int movieViews) {
		super(movieName, movieRating, day,time, format);
		this.id = id;
		this.movieViews = movieViews;
	}
	
	
	@Override
	public double calculateTicketPrice() {
		double cost;
	
		if(movieViews < 2) {
			cost = 0;
		}
		else{
			if(this.getTime() < 18) {
				cost = Adult_EARLY;
			}
			else {
				cost = Adult_NORMAL;
			}
			if(this.getFormat() == Format.IMAX) {
				cost += IMAX;
			}
			if(this.getFormat() == Format.THREE_D) {
				cost += THREE_D;
			}
			cost *=(1 + tax);	
            cost/=2;
		}
		 
        return cost;
	}

	@Override
	public int getId() {
		return this.id;
	}

	public String toString() {
		String s = super.toString();
		if(this.getFormat() == Format.IMAX) {
			return "EMPLOYEE- " + this.getId() + " IMAX " + s + String.format(" Price: $%.2f", this.calculateTicketPrice())

;
		}
		else if(this.getFormat() == Format.THREE_D) {
			return "EMPLOYEE- " + this.getId() + " 3D " + s + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
		else {
			return  "EMPLOYEE" + this.getId() + s + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
		 
		
	}
	
}
