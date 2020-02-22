package kpi.iasa.entity;

import java.math.BigDecimal;

import kpi.iasa.model.BankModel;

/**
 * This type represents terms of purpose credits which issued by different banks.
 * @author Anton Korol
 *
 */
public class Credit {
	
	private BankModel bank;

	private Purpose purpose;
	
	private BigDecimal rate;
	
	private int termInMonths;
	
	private BigDecimal maxSum;
	
	public Credit() {}
	
	public Credit(BankModel bank,
			Purpose purpose, 
			BigDecimal rate, 
			int termInMonths, 
			BigDecimal maxSum) {
		this.bank = bank;
		this.purpose = purpose;
		this.rate = rate;
		this.termInMonths = termInMonths;
		this.maxSum = maxSum;
	}

	public BankModel getBank() {
		return bank;
	}

	public void setBank(BankModel bank) {
		this.bank = bank;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public int getTermInMonths() {
		return termInMonths;
	}

	public void setTermInMonths(int termInMonths) {
		this.termInMonths = termInMonths;
	}

	public BigDecimal getMaxSum() {
		return maxSum;
	}

	public void setMaxSum(BigDecimal maxSum) {
		this.maxSum = maxSum;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maxSum == null) ? 0 : maxSum.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + termInMonths;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credit other = (Credit) obj;
		if (maxSum == null) {
			if (other.maxSum != null)
				return false;
		} else if (!maxSum.equals(other.maxSum))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (purpose != other.purpose)
			return false;
		if (termInMonths != other.termInMonths)
			return false;
		return true;
	}

	public enum Purpose {
		
		MORTGAGE, CAR_LEASING, CONSUMER, BUSINESS
		
	}
	
}