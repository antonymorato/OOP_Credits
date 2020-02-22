package kpi.iasa.model;

import kpi.iasa.entity.Credits;
import kpi.iasa.entity.PersonCredit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditModel {



private List<PersonCredit> personCredits;

public CreditModel()
{
    personCredits=new ArrayList<>();
}


public void addPersonCredit(PersonCredit personCredit)
{
    personCredits.add(personCredit);

}

public List<PersonCredit> getPersonCreditsList()
{
    return personCredits;
}

public void payOffSumm(BigDecimal summ,String name)
{
    for (PersonCredit personCredit:personCredits)
    {
        if(personCredit.getName().equals(name)) {
            if(personCredit.getCreditLeft().compareTo(summ)<=0) {
                payOffCredit(name);
                break;
            }
            personCredit.decreaseSumm(summ);
        }
    }

}
public void payOffCredit(String name)
{
    for (int i = 0; i <personCredits.size() ; i++) {
        if (personCredits.get(i).getName().equals(name))
            personCredits.remove(i);
    }
}

}
