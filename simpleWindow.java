import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class simpleWindow {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Пример окна");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        frame.add(label);


        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    JOptionPane.showMessageDialog(frame, "Карина");
                }
            }
        });

        frame.setVisible(true);
    }
}