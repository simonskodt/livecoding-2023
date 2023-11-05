public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("×"),
    DIVIDE("÷");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getOperator() {
        return symbol;
    }
}