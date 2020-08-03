package ko.maeng.example.object.chap5;

import java.time.DayOfWeek;
import java.time.LocalTime;

import ko.maeng.example.object.chap4.DiscountConditionType;

public class DiscountCondition {
	private DiscountConditionType type;
	private int sequence;
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	public boolean isSatisfiedBy(Screening screening) {
		if(type == DiscountConditionType.PERIOD) {
			return isSatisfiedByPeriod(screening);
		}
		return isSatisfiedBySequence(screening);
	}

	private boolean isSatisfiedBySequence(Screening screening) {
		return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
			startTime.compareTo(screening.getWhenScreened().toLocalTime()) <=0 &&
			endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
	}

	private boolean isSatisfiedByPeriod(Screening screening) {
		return sequence == screening.getSequence();
	}
}
