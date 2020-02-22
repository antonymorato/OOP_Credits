package kpi.iasa.entity;

import kpi.iasa.model.BankModel;

public enum Banks {
	
	BIS(new BankModel("Банк інвестицій та заощаджень")),
	KREDO(new BankModel("Кредобанк"));
	
	private BankModel bank;
	
	private Banks(BankModel bank) {
		this.bank = bank;
	}
	
	public BankModel getBank() {
		return bank;
	}
	
}
