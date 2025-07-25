package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Entities {
	private Date checkIn;
	private Date checkOut;
	private int roomNumber;
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Entities(Date checkIn, Date checkOut, int roomNumber) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNumber = roomNumber;
		//this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public long duration() {
		//long diff = ((((((checkOut.getTime() - checkIn.getTime())/1000)/60)/60)/24));
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public void updateDates(Date checkIn, Date checkOut) {
		if(checkIn.getTime() > checkOut.getTime()) {
			System.out.print("Enter a Check-IN date lower than the Check-OUT");
			
		} else {
			this.checkIn = checkIn;
			this.checkOut = checkOut;
		}
	}
	@Override
	public String toString() {
		StringBuilder SB = new StringBuilder();
		SB.append("Room: " + roomNumber);
		SB.append(", Check-IN: "+ sdf.format(checkIn));
		SB.append(", Check-OUT: " + sdf.format(checkOut));
		SB.append(" "+ duration() +" nights");	
		
		return SB.toString();
	}
}
