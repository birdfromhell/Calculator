import javax.swing.*;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

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
}