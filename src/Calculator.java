import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Calculator {
    private JTextField display;
    private String operator = "";
    private double firstOperand = 0.0;
    private boolean isNewEntry = false;

    public Calculator() {

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);

        JPanel panel = new JPanel(new GridLayout(4,5));

        for (int i = 1; i <= 9; i++){
            panel.add(new JButton(String.valueOf(i)));
        }

        panel.add(new JButton("*"));
        panel.add(new JButton("0"));
        panel.add(new JButton("#"));
        panel.add(new JButton("+"));
        panel.add(new JButton("+"));
        panel.add(new JButton("-"));
        panel.add(new JButton("/"));
        panel.add(new JButton("="));
        frame.add(panel);

        frame.setVisible(true);
    }

    private void addButton(Container container, String text){
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.matches("\\d")) {
                    if (isNewEntry) {
                        display.setText("");
                        isNewEntry = false;
                    }
                    display.setText(display.getText() + text);
                }else {
                    operator = text;
                    firstOperand = Double.parseDouble(display.getText());
                    isNewEntry = true;
                    if (operator.equals("=")){
                        display.setText(String.valueOf(firstOperand));
                        operator = "";
                    }
                }
            }
        });
        container.add(button);
    }
    public static void main(String[] args) {
        new Calculator();}

}