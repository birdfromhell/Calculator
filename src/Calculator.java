import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JTextField display;
    private String operator;
    private double firstOperand;
    private boolean isNewEntry;

    public Calculator() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        JPanel panel = new JPanel(new GridLayout(5, 4));

        display = new JTextField();
        frame.add(display, BorderLayout.NORTH);

        for (int i = 1; i <= 9; i++) {
            addButton(panel, String.valueOf(i));
        }

        addButton(panel, "0");
        addButton(panel, "+");
        addButton(panel, "-");
        addButton(panel, "*");
        addButton(panel, "/");
        addButton(panel, "=");
        addButton(panel, "C");
        addButton(panel, "CE");

        frame.add(panel);

        frame.setVisible(true);
    }

    private void addButton(Container container, String text) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {
            if (text.matches("\\d")) {
                if (isNewEntry) {
                    display.setText("");
                    isNewEntry = false;
                }
                display.setText(display.getText() + text);
            } else if (text.equals("C")) {
                firstOperand = 0.0;
                operator = "";
                display.setText("");
            } else if (text.equals("CE")) {
                display.setText("");
            } else {
                if (!operator.isEmpty()) {
                    calculate();
                }
                operator = text;
                firstOperand = Double.parseDouble(display.getText());
                isNewEntry = true;
            }
        });
        container.add(button);
    }

    public void calculate() {
        double secondOperand = Double.parseDouble(display.getText());

        switch (operator) {
            case "+":
                firstOperand += secondOperand;
                break;
            case "-":
                firstOperand -= secondOperand;
                break;
            case "*":
                firstOperand *= secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    firstOperand /= secondOperand;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
        display.setText(String.valueOf(firstOperand));
    }

    public static void main(String[] args) {
        new Calculator();
    }
}