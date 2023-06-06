import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioButtonCustom extends JDialog {
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JButton okButton;

    public JRadioButtonCustom(Frame parent) {
        super(parent, "Выбор разрешения", true);

        ButtonGroup buttonGroup = new ButtonGroup();

        radioButton1 = new JRadioButton("800x600");
        radioButton2 = new JRadioButton("1024x768");
        radioButton3 = new JRadioButton("1280x1024");

        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Закрываем диалоговое окно
                openMainWindow();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);
        panel.add(okButton);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    private void openMainWindow() {
        if (radioButton1.isSelected()) {
            openWindow(800, 600);
        } else if (radioButton2.isSelected()) {
            openWindow(1024, 768);
        } else if (radioButton3.isSelected()) {
            openWindow(1280, 1024);
        }
    }

    private void openWindow(int width, int height) {
        JFrame mainFrame = new JFrame("Основное окно");
        mainFrame.setSize(width, height);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JRadioButtonCustom dialog = new JRadioButtonCustom(null);
                dialog.setVisible(true);
            }
        });
    }
}