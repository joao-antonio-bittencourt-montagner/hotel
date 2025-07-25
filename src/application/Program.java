package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.entities.Entities;

public class Program {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Enter a date: ");
		Date dateCheckIn = sdf.parse(sc.next());
		System.out.print("Enter a date: ");
		Date dateCheckOut = sdf.parse(sc.next());
		
		if (!dateCheckOut.after(dateCheckIn)) {
			System.out.println("Error in reservation: check-OUT must be after check-IN date");
			
		} else {
			Entities ent = new Entities(dateCheckIn, dateCheckOut, roomNumber);
			System.out.println("Reservation: " + ent);
		
			System.out.print("Enter a update date: ");
			dateCheckIn = sdf.parse(sc.next());
			System.out.print("Enter a second update date: ");
			dateCheckOut = sdf.parse(sc.next());
			
			ent.updateDates(dateCheckIn, dateCheckOut);
			System.out.print("Reservation: " + ent);
		}
	
		sc.close();
	}
}
