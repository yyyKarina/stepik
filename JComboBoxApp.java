import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxApp extends JFrame {

    private JComboBox<String> colorComboBox;
    private JCheckBox customColorCheckBox;
    private JTextField customColorTextField;
    private JButton answerButton;
    private JLabel answerLabel;

    public JComboBoxApp() {
        setTitle("Color ComboBox App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(100, 200);
        setLocationRelativeTo(null);

        String[] colors = {"Белый", "Синий", "Красный"};
        colorComboBox = new JComboBox<>(colors);

        customColorCheckBox = new JCheckBox("Свой цвет");
        customColorTextField = new JTextField(10);
        customColorTextField.setEnabled(false); // Изначально поле для ввода отключено

        customColorCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customColorTextField.setEnabled(customColorCheckBox.isSelected());
            }
        });

        answerButton = new JButton("Ответить");
        answerLabel = new JLabel("Ответ: ");

        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor;
                if (customColorCheckBox.isSelected()) {
                    selectedColor = customColorTextField.getText();
                } else {
                    selectedColor = (String) colorComboBox.getSelectedItem();
                }
                answerLabel.setText("Ответ: " + selectedColor);
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(colorComboBox);
        panel.add(customColorCheckBox);
        panel.add(customColorTextField);
        panel.add(answerButton);
        panel.add(answerLabel);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JComboBoxApp app = new JComboBoxApp();
                app.setVisible(true);
            }
        });
    }
}