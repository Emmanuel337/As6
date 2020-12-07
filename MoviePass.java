
public class MoviePass extends Ticket {
	private final double Adult_EARLY = 10.50;
	private final double Adult_NORMAL = 13.50;
	private final double tax = .096;
	private final double IMAX = 3.00;
	private final double THREE_D = 2.50;
    private final double firstMovie = 9.99;
    private int Id;
    private boolean firstOne;
    private boolean FREE;
    
	public MoviePass(String movieName, String movieRating, int day, int time,String format, int id, boolean firstOne, boolean FREE ) {
		super(movieName, movieRating, day,time, format);
		this.Id = id;
		this.firstOne = firstOne;
		this.FREE = FREE;
	}
	
 
	public MoviePass(String string, String string2, int i, int j, String string3, int k, int l, int m, int n) {
		// TODO Auto-generated constructor stub
	}
 

	@Override
	public double calculateTicketPrice() {
		double cost;
		if(FREE) {
			cost = 0;
		}
		else if(firstOne){
			cost = firstMovie;
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
		}
        return cost;
	}

	@Override
	public int getId() {
		return Id;
	}

	public String toString() {
		String s = super.toString();
		if(this.getFormat() == Format.IMAX) {
			return "MOVIEPASS- " + this.getId() + " IMAX " + s + String.format(" Price: $%.2f", this.calculateTicketPrice())

;
		}
		else if(this.getFormat() == Format.THREE_D) {
			return "MOVIEPASS- " + this.getId() + " 3D " + s + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
		else {
			return  "MOVIEPASS- " + this.getId() + s + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
		 
		
	}
	
 
}
