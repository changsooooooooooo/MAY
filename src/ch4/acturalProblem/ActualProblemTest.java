package ch4.acturalProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ActualProblemTest {

    public static List<Transaction> problem1(List<Transaction> transactions){
        return transactions.stream()
                .filter(t->t.showYear()==2011)
                .sorted(Comparator.comparing(Transaction::showValue))
                .collect(Collectors.toList());
    }

    public static List<String> problem2(List<Transaction> transactions){
        return transactions.stream()
                .map(t->t.showTrader().showCity())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Trader> problem3(List<Transaction> transactions){
        return transactions.stream()
                .map(Transaction::showTrader)
                .filter(t->t.showCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::showName))
                .collect(Collectors.toList());
    }

    public static List<Trader> problem4(List<Transaction> transactions){
        return transactions.stream()
                .map(Transaction::showTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::showName))
                .collect(Collectors.toList());
    }

    public static boolean problem5(List<Transaction> transactions){
        return transactions.stream()
                .anyMatch(t->t.showTrader().showCity().equals("Milano"));
    }

    public static List<Transaction> problem6(List<Transaction> transactions){
        return transactions.stream()
                .filter(t->t.showTrader().showCity().equals("Cambridge"))
                .collect(Collectors.toList());
    }

    public static int problem7(List<Transaction> transactions){
        return transactions.stream()
                .map(Transaction::showValue)
                .reduce(0, Integer::max);
    }

    public static int problem8(List<Transaction> transactions){
        return transactions.stream()
                .map(Transaction::showValue)
                .reduce(0, Integer::min);
    }

    public static void main(String[] args){

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


    }

}
