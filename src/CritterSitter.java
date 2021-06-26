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
        mainFrame = new JFrame("CritterSitter");
        mainFrame.getContentPane().setBackground(Color.decode("0x2B2929"));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setPreferredSize(new Dimension(550, 700));
        goHome();
    }

    public void foodPanelSetup() {
        foodPanel = new JPanel();
        foodPanel.setBackground(Color.decode("0x2B2929"));
        foodPanel.setLayout(new GridLayout(7, 1));

        homeIcon = new ImageIcon("src/home.png");
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setBackground(Color.decode("0x2B2929"));
        homePanel.setSize(new Dimension(500, 35));
        home = new JButton(homeIcon);
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
        foodPanel.add(homePanel);

        JLabel title1 = new JLabel("<html><p style=\"text-align:left;\">Portion Settings</p></html>", JLabel.LEFT);
        title1.setForeground(Color.decode("0xDFDFDF"));
        title1.setFont(new Font("SansSerif", Font.BOLD, 30));
        foodPanel.add(title1);

        JPanel amountPanel = new JPanel();
        amountPanel.setBackground(Color.decode("0x2B2929"));
        amountPanel.setLayout(new FlowLayout());//
        JLabel grams = new JLabel("<html><p style=\"text-align:left;\">Grams (one meal):</p></html>", JLabel.LEFT);
        grams.setForeground(Color.decode("0xDFDFDF"));
        grams.setFont(new Font("SansSerif", Font.PLAIN, 16));
        amountPanel.add(grams);
        JPanel enterGramsPanel = new JPanel();
        enterGramsPanel.setLayout(new FlowLayout());
        enterGramsPanel.setBackground(Color.decode("0x2B2929"));
        JTextField enterGrams = new JTextField(5);
        enterGramsPanel.add(enterGrams);
        amountPanel.add(enterGramsPanel);
        JLabel filler = new JLabel("                                                 ");
        filler.setForeground(Color.decode("0x2B2929"));
        filler.setBackground(Color.decode("0x2B2929"));
        amountPanel.add(filler);
        foodPanel.add(amountPanel);

        JLabel title2 = new JLabel("<html><p style=\"text-align:left;\">Timer Settings</p></html>", JLabel.LEFT);
        title2.setForeground(Color.decode("0xDFDFDF"));
        title2.setFont(new Font("SansSerif", Font.BOLD, 30));
        foodPanel.add(title2);

        JPanel timerPanel = new JPanel();
        timerPanel.setBackground(Color.decode("0x2B2929"));
        timerPanel.setLayout(new GridLayout(3, 2, 0, 10));

        JLabel freq = new JLabel("<html><p style=\"text-align:left;\">Frequency (per day):</p></html>", JLabel.LEFT);
        freq.setForeground(Color.decode("0xDFDFDF"));
        freq.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String[] freqC = { "One","Two", "Three","Four","Five","Six"};
        final JComboBox<String> freqChoices = new JComboBox<String>(freqC);
        timerPanel.add(freq);
        timerPanel.add(freqChoices);

        JLabel time1 = new JLabel("<html><p style=\"text-align:left;\">First mealtime:</p></html>", JLabel.LEFT);
        time1.setForeground(Color.decode("0xDFDFDF"));
        time1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String[] time1C = {"12:00 AM", "1:00 AM","2:00 AM", "3:00 AM","4:00 AM","5:00 AM","6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM","11:00 AM", "12:00 PM","1:00 PM","2:00 PM","3:00 PM", "4:00 PM", "5:00 APM", "6:00 PM", "7:00 PM","8:00 PM", "9:00 PM","10:00 PM","11:00 PM"};
        final JComboBox<String> time1Choices = new JComboBox<String>(time1C);
        timerPanel.add(time1);
        timerPanel.add(time1Choices);
        foodPanel.add(timerPanel);

        JLabel time2 = new JLabel("<html><p style=\"text-align:left;\">Second mealtime:</p></html>", JLabel.LEFT);
        time2.setForeground(Color.decode("0xDFDFDF"));
        time2.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String[] time2C = {"12:00 AM", "1:00 AM","2:00 AM", "3:00 AM","4:00 AM","5:00 AM","6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM","11:00 AM", "12:00 PM","1:00 PM","2:00 PM","3:00 PM", "4:00 PM", "5:00 APM", "6:00 PM", "7:00 PM","8:00 PM", "9:00 PM","10:00 PM","11:00 PM","12:00 AM"};
        final JComboBox<String> time2Choices = new JComboBox<String>(time2C);
        timerPanel.add(time2);
        timerPanel.add(time2Choices);
        foodPanel.add(timerPanel);

        mainFrame.add(foodPanel);
    }

    public void monitorPanelSetup() {
        monitorPanel = new JPanel();
        monitorPanel.setBackground(Color.decode("0x2B2929"));
        monitorPanel.setPreferredSize(new Dimension(500, 700));
        monitorPanel.setLayout(new FlowLayout());

        JPanel monitorPanelInside = new JPanel();
        monitorPanelInside.setBackground(Color.decode("0x2B2929"));
        monitorPanelInside.setPreferredSize(new Dimension(500, 600));
        monitorPanelInside.setLayout(new GridLayout(2, 1, 0, 5));

        homeIcon = new ImageIcon("src/home.png");
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setBackground(Color.decode("0x2B2929"));
        homePanel.setSize(new Dimension(500, 35));
        home = new JButton(homeIcon);
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
        monitorPanel.add(homePanel);

        ImageIcon rec = new ImageIcon("src/rec.png");
        JLabel recLabel = new JLabel(rec);
        recLabel.setBackground(Color.decode("0x2B2929"));
        monitorPanelInside.add(recLabel);

        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.decode("0x2B2929"));
        textPanel.setLayout(new GridLayout(3, 1));

        JPanel recordPanel = new JPanel();
        recordPanel.setBackground(Color.decode("0x2B2929"));

        JLabel record = new JLabel("<html><p style=\"text-align:left;\">Stream your voice:</p></html>", JLabel.LEFT);
        record.setForeground(Color.decode("0xDFDFDF"));
        record.setFont(new Font("SansSerif", Font.PLAIN, 20));
        recordPanel.add(record);
        JButton recordButton = new JButton("▶");
        JPanel recordButtonPanel = new JPanel();
        recordButtonPanel.setLayout(new FlowLayout());
        recordButtonPanel.setBackground(Color.decode("0x2B2929"));
        recordButtonPanel.setSize(new Dimension(50, 50));
        recordButton.setSize(new Dimension(50, 50));
        recordButtonPanel.add(recordButton);
        recordPanel.add(recordButtonPanel);
        textPanel.add(recordPanel);

        JLabel noiseOptions = new JLabel("<html><p style=\"text-align:left;\">Sound Options</p></html>", JLabel.LEFT);
        noiseOptions.setForeground(Color.decode("0xDFDFDF"));
        noiseOptions.setFont(new Font("SansSerif", Font.BOLD, 26));
        textPanel.add(noiseOptions);

        JPanel soundPanel = new JPanel();
        soundPanel.setBackground(Color.decode("0x2B2929"));
        soundPanel.setLayout(new GridLayout(3, 2));

        JLabel classic = new JLabel("<html><p style=\"text-align:left;\">Classical music</p></html>", JLabel.LEFT);
        classic.setForeground(Color.decode("0xDFDFDF"));
        classic.setFont(new Font("SansSerif", Font.PLAIN, 16));
        soundPanel.add(classic);

        JButton play1 = new JButton("▶");
        JPanel play1Panel = new JPanel();
        play1Panel.setLayout(new FlowLayout());
        play1Panel.setBackground(Color.decode("0x2B2929"));
        play1Panel.setSize(new Dimension(50, 50));
        play1.setSize(new Dimension(50, 50));
        play1Panel.add(play1);
        soundPanel.add(play1Panel);

        JLabel bird = new JLabel("<html><p style=\"text-align:left;\">Bird chirping</p></html>", JLabel.LEFT);
        bird.setForeground(Color.decode("0xDFDFDF"));
        bird.setFont(new Font("SansSerif", Font.PLAIN, 16));
        soundPanel.add(bird);

        JButton play2 = new JButton("▶");
        JPanel play2Panel = new JPanel();
        play2Panel.setLayout(new FlowLayout());
        play2Panel.setBackground(Color.decode("0x2B2929"));
        play2Panel.setSize(new Dimension(50, 50));
        play2.setSize(new Dimension(50, 50));
        play2Panel.add(play2);
        soundPanel.add(play2Panel);

        JLabel squeak = new JLabel("<html><p style=\"text-align:left;\">Squeaky toy</p></html>", JLabel.LEFT);
        squeak.setForeground(Color.decode("0xDFDFDF"));
        squeak.setFont(new Font("SansSerif", Font.PLAIN, 16));
        soundPanel.add(squeak);

        JButton play3 = new JButton("▶");
        JPanel play3Panel = new JPanel();
        play3Panel.setLayout(new FlowLayout());
        play3Panel.setBackground(Color.decode("0x2B2929"));
        play3Panel.setSize(new Dimension(50, 50));
        play3.setSize(new Dimension(50, 50));
        play3Panel.add(play3);
        soundPanel.add(play3Panel);

        textPanel.add(soundPanel);
        monitorPanelInside.add(textPanel);

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

        homeIcon = new ImageIcon("src/home.png");
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setBackground(Color.decode("0x2B2929"));
        homePanel.setSize(new Dimension(500, 35));
        home = new JButton(homeIcon);
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
        imagePanel.setLayout(new GridLayout(2, 2, 0, 5));

        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.decode("0x2B2929"));
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
