import java.awt.*;
import javax.swing.*;

public class PalletVisualizer extends JPanel {

    JFrame mainFrame;
    JPanel labelPanel, controlPanel, firstPanel, secondPanel, thirdPanel, fourthPanel;
    JLabel label;
    JButton add;
    JTextField panel1text, panel2text, panel3text, panel4text;

    public PalletVisualizer() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Pallet Visualizer");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.getContentPane().setBackground(Color.black);
        mainFrame.setPreferredSize(new Dimension(560, 650));

        labelPanel = new JPanel();
        label = new JLabel("Enter color hex codes below or add more panels:", JLabel.CENTER);
        label.setPreferredSize(new Dimension(550, 100));
        label.setForeground(Color.white);
        label.setFont(new Font("Calibri", Font.BOLD, 18));
        labelPanel.setBackground(Color.decode("0x212121"));
        labelPanel.add(label);
        mainFrame.add(labelPanel);

        firstPanel = new JPanel();
        firstPanel.setBackground(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        secondPanel = new JPanel();
        secondPanel.setBackground(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        thirdPanel = new JPanel();
        thirdPanel.setBackground(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        fourthPanel = new JPanel();
        fourthPanel.setBackground(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));

        panel1text = new JTextField(7);
        panel1text.addActionListener(
                e -> {
                    try {
                        String text1 = panel1text.getText();
                        firstPanel.setBackground(Color.decode("0x" + text1));
                    } catch (NumberFormatException numberFormatException) {
                        numberFormatException.printStackTrace();
                    }
                }
        );
        firstPanel.add(panel1text);

        panel2text = new JTextField(7);
        panel2text.addActionListener(
                e -> {
                    try {
                        String text2 = panel2text.getText();
                        secondPanel.setBackground(Color.decode("0x" + text2));
                    } catch (NumberFormatException numberFormatException) {
                        numberFormatException.printStackTrace();
                    }
                }
        );
        secondPanel.add(panel2text);

        panel3text = new JTextField(7);
        panel3text.addActionListener(
                e -> {
                    try {
                        String text3 = panel3text.getText();
                        thirdPanel.setBackground(Color.decode("0x" + text3));
                    } catch (NumberFormatException numberFormatException) {
                        numberFormatException.printStackTrace();
                    }
                }
        );
        thirdPanel.add(panel3text);

        panel4text = new JTextField(7);
        panel4text.addActionListener(
                e -> {
                    try {
                        String text4 = panel4text.getText();
                        fourthPanel.setBackground(Color.decode("0x" + text4));
                    } catch (NumberFormatException numberFormatException) {
                        numberFormatException.printStackTrace();
                    }
                }
        );
        fourthPanel.add(panel4text);

        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(550, 650));
        controlPanel.setLayout(new GridLayout(3, 2));
        controlPanel.setBackground(Color.WHITE);

        controlPanel.add(firstPanel);
        controlPanel.add(secondPanel);
        controlPanel.add(thirdPanel);
        controlPanel.add(fourthPanel);
        controlPanel.setPreferredSize(new Dimension(550, 400));
        mainFrame.add(controlPanel);

        add = new JButton("+");
        add.setBackground(Color.decode("0x565656"));
        add.setOpaque(true);
        add.setPreferredSize(new Dimension(550, 100));
        add.setFont(new Font("Calibri", Font.BOLD, 26));
        add.addActionListener(
                e -> {
                    try {
                        JPanel tempPanel = new JPanel();
                        tempPanel.setPreferredSize(new Dimension(250, 250));
                        tempPanel.setBackground(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
                        JTextField tempText = new JTextField(7);
                        tempText.addActionListener(
                                f -> {
                                    try {
                                        String text = tempText.getText();
                                        tempPanel.setBackground(Color.decode("0x" + text));
                                    } catch (NumberFormatException numberFormatException) {
                                        numberFormatException.printStackTrace();
                                    }
                                }
                        );
                        tempPanel.add(tempText);
                        controlPanel.add(tempPanel);
                        mainFrame.pack();
                    } catch (Exception f) {
                        System.out.println(f);;
                    }
                }
        );
        mainFrame.add(add);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String args[]) {
        PalletVisualizer test = new PalletVisualizer();
    }
}