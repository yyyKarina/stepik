import javax.swing.JOptionPane;

public class ApproveWindow {
    public static void main(String[] args) {
        int firstAnswer = JOptionPane.showConfirmDialog(null, "Да?", "Вопрос 1", JOptionPane.YES_NO_OPTION);
        int firstResponse;
        if (firstAnswer == JOptionPane.YES_OPTION) {
            firstResponse = 1;
        } else {
            firstResponse = 0;
        }
        int secondAnswer = JOptionPane.showConfirmDialog(null, "Тоже да?", "Вопрос 2", JOptionPane.YES_NO_OPTION);
        int secondResponse;
        if (secondAnswer == JOptionPane.YES_OPTION) {
            secondResponse = 1;
        } else {
            secondResponse = 0;
        }
        String message = "";
        if ((firstResponse == 1 ) & (secondResponse == 1)){
            message = "А вот нет";
        }
        if ((firstResponse == 1 ) & (secondResponse == 0)){
            message = "Неа";
        }
        if ((firstResponse == 0 ) & (secondResponse == 1)){
            message = "Да";
        }
        if ((firstResponse == 0 ) & (secondResponse == 0)){
            message = "Да";
        }
        JOptionPane.showMessageDialog(null, message, "Ответы", JOptionPane.INFORMATION_MESSAGE);
    }
}