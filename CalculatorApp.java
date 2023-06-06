import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {

    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;

    private double firstNumber;
    private String operator;

    public CalculatorApp() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 300);
        setLocationRelativeTo(null);

        displayField = new JTextField();
        displayField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        operationButtons = new JButton[4];
        operationButtons[0] = new JButton("+");
        operationButtons[1] = new JButton("-");
        operationButtons[2] = new JButton("*");
        operationButtons[3] = new JButton("/");

        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        for (int i = 7; i <= 9; i++) {
            buttonPanel.add(numberButtons[i]);
        }
        buttonPanel.add(operationButtons[0]);

        for (int i = 4; i <= 6; i++) {
            buttonPanel.add(numberButtons[i]);
        }
        buttonPanel.add(operationButtons[1]);

        for (int i = 1; i <= 3; i++) {
            buttonPanel.add(numberButtons[i]);
        }
        buttonPanel.add(operationButtons[2]);

        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(operationButtons[3]);

        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        getContentPane().add(panel);

        addListeners();
    }

    private void addListeners() {
        for (int i = 0; i < 10; i++) {
            final int number = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayField.setText(displayField.getText() + number);
                }
            });
        }

        operationButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(displayField.getText());
                operator = "+";
                displayField.setText("");
            }
        });

        operationButtons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(displayField.getText());
                operator = "-";
                displayField.setText("");
            }
        });

        operationButtons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(displayField.getText());
                operator = "*";
                displayField.setText("");
            }
        });

        operationButtons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(displayField.getText());
                operator = "/";
                displayField.setText("");
            }
        });

        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double secondNumber = Double.parseDouble(displayField.getText());
                double result = 0;

                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber != 0) {
                            result = firstNumber / secondNumber;
                        } else {
                            JOptionPane.showMessageDialog(null, "Ошибка: деление на ноль", "Ошибка", JOptionPane.ERROR_MESSAGE);
                            displayField.setText("");
                            return;
                        }
                        break;
                }

                displayField.setText(String.valueOf(result));
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculatorApp app = new CalculatorApp();
                app.setVisible(true);
            }
        });
    }
}