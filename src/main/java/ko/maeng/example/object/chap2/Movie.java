package ko.maeng.example.object.chap2;

import java.time.Duration;

import lombok.Getter;

/*
* DiscountPolicy라는 인터페이스를 합성(조립)하여
* 인스턴스 변수로 사용함.
* */
public class Movie {
	private String title;
	private Duration runningTime;
	@Getter
	private Money fee;
	private DiscountPolicy discountPolicy;

	public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = discountPolicy;
	}

	public Money calculateMovieFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));
	}

	public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
		this.discountPolicy = discountPolicy;
	}
}
