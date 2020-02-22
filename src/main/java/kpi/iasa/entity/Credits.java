package kpi.iasa.entity;

import java.math.BigDecimal;

public enum Credits {
	
	BIS_MORTGAGE_1(
			new Credit(
					Banks.BIS.getBank(),
					Credit.Purpose.MORTGAGE,
					new BigDecimal("37.7"),
					36,
					new BigDecimal("5000000"))
			),
	BIS_MORTGAGE_2(
			new Credit(
					Banks.BIS.getBank(),
					Credit.Purpose.MORTGAGE,
					new BigDecimal("36.14"),
					120,
					new BigDecimal("5000000"))
			),
	KREDO_MORTGAGE_1(
			new Credit(
					Banks.KREDO.getBank(),
					Credit.Purpose.MORTGAGE,
					new BigDecimal("21.68"),
					36,
					new BigDecimal("3000000"))
			),
	KREDO_CONSUMER_1(
			new InstallmentPlan(
					Banks.KREDO.getBank(),
					Credit.Purpose.CONSUMER,
					new BigDecimal("40.68"),
					36,
					new BigDecimal("30000"),
					12)
			),
	KREDO_CONSUMER_2(
			new InstallmentPlan(
					Banks.KREDO.getBank(),
					Credit.Purpose.CONSUMER,
					new BigDecimal("50.15"),
					60,
					new BigDecimal("60000"),
					24)
			);
	
	private Credit creditTerms;
	
	private Credits(Credit creditTerms) {
		creditTerms.getBank().addCreditTerms(creditTerms);
		this.creditTerms = creditTerms;
	}

	public Credit getCreditTerms() {
		return creditTerms;
	}
	
}
