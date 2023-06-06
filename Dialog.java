import javax.swing.*;

public class Dialog {


    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Введите ваше имя:");

        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Вы не ввели имя.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, "Привет, " + name + "!", "Информация", JOptionPane.INFORMATION_MESSAGE);
    }
}