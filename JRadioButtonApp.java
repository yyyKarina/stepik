import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioButtonApp extends JFrame {

    private JRadioButton springRadioButton;
    private JRadioButton summerRadioButton;
    private JRadioButton autumnRadioButton;
    private JRadioButton winterRadioButton;
    private ButtonGroup seasonButtonGroup;
    private JButton answerButton;
    private JLabel answerLabel;

    public JRadioButtonApp() {
        setTitle("Season RadioButton App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        springRadioButton = new JRadioButton("Весна");
        summerRadioButton = new JRadioButton("Лето");
        autumnRadioButton = new JRadioButton("Осень");
        winterRadioButton = new JRadioButton("Зима");

        seasonButtonGroup = new ButtonGroup();
        seasonButtonGroup.add(springRadioButton);
        seasonButtonGroup.add(summerRadioButton);
        seasonButtonGroup.add(autumnRadioButton);
        seasonButtonGroup.add(winterRadioButton);

        answerButton = new JButton("Ответить");
        answerLabel = new JLabel("Ответ: ");

        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSeason = "";
                if (springRadioButton.isSelected()) {
                    selectedSeason = "Весна";
                } else if (summerRadioButton.isSelected()) {
                    selectedSeason = "Лето";
                } else if (autumnRadioButton.isSelected()) {
                    selectedSeason = "Осень";
                } else if (winterRadioButton.isSelected()) {
                    selectedSeason = "Зима";
                }
                answerLabel.setText("Ответ: " + selectedSeason);
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(springRadioButton);
        panel.add(summerRadioButton);
        panel.add(autumnRadioButton);
        panel.add(winterRadioButton);
        panel.add(answerButton);
        panel.add(answerLabel);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JRadioButtonApp app = new JRadioButtonApp();
                app.setVisible(true);
            }
        });
    }
}