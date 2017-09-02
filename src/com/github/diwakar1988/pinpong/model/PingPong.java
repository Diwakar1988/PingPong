package com.github.diwakar1988.pinpong.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.github.diwakar1988.pinpong.exceptions.InvalidTimeSlotException;
import com.github.diwakar1988.pinpong.pojo.Matches;

public class PingPong {

	private HashMap<TimeSlot, HashSet<Player>> mapOfficeTimeSlot;

	public PingPong(TimeSlot timeSlot, Player[] players) throws InvalidTimeSlotException {
		//creating a map of timeslot vs players who can play in the same time slot
		mapOfficeTimeSlot = new HashMap<>();
		for (int i = timeSlot.getMinTime(); i < timeSlot.getMaxTime(); i++) {

			mapOfficeTimeSlot.put(new TimeSlot(i, i + 1), new HashSet<>());
		}
		for (int i = 0; i < players.length; i++) {
			Player p = players[i];
			//put players availability in office time slot
			for (int j = p.getTimeSlot().getMinTime(); j < p.getTimeSlot().getMaxTime(); j++) {
				TimeSlot ts = new TimeSlot(j, j + 1);
				mapOfficeTimeSlot.get(ts).add(p);
			}
		}
	}

	public HashMap<TimeSlot, HashSet<Player>> getPlayersAvailibilityMap() {
		return mapOfficeTimeSlot;
	}

	public Matches calculateMatches() {
		int countSingles = 0;
		int countDoubles = 0;
		Iterator<TimeSlot> iterator = mapOfficeTimeSlot.keySet().iterator();
		while (iterator.hasNext()) {
			TimeSlot timeSlot = (TimeSlot) iterator.next();
			int size = mapOfficeTimeSlot.get(timeSlot).size();
			if (size >= 4) {
				//if over 4 players can play within same time slot then there would be one doubles match of an hour 
				countDoubles++;
			} else if (size > 1 && size < 4) {
				//if 2 or 3 players can play within same time slot then there would be one singles match of an hour
				countSingles++;
			}
		}
		return new Matches(countSingles, countDoubles);
	}

}
