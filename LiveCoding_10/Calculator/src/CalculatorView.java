import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private final Container contentPane;
    private final Font font = new Font("Sans-Serif", Font.PLAIN, 60);
    private final String INITIAL_TEXT_FIELD_VALUE = "0";
    private final JTextField textField;
    private final JPanel buttonPanel, operatorsPanel;
    private final CalculatorLogic logic;

    public CalculatorView() {
        super("Calculator");
        this.contentPane = getContentPane();
        this.textField = new JTextField(INITIAL_TEXT_FIELD_VALUE);
        this.buttonPanel = new JPanel();
        this.operatorsPanel = new JPanel();
        this.logic = new CalculatorLogic();
        buildContentPane();
        finalSetup();
    }

    private void buildContentPane() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final int WINDOW_WIDTH = 400, WINDOW_HEIGHT = 600;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        contentPane.setLayout(new BorderLayout());
        setupMenuBar();
        displayCalculations();
        displayButtons();
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem quitItem = new JMenuItem("Quit");

        quitItem.addActionListener(_ -> {
            System.exit(0);
        });

        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private void displayCalculations() {
        textField.setFont(font);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
    }

    private void displayButtons() {
        buttonPanel.setLayout(new GridLayout(4, 3));
        operatorsPanel.setLayout(new GridLayout(4, 1));
        addNumbersToButtons();
        addOperatorButton("+");
        addOperatorButton("-");
        addOperatorButton("×");
        addOperatorButton("÷");
        addEqualsButton();
        addClearButton();
        contentPane.add(textField, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
        contentPane.add(operatorsPanel, BorderLayout.EAST);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(Color.DARK_GRAY);
        return button;
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(color);
        return button;
    }

    private void addNumbersToButtons() {
        int[] order = {7, 8, 9, 4, 5, 6, 1, 2, 3, 0};

        for (int digit : order) {
            String label = String.valueOf(digit);
            JButton button = createButton(label);

            button.addActionListener(_ -> {
                if (textField.getText().equals(INITIAL_TEXT_FIELD_VALUE) || textField.getText().isEmpty())
                    textField.setText(label);
                else
                    textField.setText(textField.getText() + label);
            });

            buttonPanel.add(button);
        }
    }

    private void addOperatorButton(String operator) {
        JButton button = createButton(operator, Color.gray);

        button.addActionListener(_ -> {
            if (!textField.getText().isEmpty()) {
                logic.calculate(getValueFromTextField());
                logic.setOperator(operator);
                textField.setText(INITIAL_TEXT_FIELD_VALUE);
            }
        });

        operatorsPanel.add(button);
    }

    private void addEqualsButton() {
        JButton equalsButton = createButton("=", new Color(238, 75, 75));

        equalsButton.addActionListener(_ -> {
            logic.calculate(getValueFromTextField());
            textField.setText("" + logic.getValue());
            logic.setOperator("");
        });

        buttonPanel.add(equalsButton);
    }
    
    private void addClearButton() {
        JButton clearButton = createButton("AC", new Color(27, 145, 23));
        
        clearButton.addActionListener(_ -> {
            textField.setText(INITIAL_TEXT_FIELD_VALUE);
            logic.clear();
        });

        buttonPanel.add(clearButton);
    }

    private int getValueFromTextField() {
        return Integer.parseInt(textField.getText());
    }

    private void finalSetup() {
        pack();
        setVisible(true);
    }
}
