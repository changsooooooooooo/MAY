package ch4.acturalProblem;

public class Trader {

    private final String name;
    private final String city;

    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String showName(){
        return this.name;
    }

    public String showCity(){
        return this.city;
    }

    @Override
    public String toString(){
        return "Trader: "+this.name +" in "+this.city;
    }
}
