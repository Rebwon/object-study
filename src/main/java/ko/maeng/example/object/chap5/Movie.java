package ko.maeng.example.object.chap5;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import ko.maeng.example.object.chap2.Money;
import lombok.AccessLevel;
import lombok.Getter;

public abstract class Movie {
	private String title;
	private Duration runningTime;
	@Getter(AccessLevel.PROTECTED)
	private Money fee;
	private List<DiscountCondition> discountConditions;

	public Movie(String title, Duration runningTime, Money fee,
		DiscountCondition... discountConditions) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountConditions = Arrays.asList(discountConditions);
	}

	public Money calculateMovieFee(Screening screening) {
		if(isDiscountable(screening)) {
			return fee.minus(calculateDiscountAmount());
		}
		return fee;
	}

	private boolean isDiscountable(Screening screening) {
		return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
	}

	protected abstract Money calculateDiscountAmount();
}
