package ch10;

public class MethodChainingOrderBuilder {

    public final Order order = new Order();

    private MethodChainingOrderBuilder(String customer){
        order.setCustomer(customer);
    }

    public static MethodChainingOrderBuilder forCustomer(String customer){
        return new MethodChainingOrderBuilder(customer);
    }

    public TradeBuilder buy(int quantity){
        return TradeBuilder.formTradeBuilder(this, Trade.Type.BUY, quantity);
    }

    public TradeBuilder sell(int quantity){
        return TradeBuilder.formTradeBuilder(this, Trade.Type.SELL, quantity);
    }

    public MethodChainingOrderBuilder addTrade(Trade trade){
        order.addTrade(trade);
        return this;
    }

    public Order order(){
        return order;
    }

}
