package kpi.iasa.controller;

import kpi.iasa.entity.Credit;
import kpi.iasa.entity.PersonCredit;
import kpi.iasa.model.CreditModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PersonCreditController {

    private CreditModel creditModel;


    public PersonCreditController(CreditModel creditModel)
    {
        this.creditModel=creditModel;
    }

    public List<PersonCredit>  getAllDebts(List<PersonCredit> personCredit){
        List<PersonCredit> resultList=new ArrayList<>(personCredit);

        return resultList;
    }



    public void releaseCredit(String name, BigDecimal decreaseValue)
    {
        creditModel.payOffSumm(decreaseValue,name);
    }


}
