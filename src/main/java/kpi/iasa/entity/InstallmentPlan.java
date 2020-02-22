package kpi.iasa.entity;

import kpi.iasa.model.BankModel;

import java.math.BigDecimal;


public class InstallmentPlan extends Credit {
	
	private int graceTermInMonths;

	public InstallmentPlan() {}

	public InstallmentPlan(BankModel bank, Purpose purpose, BigDecimal rate, int termInMonths, BigDecimal maxSum, int graceTermInMonths) {
		super(bank, purpose, rate, termInMonths, maxSum);
		this.graceTermInMonths = graceTermInMonths;
	}

	public int getPartsAmount() {
		return graceTermInMonths;
	}

	public void setPartsAmount(int graceTermInMonths) {
		this.graceTermInMonths = graceTermInMonths;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + graceTermInMonths;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		InstallmentPlan other = (InstallmentPlan) obj;
		if (graceTermInMonths != other.graceTermInMonths) {
			return false;
		}
		return true;
	}
	
}
