package ko.maeng.example.object.chap5;

import java.time.Duration;

import ko.maeng.example.object.chap2.Money;

public class PeriodDiscountMovie extends Movie {
	private double percent;

	public PeriodDiscountMovie(String title, Duration runningTime, Money fee, double percent,
		DiscountCondition... discountConditions) {
		super(title, runningTime, fee, discountConditions);
		this.percent = percent;
	}

	@Override
	protected Money calculateDiscountAmount() {
		return getFee().times(percent);
	}
}
