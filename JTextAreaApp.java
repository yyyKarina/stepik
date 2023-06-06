import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaApp extends JFrame {

    private JTextField textField;
    private JButton writeButton;
    private JTextArea textArea;

    public JTextAreaApp() {
        setTitle("Text Area App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 260);
        setLocationRelativeTo(null);

        textField = new JTextField(20);
        writeButton = new JButton("Записать");
        textArea = new JTextArea(10, 20);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String line = textField.getText();
                if (!line.isEmpty()) {
                    textArea.append(line + "\n");
                    textField.setText("");
                }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(writeButton);
        panel.add(buttonPanel, BorderLayout.CENTER);

        panel.add(scrollPane, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTextAreaApp app = new JTextAreaApp();
                app.setVisible(true);
            }
        });
    }
}