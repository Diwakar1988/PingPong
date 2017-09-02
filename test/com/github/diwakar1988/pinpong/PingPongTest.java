package com.github.diwakar1988.pinpong;

import org.junit.Test;
import static org.junit.Assert.*;
import com.github.diwakar1988.pinpong.exceptions.InvalidTimeSlotException;
import com.github.diwakar1988.pinpong.model.PingPong;
import com.github.diwakar1988.pinpong.model.Player;
import com.github.diwakar1988.pinpong.model.TimeSlot;
import com.github.diwakar1988.pinpong.pojo.Matches;

public class PingPongTest {

	@Test
	public void shouldCreatePlayersAvailibilityMap() throws InvalidTimeSlotException {
				
				//Q2
				Player[]players = new Player[]{
						new Player("P1", 9, 10),
						new Player("P2", 9, 12),
						new Player("P3", 13, 15),
						new Player("P4", 10, 18),
				};
				TimeSlot officeTimeSlot = new TimeSlot(9, 18);
				PingPong pingPong = new PingPong(officeTimeSlot, players);
				assertEquals(officeTimeSlot.getMaxTime()-officeTimeSlot.getMinTime(), pingPong.getPlayersAvailibilityMap().size());
	}
	@Test
	public void shouldCalculateMatches() throws InvalidTimeSlotException {
		TimeSlot officeTimeSlot = new TimeSlot(9, 18);
		//Q1
		Player[] players = {
				new Player("P1", 9, 10),
				new Player("P2", 9, 12)
		};
		PingPong pingPong = new PingPong(officeTimeSlot, players);
		Matches matches = pingPong.calculateMatches();
		assertEquals(1, matches.getSingles());
		assertEquals(0, matches.getDoubles());
		
		
		//Q2
		players = new Player[]{
				new Player("P1", 9, 10),
				new Player("P2", 9, 12),
				new Player("P3", 13, 15),
				new Player("P4", 10, 18),
		};
		pingPong = new PingPong(officeTimeSlot, players);
		matches = pingPong.calculateMatches();
		assertEquals(5, matches.getSingles());
		assertEquals(0, matches.getDoubles());
		
		//Q3
		players = new Player[]{
				new Player("P1", 9, 11),
				new Player("P2", 12, 14),
				new Player("P3", 13, 15),
				new Player("P4", 11, 18),
				new Player("P5", 14, 18),
				new Player("P6", 10, 14),
				new Player("P7", 15, 18),
		};
		pingPong = new PingPong(officeTimeSlot, players);
		matches = pingPong.calculateMatches();
		assertEquals(7, matches.getSingles());
		assertEquals(1, matches.getDoubles());
		
		//Q4
		players = new Player[]{
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
		pingPong = new PingPong(officeTimeSlot, players);
		matches = pingPong.calculateMatches();
		assertEquals(6, matches.getSingles());
		assertEquals(2, matches.getDoubles());
		
		//Q5
		players = new Player[]{
					new Player("P1", 9, 14),
					new Player("P2", 15, 17),
					new Player("P3", 12, 13),
					new Player("P4", 16, 18),
					new Player("P5", 10, 15),
					new Player("P6", 14, 16),
					new Player("P7", 9, 13),
					new Player("P8", 9, 15),
			};
		pingPong = new PingPong(officeTimeSlot, players);
		matches = pingPong.calculateMatches();
		assertEquals(5, matches.getSingles());
		assertEquals(3, matches.getDoubles());
	}

}
