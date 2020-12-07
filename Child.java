
public class Child extends Ticket {
	private final double CHILD_EARLY = 5.75;
	private final double CHILD_NORMAL = 10.75;
	private final double tax = .096;
	private final double IMAX = 2.00;
	private final double THREE_D = 1.50;

	public Child(String movieName, String movieRating, int day, int time,String format) {
		super(movieName, movieRating, day,time, format);
	}
	
	@Override
	public double calculateTicketPrice() {
		double cost;
		if(this.getTime() < 18) {
			cost = CHILD_EARLY;
		}
		else {
			cost = CHILD_NORMAL;
		}
		if(this.getFormat() == Format.IMAX) {
			cost += IMAX;
		}
		if(this.getFormat() == Format.THREE_D) {
			cost += THREE_D;
		}
		cost *=(1 + tax);
        return cost;
	}

	@Override
	public int getId() {
		return -1;
	}
 
	public String toString() {
		String s = super.toString();
		if(this.getFormat() == Format.IMAX) {
			return " CHILD IMAX " + s + String.format(" Price: $%.2f", this.calculateTicketPrice())

;
		}
		else if(this.getFormat() == Format.THREE_D) {
			return "CHILD  3D " + s + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
		else {
			return  "CHILD  " + s + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
		 
		
	}
	
 
	}
	
