package com.github.diwakar1988.pinpong;

import com.github.diwakar1988.pinpong.exceptions.InvalidTimeSlotException;
import com.github.diwakar1988.pinpong.model.PingPong;
import com.github.diwakar1988.pinpong.model.Player;
import com.github.diwakar1988.pinpong.model.TimeSlot;
import com.github.diwakar1988.pinpong.pojo.Matches;

public class Game {

	public static void main(String[] args) {
		//we can also ask input from user but its a good way to test our algorithm fast. :)
		try{
			
//			//Q1
//			Player[] players = {
//					new Player("P1", 9, 10),
//					new Player("P2", 9, 12)
//			};
			
//			//Q2
//			Player[] players = {
//					new Player("P1", 9, 10),
//					new Player("P2", 9, 12),
//					new Player("P3", 13, 15),
//					new Player("P4", 10, 18),
//			};
			
//			//Q3
//			Player[] players = {
//					new Player("P1", 9, 11),
//					new Player("P2", 12, 14),
//					new Player("P3", 13, 15),
//					new Player("P4", 11, 18),
//					new Player("P5", 14, 18),
//					new Player("P6", 10, 14),
//					new Player("P7", 15, 18),
//			};
				
				//Q4
				Player[] players = {
						new Player("P1", 9, 10),
						new Player("P2", 9, 12),
						new Player("P3", 14, 15),
						new Player("P4", 16, 18),
						new Player("P5", 14, 18),
						new Player("P6", 10, 13),
						new Player("P7", 15, 18),
						new Player("P8", 10, 14),
						new Player("P9", 9, 13),
				};	

//				//Q5
//				Player[] players = {
//						new Player("P1", 9, 14),
//						new Player("P2", 15, 17),
//						new Player("P3", 12, 13),
//						new Player("P4", 16, 18),
//						new Player("P5", 10, 15),
//						new Player("P6", 14, 16),
//						new Player("P7", 9, 13),
//						new Player("P8", 9, 15),
//				};	
			
			TimeSlot officeTimeSlot = new TimeSlot(9, 18);
			PingPong pingPong = new PingPong(officeTimeSlot, players);
			Matches matches = pingPong.calculateMatches();
			
			System.out.println("INPUT");
			System.out.println(players.length);
			
			for (Player player : players) {
				System.out.println(player);
			}
			
			System.out.println("\nOUTPUT");
			System.out.println(matches.getSingles() + " " + matches.getDoubles());
			
			} catch (InvalidTimeSlotException e) {
				System.out.println(e.getMessage());
			}
	}
}
