import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame implements ActionListener {
    private JRadioButton redButton, yellowButton, greenButton;
    private JPanel lightPanel;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setSize(200, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(yellowButton);
        buttonGroup.add(greenButton);

        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        lightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int width = getWidth();
                int height = getHeight();
                int circleDiameter = Math.min(width, height) / 4;
                int x = (width - circleDiameter) / 2;
                int y = (height - 3 * circleDiameter) / 2;

                g.setColor(Color.BLACK);
                g.fillRect(x, y, circleDiameter, 3 * circleDiameter);

                if (redButton.isSelected()) {
                    g.setColor(Color.RED);
                    g.fillOval(x, y, circleDiameter, circleDiameter);
                } else {
                    g.setColor(Color.GRAY);
                    g.fillOval(x, y, circleDiameter, circleDiameter);
                }

                if (yellowButton.isSelected()) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x, y + circleDiameter, circleDiameter, circleDiameter);
                } else {
                    g.setColor(Color.GRAY);
                    g.fillOval(x, y + circleDiameter, circleDiameter, circleDiameter);
                }

                if (greenButton.isSelected()) {
                    g.setColor(Color.GREEN);
                    g.fillOval(x, y + 2 * circleDiameter, circleDiameter, circleDiameter);
                } else {
                    g.setColor(Color.GRAY);
                    g.fillOval(x, y + 2 * circleDiameter, circleDiameter, circleDiameter);
                }
            }
        };

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);

        add(lightPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        lightPanel.repaint();
    }

    public static void main(String[] args) {
        new TrafficLightSimulator();
    }
}
