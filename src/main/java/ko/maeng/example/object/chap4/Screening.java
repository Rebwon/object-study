package ko.maeng.example.object.chap4;

import java.time.LocalDateTime;

import ko.maeng.example.object.chap2.Money;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	@Builder
	public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
		this.movie = movie;
		this.sequence = sequence;
		this.whenScreened = whenScreened;
	}

	public Money calculateFee(int audienceCount) {
		switch (movie.getMovieType()) {
			case AMOUNT_DISCOUNT:
				if (movie.isDiscountable(whenScreened, sequence)) {
					return movie.calculateAmountDiscountFee().times(audienceCount);
				}
				break;
			case PERCENT_DISCOUNT:
				if (movie.isDiscountable(whenScreened, sequence)) {
					return movie.calculatePercentDiscountFee().times(audienceCount);
				}
			case NONE_DISCOUNT:
				return movie.calculateNoneDiscountFee().times(audienceCount);
		}
		return movie.calculateNoneDiscountFee().times(audienceCount);
	}
}
