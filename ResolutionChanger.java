import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResolutionChanger extends JFrame {
    private JComboBox<String> resolutionComboBox;
    private JButton okButton;

    public ResolutionChanger() {
        setTitle("Выберите разрешение экрана");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());

        resolutionComboBox = new JComboBox<>(new String[]{"800x600", "1024x768", "1280x720", "1920x1080"});
        add(resolutionComboBox);

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedResolution = (String) resolutionComboBox.getSelectedItem();
                String[] resolutionParts = selectedResolution.split("x");
                int width = Integer.parseInt(resolutionParts[0]);
                int height = Integer.parseInt(resolutionParts[1]);
                openWindowWithResolution(width, height);
            }
        });
        add(okButton);

        pack();
        setLocationRelativeTo(null);
    }

    private void openWindowWithResolution(int width, int height) {
        JFrame window = new JFrame();
        window.setTitle("Окно с разрешением " + width + "x" + height);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ResolutionChanger changer = new ResolutionChanger();
                changer.setVisible(true);
            }
        });
    }
}