package com.github.diwakar1988.pinpong;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.diwakar1988.pinpong.exceptions.InvalidTimeSlotException;
import com.github.diwakar1988.pinpong.model.TimeSlot;

public class TimeSlotTest {

	@Test(expected=InvalidTimeSlotException.class)
	public void shouldThrowInvalidTimeSlotException() throws InvalidTimeSlotException {
		new TimeSlot(10, 10);
		new TimeSlot(11, 10);
	}
	public void shouldInstantiate() throws InvalidTimeSlotException {
		new TimeSlot(9, 10);
	}
	@Test
	public void shouldBeEquals() throws InvalidTimeSlotException {
		TimeSlot ts1=new TimeSlot(9, 10);
		TimeSlot ts2=new TimeSlot(9, 10);
		assertTrue(ts1.equals(ts2));
	}

}
