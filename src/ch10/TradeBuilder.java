package ch10;

public class TradeBuilder {
    private final MethodChainingOrderBuilder builder;
    public final Trade trade = new Trade();

    private TradeBuilder(MethodChainingOrderBuilder builder, Trade.Type type, int quantity){
        this.builder = builder;
        trade.setType(type);
        trade.setQuantity(quantity);
    }

    public static TradeBuilder formTradeBuilder(MethodChainingOrderBuilder builder, Trade.Type type, int quantity){
        return new TradeBuilder(builder, type, quantity);
    }

    public StockBuilder stock(String symbol){
        return StockBuilder.formStockBuilder(builder, trade, symbol);
    }

}
