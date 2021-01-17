package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {			
			System.out.print("Room number: ");
			int roomNumber = scan.nextInt(); 
			System.out.println("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.println("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(scan.next());
				
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.println("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(scan.next());			
						
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Updated reservation: " + reservation);		
				
		} catch (ParseException e) {
			System.out.println("Error in reservation: Invalid date format!");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Room number not accepted");
		}
		
		scan.close();
	}

}
