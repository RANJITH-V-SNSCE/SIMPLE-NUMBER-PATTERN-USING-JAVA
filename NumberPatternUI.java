import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberPatternUI extends JFrame implements ActionListener {
    private JComboBox<String> patternComboBox;
    private JTextField heightField;
    private JButton generateButton;
    private JTextArea patternTextArea;

    public NumberPatternUI() {
        setTitle("Pattern Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 1, 5, 5));
        inputPanel.setBackground(Color.WHITE);

        JLabel patternLabel = new JLabel("Pattern Type:");
        patternLabel.setForeground(Color.BLACK);
        patternComboBox = new JComboBox<>(new String[]{"Pyramid", "Alphabet A", "Square", "Triangle", "Diamond", "Hourglass", "Staircase"});
        patternComboBox.setBackground(Color.WHITE);
        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setForeground(Color.BLACK);
        heightField = new JTextField();
        generateButton = new JButton("Generate Pattern");
        generateButton.setBackground(Color.BLACK);
        generateButton.setForeground(Color.WHITE);

        generateButton.addActionListener(this);

        inputPanel.add(patternLabel);
        inputPanel.add(patternComboBox);
        inputPanel.add(heightLabel);
        inputPanel.add(heightField);
        inputPanel.add(generateButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        patternTextArea = new JTextArea();
        patternTextArea.setEditable(false);
        patternTextArea.setBackground(Color.LIGHT_GRAY);
        patternTextArea.setForeground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(patternTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            generatePattern();
        }
    }

    private void generatePattern() {
        String patternType = (String) patternComboBox.getSelectedItem();
        int height = Integer.parseInt(heightField.getText());

        StringBuilder pattern = new StringBuilder();

        switch (patternType) {
            case "Pyramid":
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < height - i - 1; j++) {
                        pattern.append(" ");
                    }
                    for (int k = 0; k <= i; k++) {
                        pattern.append(k + 1).append(" ");
                    }
                    pattern.append("\n");
                }
                break;
            case "Alphabet A":
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < height - i; j++) {
                        pattern.append(" ");
                    }
                    for (int j = 0; j <= i * 2; j++) {
                        if (j == 0 || j == i * 2 || i == height / 2)
                            pattern.append("*");
                        else
                            pattern.append(" ");
                    }
                    pattern.append("\n");
                }
                break;
            case "Square":
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < height; j++) {
                        pattern.append("*");
                    }
                    pattern.append("\n");
                }
                break;
            case "Triangle":
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j <= i; j++) {
                        pattern.append("* ");
                    }
                    pattern.append("\n");
                }
                break;
            case "Diamond":
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < height - i; j++) {
                        pattern.append(" ");
                    }
                    for (int j = 0; j <= i * 2; j++) {
                        pattern.append("*");
                    }
                    pattern.append("\n");
                }
                for (int i = height - 2; i >= 0; i--) {
                    for (int j = 0; j < height - i; j++) {
                        pattern.append(" ");
                    }
                    for (int j = 0; j <= i * 2; j++) {
                        pattern.append("*");
                    }
                    pattern.append("\n");
                }
                break;
            case "Hourglass":
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < i; j++) {
                        pattern.append(" ");
                    }
                    for (int j = 0; j < (height - i) * 2 - 1; j++) {
                        pattern.append("*");
                    }
                    pattern.append("\n");
                }
                for (int i = height - 2; i >= 0; i--) {
                    for (int j = 0; j < i; j++) {
                        pattern.append(" ");
                    }
                    for (int j = 0; j < (height - i) * 2 - 1; j++) {
                        pattern.append("*");
                    }
                    pattern.append("\n");
                }
                break;
            case "Staircase":
                for (int i = 1; i <= height; i++) {
                    for (int j = 1; j <= i; j++) {
                        pattern.append(j);
                    }
                    pattern.append("\n");
                }
                break;
            default:
                pattern.append("Invalid pattern type!");
        }

        patternTextArea.setText(pattern.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberPatternUI::new);
    }
}
