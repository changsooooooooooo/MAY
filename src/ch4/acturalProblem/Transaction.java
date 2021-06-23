package ch4.acturalProblem;

public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader showTrader(){
        return trader;
    }

    public int showYear(){
        return year;
    }

    public int showValue(){
        return value;
    }

    @Override
    public String toString(){
        return "{ "+this.trader+", "
                +"year: "+this.year+", "
                +"value: "+this.value+" "
                +"}";
    }
}
