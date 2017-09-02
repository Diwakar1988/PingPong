package com.github.diwakar1988.pinpong;

import org.junit.Test;

import com.github.diwakar1988.pinpong.exceptions.InvalidTimeSlotException;
import com.github.diwakar1988.pinpong.model.Player;

public class PlayerTest {

	@Test(expected=InvalidTimeSlotException.class)
	public void shouldThrowInvalidTimeSlotException() throws InvalidTimeSlotException {
		new Player("P1", 10, 9);
	}
	
	@Test
	public void shouldInstantiate() throws InvalidTimeSlotException {
		new Player("P1", 9, 18);
	}
}
