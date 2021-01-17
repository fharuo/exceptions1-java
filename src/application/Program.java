package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = scan.nextInt(); 
		System.out.println("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(scan.next());
		System.out.println("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(scan.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out must date be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.println("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(scan.next());			
						
			String error = reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println(error);
			} else {
				System.out.println("Updated reservation: " + reservation);		
			}	
			
		}
				
		scan.close();
	}

}
