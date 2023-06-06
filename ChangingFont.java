import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ChangingFont extends JFrame {

    private JLabel label;
    private JSlider slider;

    public ChangingFont() {
        setTitle("Пример окна");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);

        label = new JLabel("Моя первая надпись!");
        label.setFont(new Font("Arial", Font.ITALIC, 50));

        slider = new JSlider(JSlider.HORIZONTAL, 5, 100, 50);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int fontSize = slider.getValue();
                label.setFont(label.getFont().deriveFont((float) fontSize));
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        panel.add(label, constraints);
        constraints.gridy = 1;
        panel.add(slider, constraints);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChangingFont window = new ChangingFont();
                window.setVisible(true);
            }
        });
    }
}