import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickerApp extends JFrame {

    private JButton clickButton;
    private JLabel countLabel;
    private int clickCount;

    public ClickerApp() {
        setTitle("Clicker App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 120);
        setLocationRelativeTo(null);

        clickButton = new JButton("Click Me!");
        countLabel = new JLabel("Click Count: 0");
        countLabel.setFont(countLabel.getFont().deriveFont(24f));

        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                countLabel.setText("Click Count: " + clickCount);
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(countLabel);
        panel.add(clickButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClickerApp app = new ClickerApp();
                app.setVisible(true);
            }
        });
    }
}