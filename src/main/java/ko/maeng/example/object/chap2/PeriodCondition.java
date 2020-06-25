package ko.maeng.example.object.chap2;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return isEqualsDayOfWeek(screening) &&
			compareToStartTime(screening) &&
			compareToEndTime(screening);
	}

	private boolean compareToEndTime(Screening screening) {
		return endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
	}

	private boolean compareToStartTime(Screening screening) {
		return startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0;
	}

	private boolean isEqualsDayOfWeek(Screening screening) {
		return screening.getStartTime().getDayOfWeek().equals(dayOfWeek);
	}
}
