package ko.maeng.example.object.chap1;

public class TicketSeller {
	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	public void sellTo(Audience audience) {
		ticketOffice.sellTicketTo(audience);
	}
}
