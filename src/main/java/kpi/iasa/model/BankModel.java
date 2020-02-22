package kpi.iasa.model;

import kpi.iasa.entity.Credit;

import java.util.ArrayList;
import java.util.List;



public class BankModel {

    private String name;

    private List<Credit> creditsTermsList = new ArrayList<>();

    public BankModel() {}

    public BankModel(String name) {
        this.name = name;
    }

    public BankModel(String name, List<Credit> creditsTermsList) {
        this.name = name;
        this.creditsTermsList = creditsTermsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Credit> getCreditsTermsList() {
        return creditsTermsList;
    }

    public void setCreditsTermsList(List<Credit> creditsTermsList) {
        this.creditsTermsList = creditsTermsList;
    }

    /**
     * Adds credit terms to collection of current bank credit terms list
     * @param creditTerms
     */
    public void addCreditTerms(Credit creditTerms) {
        creditsTermsList.add(creditTerms);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creditsTermsList == null) ? 0 : creditsTermsList.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        BankModel other = (BankModel) obj;
        if (creditsTermsList == null) {
            if (other.creditsTermsList != null)
                return false;
        } else if (!creditsTermsList.equals(other.creditsTermsList))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
