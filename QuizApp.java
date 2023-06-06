import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame {

    private JLabel questionLabel;
    private JRadioButton[] answerOptions;
    private JButton submitButton;

    private String[] questions = {
            "Вопрос 1: Какой город является столицей Франции?",
            "Вопрос 2: Какой год является годом основания города Москвы?",
            "Вопрос 3: Какой из этих языков не относится к славянской языковой группе?",
            "Вопрос 4: Какая страна является самой многонациональной в мире?",
            "Вопрос 5: Какой из этих городов расположен в Италии?",
            "Вопрос 6: Кто написал роман 'Война и мир'?",
            "Вопрос 7: Какое химическое вещество обозначается символом H2O?",
            "Вопрос 8: Какое животное является символом Года по китайскому календарю в 2022 году?",
            "Вопрос 9: Как называется самая большая планета Солнечной системы?",
            "Вопрос 10: Какое из этих государств не расположено на континенте Африка?"
    };

    private String[][] options = {
            {"Милан", "Лондон", "Париж", "Берлин"},
            {"1147", "1200", "1533", "1701"},
            {"Русский", "Чешский", "Болгарский", "Украинский"},
            {"Индия", "Россия", "Бразилия", "Китай"},
            {"Барселона", "Рим", "Афины", "Мадрид"},
            {"Лев Толстой", "Федор Достоевский", "Иван Тургенев", "Антон Чехов"},
            {"Кислород", "Углекислый газ", "Вода", "Сера"},
            {"Крыса", "Змея", "Обезьяна", "Тигр"},
            {"Марс", "Юпитер", "Сатурн", "Земля"},
            {"Египет", "Южная Африка", "Мадагаскар", "Нигерия"}
    };

    private int[] correctAnswers = {2, 0, 1, 1, 1, 0, 2, 3, 1, 3};

    private int currentQuestion = 0;
    private int score = 0;

    public QuizApp() {
        setTitle("Викторина");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        answerOptions = new JRadioButton[4];
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            answerOptions[i] = new JRadioButton();
            buttonGroup.add(answerOptions[i]);
        }

        submitButton = new JButton("Ответить");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        for (int i = 0; i < 4; i++) {
            optionsPanel.add(answerOptions[i]);
        }
        panel.add(optionsPanel, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);

        getContentPane().add(panel);

        loadQuestion();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
    }

    private void loadQuestion() {
        questionLabel.setText(questions[currentQuestion]);
        for (int i = 0; i < 4; i++) {
            answerOptions[i].setText(options[currentQuestion][i]);
            answerOptions[i].setSelected(false);
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (answerOptions[i].isSelected()) {
                if (i == correctAnswers[currentQuestion]) {
                    score++;
                }
                break;
            }
        }

        currentQuestion++;
        if (currentQuestion < questions.length) {
            loadQuestion();
        } else {
            showResult();
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Количество правильных ответов: " + score, "Результат", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                QuizApp app = new QuizApp();
                app.setVisible(true);
            }
        });
    }
}