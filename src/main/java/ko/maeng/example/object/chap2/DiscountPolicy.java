package ko.maeng.example.object.chap2;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
	private List<DiscountCondition> conditions;

	public DiscountPolicy(DiscountCondition... discountConditions) {
		this.conditions = Arrays.asList(discountConditions);
	}

	public Money calculateDiscountAmount(Screening screening) {
		for(DiscountCondition each : conditions) {
			if(each.isSatisfiedBy(screening)) {
				return getDiscountAmount(screening);
			}
		}
		return Money.ZERO;
	}

	abstract protected Money getDiscountAmount(Screening screening);
}
