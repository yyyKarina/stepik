import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class UserRegistration {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public UserRegistration() {
        frame = new JFrame();
        frame.setTitle("Регистрация пользователя");
        frame.setSize(400, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel welcomeLabel = new JLabel("Добро пожаловать!");
        frame.add(welcomeLabel);

        JButton registerButton = new JButton("Зарегистрироваться");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(frame, "Хотите зарегистрироваться в программе?", "Регистрация", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    showUsernameWindow();
                } else {
                    System.exit(0);
                }
            }
        });
        frame.add(registerButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showUsernameWindow() {
        frame.getContentPane().removeAll();
        frame.setSize(400, 100);

        JLabel usernameLabel = new JLabel("Введите логин (больше 5 символов, без пробелов):");
        frame.add(usernameLabel);

        usernameField = new JTextField(20);
        frame.add(usernameField);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                if (isValidUsername(username)) {
                    showPasswordWindow();
                } else {
                    JOptionPane.showMessageDialog(frame, "Некорректный логин! Попробуйте еще раз.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(nextButton);

        frame.revalidate();
        frame.repaint();
    }

    private boolean isValidUsername(String username) {
        return username.length() > 5 && !username.contains(" ");
    }

    private void showPasswordWindow() {
        frame.getContentPane().removeAll();
        frame.setSize(500, 100);

        JLabel passwordLabel = new JLabel("Введите пароль (больше 8 символов, без пробелов, содержит цифру и букву):");
        frame.add(passwordLabel);

        passwordField = new JPasswordField(20);
        frame.add(passwordField);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
                if (isValidPassword(password)) {
                    showConfirmPasswordWindow(password);
                } else {
                    JOptionPane.showMessageDialog(frame, "Некорректный пароль! Попробуйте еще раз.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
                Arrays.fill(passwordChars, ' '); // Clear password field after use
            }
        });
        frame.add(nextButton);

        frame.revalidate();
        frame.repaint();
    }

    private boolean isValidPassword(String password) {
        return password.length() > 8 && !password.contains(" ") && password.matches(".*\\d.*") && password.matches(".*[a-zA-Z].*");
    }

    private void showConfirmPasswordWindow(final String password) {
        frame.getContentPane().removeAll();
        frame.setSize(300, 150);

        JLabel confirmPasswordLabel = new JLabel("Повторите пароль:");
        frame.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField(20);
        frame.add(confirmPasswordField);

        JButton registerButton = new JButton("Зарегистрироваться");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] confirmPasswordChars = confirmPasswordField.getPassword();
                String confirmPassword = new String(confirmPasswordChars);
                if (confirmPassword.equals(password)) {
                    showRegistrationSuccessWindow();
                } else {
                    JOptionPane.showMessageDialog(frame, "Пароли не совпадают! Попробуйте еще раз.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
                Arrays.fill(confirmPasswordChars, ' '); // Clear password field after use
            }
        });
        frame.add(registerButton);

        frame.revalidate();
        frame.repaint();
    }

    private void showRegistrationSuccessWindow() {
        frame.getContentPane().removeAll();
        frame.setSize(350, 80);

        JLabel successLabel = new JLabel("Вы успешно зарегистрированы!");
        frame.add(successLabel);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserRegistration registration = new UserRegistration();
            }
        });
    }
}