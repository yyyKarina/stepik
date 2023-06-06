import javax.swing.*;
import java.awt.*;

public class FirstInscription extends JFrame {

    public FirstInscription() {
        setTitle("Пример окна");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 300);
        setLocationRelativeTo(null); // Размещение окна по центру экрана

        // Создание и настройка JLabel
        JLabel label = new JLabel("Моя первая надпись!");
        label.setFont(new Font("Arial", Font.ITALIC, 50));

        // Создание панели с GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Отступы

        // Добавление JLabel в панель
        panel.add(label, constraints);

        // Размещение панели в центре окна
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FirstInscription window = new FirstInscription();
                window.setVisible(true);
            }
        });
    }
}