package ko.maeng.example.object.chap2;

import java.util.Arrays;
import java.util.List;

/*
* 인터페이스 상속과 합성(조립)을 적절히 사용한 케이스.
* */
public abstract class DefaultDiscountPolicy implements DiscountPolicy {
	private List<DiscountCondition> conditions;

	public DefaultDiscountPolicy(DiscountCondition... discountConditions) {
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
