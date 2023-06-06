import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JSpinnerApp extends JFrame {

    private JSpinner bookSpinner;
    private JButton answerButton;
    private JLabel answerLabel;

    public JSpinnerApp() {
        setTitle("Book Spinner App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        bookSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        answerButton = new JButton("Ответить");
        answerLabel = new JLabel("Ответ: ");

        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bookCount = (int) bookSpinner.getValue();
                answerLabel.setText("Ответ: " + bookCount);
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(bookSpinner);
        panel.add(answerButton);
        panel.add(answerLabel);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JSpinnerApp app = new JSpinnerApp();
                app.setVisible(true);
            }
        });
    }
}