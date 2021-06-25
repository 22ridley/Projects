import com.sun.tools.javac.comp.Flow;

import java.awt.*;
import javax.swing.*;

public class CritterSitter extends JPanel {
    JFrame mainFrame;
    JLabel logoLabel, credits, profileLabel;
    JPanel buttonPanel, buttonFlow, startPanel, accountPanel, foodPanel, monitorPanel;
    ImageIcon logo, profile, homeIcon;
    JButton food, monitor, account, home;

    public CritterSitter() {
        goHome();
    }

    public void foodPanelSetup() {
        foodPanel = new JPanel();
        foodPanel.setBackground(Color.decode("0x2B2929"));
        foodPanel.setLayout(new FlowLayout());

        JPanel foodPanelInside = new JPanel();
        foodPanelInside.setBackground(Color.decode("0x2B2929"));
        foodPanelInside.setSize(550, 700);
        foodPanelInside.setLayout(new GridLayout(2, 1));

        homeIcon = new ImageIcon("src/home.png");
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setBackground(Color.decode("0x2B2929"));
        homePanel.setSize(new Dimension(500, 35));
        home = new JButton(homeIcon);
        home.setFont(new Font("SansSerif", Font.BOLD, 15));
        home.setSize(new Dimension(50, 25));
        home.addActionListener(
                e -> {
                    try {
                        foodPanel.setVisible(false);
                        goHome();
                    } catch (Exception f) {
                    }
                }
        );
        homePanel.add(home);
        foodPanelInside.add(homePanel);

        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.decode("0x2B2929"));
        textPanel.setSize(600, 600);
        textPanel.setLayout(new GridLayout(3, 1, 0, 10));

        JLabel title1 = new JLabel("<html><p style=\"text-align:left;\">Portion Settings</p></html>", JLabel.LEFT);
        title1.setForeground(Color.decode("0xDFDFDF"));
        title1.setFont(new Font("SansSerif", Font.BOLD, 30));
        textPanel.add(title1);

        JPanel amountPanel = new JPanel();
        amountPanel.setBackground(Color.decode("0x2B2929"));
        amountPanel.setLayout(new GridLayout(1, 2, 0, 10));
        JLabel grams = new JLabel("<html><p style=\"text-align:left;\">Grams (one meal):</p></html>", JLabel.LEFT);
        grams.setForeground(Color.decode("0xDFDFDF"));
        grams.setFont(new Font("SansSerif", Font.PLAIN, 16));
        amountPanel.add(grams);
        JTextField enterGrams = new JTextField(7);
        amountPanel.add(enterGrams);
        textPanel.add(amountPanel);

        JLabel title2 = new JLabel("<html><p style=\"text-align:left;\">Timer Settings</p></html>", JLabel.LEFT);
        title2.setForeground(Color.decode("0xDFDFDF"));
        title2.setFont(new Font("SansSerif", Font.BOLD, 30));
        textPanel.add(title2);

