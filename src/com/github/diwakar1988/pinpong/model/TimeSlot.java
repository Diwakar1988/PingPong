package com.github.diwakar1988.pinpong.model;

import com.github.diwakar1988.pinpong.exceptions.InvalidTimeSlotException;

public class TimeSlot {

	private int minTime;
	private int maxTime;

	public TimeSlot(int minTime, int maxTime) throws InvalidTimeSlotException{
		
		if (maxTime-minTime <=0) {
			throw new InvalidTimeSlotException("Invalid time slot "+minTime+"-"+maxTime);
		}
		this.minTime = minTime;
		this.maxTime = maxTime;
	}
	public int getMinTime() {
		return minTime;
	}
	public int getMaxTime() {
		return maxTime;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getMinTime());
		sb.append("-");
		sb.append(getMaxTime());
		return sb.toString();
	}
	@Override
	public int hashCode() {
		int code=17;
		code=31*code + minTime+maxTime;
		return code;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj==this) {
			return true;
		}
		if (!(obj instanceof TimeSlot)) {
			return false;
		}
		TimeSlot ts= (TimeSlot) obj;
		return ts.maxTime==this.maxTime && ts.minTime==this.minTime;
	}
	
}
