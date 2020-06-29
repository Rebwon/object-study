package ko.maeng.example.object.chap4;

import java.time.Duration;
import java.util.List;

import ko.maeng.example.object.chap2.Money;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private List<DiscountCondition> discountConditions;

	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;
}