        foodPanelInside.add(textPanel);
        foodPanel.add(foodPanelInside);
        mainFrame.add(foodPanel);
    }

    public void monitorPanelSetup() {
        monitorPanel = new JPanel();
        monitorPanel.setBackground(Color.decode("0x2B2929"));
        monitorPanel.setPreferredSize(new Dimension(500, 700));
        monitorPanel.setLayout(new FlowLayout());

        JPanel monitorPanelInside = new JPanel();
        monitorPanelInside.setBackground(Color.decode("0x2B2929"));
        monitorPanelInside.setPreferredSize(new Dimension(500, 700));
        monitorPanelInside.setLayout(new GridLayout(2, 1, 0, 5));
        monitorPanelInside.setVisible(true);

        homeIcon = new ImageIcon("src/home.png");
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setBackground(Color.decode("0x2B2929"));
        homePanel.setSize(new Dimension(500, 35));
        home = new JButton(homeIcon);
        home.setFont(new Font("SansSerif", Font.BOLD, 15));
        home.setSize(new Dimension(50, 25));
        home.addActionListener(
                e -> {
                    try {
                        monitorPanel.setVisible(false);
                        goHome();
                    } catch (Exception f) {
                    }
                }
        );
        homePanel.add(home);
        monitorPanelInside.add(homePanel);
        monitorPanel.add(monitorPanelInside);
        mainFrame.add(monitorPanel);
    }

    public void accountPanelSetup() {
        accountPanel = new JPanel();
        accountPanel.setBackground(Color.decode("0x2B2929"));
        accountPanel.setPreferredSize(new Dimension(500, 700));
        accountPanel.setLayout(new FlowLayout());

        JPanel accountPanelInside = new JPanel();
        accountPanelInside.setBackground(Color.decode("0x2B2929"));
        accountPanelInside.setPreferredSize(new Dimension(500, 700));
        accountPanelInside.setLayout(new GridLayout(2, 1, 0, 5));
        accountPanelInside.setVisible(true);

        homeIcon = new ImageIcon("src/home.png");
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setBackground(Color.decode("0x2B2929"));
        homePanel.setSize(new Dimension(500, 35));
        home = new JButton(homeIcon);
        home.setFont(new Font("SansSerif", Font.BOLD, 15));
        home.setSize(new Dimension(50, 25));
        home.addActionListener(
                e -> {
                    try {
                        accountPanel.setVisible(false);
                        goHome();
                    } catch (Exception f) {
                    }
                }
        );
        homePanel.add(home);
        accountPanel.add(homePanel);

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.decode("0x2B2929"));
        imagePanel.setPreferredSize(new Dimension(500, 400));
        imagePanel.setLayout(new GridLayout(2, 2, 0, 5));

        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.decode("0x2B2929"));
        textPanel.setPreferredSize(new Dimension(500, 300));
        textPanel.setLayout(new GridLayout(8, 2, 0, 0));

        JLabel accountName = new JLabel("<html><p style=\"text-align:center;\">Account Name: <br/>Sarah Ridley</p></html>", JLabel.CENTER);
        accountName.setForeground(Color.decode("0xDFDFDF"));
        accountName.setFont(new Font("SansSerif", Font.BOLD, 22));
        JLabel petName = new JLabel("<html><p style=\"text-align:center;\">Pet Name: <br/>Cato</p></html>", JLabel.CENTER);
        petName.setForeground(Color.decode("0xDFDFDF"));
        petName.setFont(new Font("SansSerif", Font.BOLD, 22));

        profile = new ImageIcon("src/profile.png");
        profileLabel = new JLabel(profile);
        imagePanel.add(profileLabel);
        imagePanel.add(accountName);
        ImageIcon animalProfile = new ImageIcon("src/animal.png");
        JLabel animalProfileLabel = new JLabel(animalProfile);
        imagePanel.add(animalProfileLabel);
        imagePanel.add(petName);

        JLabel petType = new JLabel("<html><p style=\"text-align:left;\">Pet type: Cat</p></html>", JLabel.LEFT);
        petType.setForeground(Color.decode("0xDFDFDF"));
        petType.setFont(new Font("SansSerif", Font.PLAIN, 15));
        textPanel.add(petType);

        JPanel petChooser = new JPanel();
        petChooser.setBackground(Color.decode("0x2B2929"));
        petChooser.setLayout(new GridLayout(1, 2));

        JLabel changePet = new JLabel("<html><p style=\"text-align:left;\">Change pet type: </p></html>", JLabel.LEFT);
        changePet.setForeground(Color.decode("0xDFDFDF"));
        changePet.setFont(new Font("SansSerif", Font.PLAIN, 15));
        petChooser.add(changePet);

        String[] choices = { "Cat","Dog", "Fish","Bird","Hamster","Snake"};
        final JComboBox<String> animals = new JComboBox<String>(choices);
        animals.setVisible(true);

        petChooser.add(changePet);
        petChooser.add(animals);
        textPanel.add(petChooser);

        JLabel date = new JLabel("<html><p style=\"text-align:left;\">Date joined: June 25th, 2021</p></html>", JLabel.LEFT);
        date.setForeground(Color.decode("0xDFDFDF"));
        date.setFont(new Font("SansSerif", Font.PLAIN, 15));
        textPanel.add(date);
        JLabel email = new JLabel("<html><p style=\"text-align:left;\">Email: 22ridleysk@gmail.com</p></html>", JLabel.LEFT);
        email.setForeground(Color.decode("0xDFDFDF"));
        email.setFont(new Font("SansSerif", Font.PLAIN, 15));
        textPanel.add(email);
        JLabel num = new JLabel("<html><p style=\"text-align:left;\">Phone number: (984) 439-9739</p></html>", JLabel.LEFT);
        num.setForeground(Color.decode("0xDFDFDF"));
        num.setFont(new Font("SansSerif", Font.PLAIN, 15));
        textPanel.add(num);
        JLabel Enum = new JLabel("<html><p style=\"text-align:left;\">Emergency contact number: (919) 308-3220</p></html>", JLabel.LEFT);
        Enum.setForeground(Color.decode("0xDFDFDF"));
        Enum.setFont(new Font("SansSerif", Font.PLAIN, 15));
        textPanel.add(Enum);

        accountPanelInside.add(imagePanel);
        accountPanelInside.add(textPanel);
        accountPanel.add(accountPanelInside);
        mainFrame.add(accountPanel);
    }

    public void goHome() {
        mainFrame = new JFrame("CritterSitter");
        mainFrame.getContentPane().setBackground(Color.decode("0x2B2929"));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setPreferredSize(new Dimension(550, 700));

        startPanel = new JPanel();
        startPanel.setBackground(Color.decode("0x2B2929"));
        startPanel.setLayout(new GridLayout(2, 1));

        logo = new ImageIcon("src/logo.png");
        logoLabel = new JLabel(logo);
        startPanel.add(logoLabel);

        buttonFlow = new JPanel();
        buttonFlow.setBackground(Color.decode("0x2B2929"));
        buttonFlow.setLayout(new FlowLayout());

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("0x2B2929"));
        buttonPanel.setLayout(new GridLayout(4, 1, 20, 15));

        food = new JButton("FEEDING");
        food.setBackground(Color.decode("0x2B2929"));
        food.setPreferredSize(new Dimension(200, 70));
        food.setFont(new Font("SansSerif", Font.BOLD, 15));
        food.addActionListener(
                e -> {
                    try {
                        startPanel.setVisible(false);
                        foodPanelSetup();
                    } catch (Exception f) {
                    }
                }
        );
        buttonPanel.add(food);

        monitor = new JButton("MONITOR");
        monitor.setBackground(Color.decode("0x2B2929"));
        monitor.setPreferredSize(new Dimension(200, 70));
        monitor.setFont(new Font("SansSerif", Font.BOLD, 15));
        monitor.addActionListener(
                e -> {
                    try {
                        startPanel.setVisible(false);
                        monitorPanelSetup();
                    } catch (Exception f) {
                    }
                }
        );
        buttonPanel.add(monitor);

        account = new JButton("ACCOUNT");
        account.setBackground(Color.decode("0x2B2929"));
        account.setPreferredSize(new Dimension(200, 70));
        account.setFont(new Font("SansSerif", Font.BOLD, 15));
        account.addActionListener(
                e -> {
                    try {
                        startPanel.setVisible(false);
                        accountPanelSetup();
                    } catch (Exception f) {
                    }
                }
        );
        buttonPanel.add(account);

        credits = new JLabel("<html><p style=\"text-align:center;\">Created by Annamaria Lund, <br/>Sarah Ridley, Aarthi Sudhir, <br/>and Katherine Yang</p></html>", JLabel.CENTER);
        credits.setForeground(Color.decode("0xDFDFDF"));
        credits.setFont(new Font("SansSerif", Font.PLAIN, 10));

        buttonPanel.add(credits);
        buttonFlow.add(buttonPanel);
        startPanel.add(buttonFlow);
        mainFrame.add(startPanel);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String args[]) {
        CritterSitter test = new CritterSitter();
    }
}
