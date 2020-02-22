package kpi.iasa.entity;

import java.math.BigDecimal;

public class PersonCredit {
    private BigDecimal creditLeft;
    private Credit credit;
    private String name;

    public PersonCredit(Credit credit, BigDecimal summ,String name)
    {this.name=name;
     this.credit=credit;
     creditLeft=summ;

    }




    public String getName(){return name;}


    public void decreaseSumm(BigDecimal summ)
    {
        creditLeft=creditLeft.subtract(summ);
    }

    public BigDecimal getCreditLeft()
    {return creditLeft;}
}
