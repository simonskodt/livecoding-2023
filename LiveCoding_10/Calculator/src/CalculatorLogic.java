public class CalculatorLogic {
    private String operator;
    private int value;
    public CalculatorLogic() {
        this.operator = "";
    }

    public void calculate(int valueFromTextField) {
        switch (operator) {
            case "+" -> value += valueFromTextField;
            case "-" -> value -= valueFromTextField;
            case "×" -> value *= valueFromTextField;
            case "÷" -> value /= valueFromTextField;
            default  -> value = valueFromTextField;
        }
    }

    public void clear() {
        operator = "";
        value = 0;
    }

    public String getOperator() {
        return operator;
    }

    public int getValue() {
        return value;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
