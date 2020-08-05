package ko.maeng.example.object.chap5;

import java.time.Duration;

import ko.maeng.example.object.chap2.Money;

public class AmountDiscountMovie extends Movie {
	private Money discountAmount;

	public AmountDiscountMovie(String title, Duration runningTime,
		Money fee, Money discountAmount, DiscountCondition... discountConditions) {
		super(title, runningTime, fee, discountConditions);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money calculateDiscountAmount() {
		return discountAmount;
	}
}
