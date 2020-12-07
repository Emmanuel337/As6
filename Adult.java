
public class Adult extends Ticket {
	private final double Adult_EARLY = 10.50;
	private final double Adult_NORMAL = 13.50;
	private final double tax = .096;
	private final double IMAX = 3.00;
	private final double THREE_D = 2.50;

	public Adult(String movieName, String movieRating, int day, int time,String format) {
		super(movieName, movieRating, day,time, format);
	}
	
	@Override
	public double calculateTicketPrice() {
		double cost;
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
        return cost;
	}

	@Override
	public int getId() {
		return -1;
	}

	public String toString() {
		String s = super.toString();
		if(this.getFormat() == Format.IMAX) {
			return "ADULT IMAX " + s + String.format(" Price: $%.2f", this.calculateTicketPrice())

;
		}
		else if(this.getFormat() == Format.THREE_D) {
			return "ADULT 3D " + s + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
		else {
			return  "ADULT " + s + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
		 
		
	}
	
 
}
