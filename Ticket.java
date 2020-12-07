
public abstract class Ticket {
 private Format format;
 private String movieName;
 private String movieRating;
 private int day;
 private int time;
 
 public Ticket()  {  
	 this.movieName = "";
	 this.format = Format.NONE;
     this.day = 0;
     this.movieRating = "";
     this.time = 0;
 }
 
 public Ticket(String movieName, String movieRating, int day, int time,String format)  {  
	 this.movieName = movieName;
     this.day = day;
     this.movieRating = movieRating;
     this.time = time;
     if( format.equals("3D")){
		 this.format = Format.THREE_D;
	 }
     else if( format.equals("IMAX")){
		 this.format = Format.IMAX;
	 }
     else 
     this.format = Format.NONE;
 }
 
 public abstract double calculateTicketPrice();
 public abstract int getId();
 
 
 public String toString()
	{
		return "Movie: " + movieName + " Rating: " + movieRating + " Day: " + day + " Time: " + time;
	}


public Format getFormat() {
	return format;
}

public void setFormat(Format format) {
	this.format = format;
}

public String getMovieName() {
	return movieName;
}

public void setMovieName(String movieName) {
	this.movieName = movieName;
}

public String getMovieRating() {
	return movieRating;
}

public void setMovieRating(String movieRating) {
	this.movieRating = movieRating;
}

public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}

public int getTime() {
	return time;
}

public void setTime(int time) {
	this.time = time;
}
 
 
 
 
 
 
 
 
 
 
 
 
}
