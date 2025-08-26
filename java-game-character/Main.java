import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        // Naming
        String warriorName;
        do {
            warriorName = JOptionPane.showInputDialog("Enter warrior's name: ");
            if (warriorName == null) {
                JOptionPane.showMessageDialog(null, "Please input character name!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if ( warriorName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please input character name!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        } while (true);

        String mageName;
        do {
            mageName = JOptionPane.showInputDialog("Enter mage's name: ");
            if (mageName == null) {
                JOptionPane.showMessageDialog(null, "Please input character name!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if ( mageName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please input character name!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        } while (true);

        // Instantiation
        GameCharacter warrior = new Warrior(warriorName.trim().toUpperCase());
        warrior.setMaxHealth(150);
        warrior.setCurrentHealth(150);
        warrior.setBaseDamage(25);

        GameCharacter mage = new Mage(mageName.trim().toUpperCase());
        mage.setMaxHealth(60);
        mage.setCurrentHealth(60);
        mage.setBaseDamage(40);

        // Frame
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(500, 300));
        frame.getContentPane().setBackground(new Color(0x16161D));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        //frame.setVisible(true);

        // Panels
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBounds(10, 200, 480, 90);
        buttonsPanel.setLayout(null);
        buttonsPanel.setOpaque(false);
        buttonsPanel.setBackground(Color.red);
        frame.add(buttonsPanel);

        JButton attackButton = new JButton("Attack");
        attackButton.setBounds(20, 30, 200, 30);
        attackButton.setFocusable(false);
        attackButton.setBackground(new Color(0x1616D));
        attackButton.setForeground(Color.WHITE);
        attackButton.setEnabled(false);
        attackButton.setVisible(true);
        buttonsPanel.add(attackButton);

        JButton secretPowerButton = new JButton("Special Power");
        secretPowerButton.setBounds(240, 30, 200, 30);
        secretPowerButton.setFocusable(false);
        secretPowerButton.setBackground(new Color(0x1616D));
        secretPowerButton.setForeground(Color.WHITE);
        secretPowerButton.setEnabled(false);
        buttonsPanel.add(secretPowerButton);

        // Player ONE
        JPanel playerOneStatsPanel = new JPanel();
        playerOneStatsPanel.setBounds(10, 10, 240, 90);
        playerOneStatsPanel.setLayout(null);
        playerOneStatsPanel.setOpaque(false);
        playerOneStatsPanel.setBackground(Color.green);
        frame.add(playerOneStatsPanel);

        JLabel playerOneName = new JLabel();
        playerOneName.setText("PLAYER 1: " + warrior.name);
        playerOneName.setBounds(0, 0, 240, 20);
        playerOneName.setHorizontalAlignment(JLabel.LEFT);
        playerOneName.setVerticalAlignment(JLabel.CENTER);
        playerOneName.setForeground(Color.WHITE);
        playerOneStatsPanel.add(playerOneName);

        JLabel playerOneHealth = new JLabel();
        playerOneHealth.setText("HP: " + warrior.getCurrentHealth() + "/" + warrior.getMaxHealth());
        playerOneHealth.setBounds(0, 20, 240, 20);
        playerOneHealth.setHorizontalAlignment(JLabel.LEFT);
        playerOneHealth.setVerticalAlignment(JLabel.CENTER);
        playerOneHealth.setForeground(Color.WHITE);
        playerOneStatsPanel.add(playerOneHealth);

        JLabel playerOneAttackDamage = new JLabel();
        playerOneAttackDamage.setText("ATK: " + warrior.getBaseDamage());
        playerOneAttackDamage.setBounds(0, 40, 240, 20);
        playerOneAttackDamage.setHorizontalAlignment(JLabel.LEFT);
        playerOneAttackDamage.setVerticalAlignment(JLabel.CENTER);
        playerOneAttackDamage.setForeground(Color.WHITE);
        playerOneStatsPanel.add(playerOneAttackDamage);

        // Player TWO
        JPanel playerTwoStatsPanel = new JPanel();
        playerTwoStatsPanel.setBounds(250, 10, 240, 90);
        playerTwoStatsPanel.setLayout(null);
        playerTwoStatsPanel.setOpaque(false);
        playerTwoStatsPanel.setBackground(Color.blue);
        frame.add(playerTwoStatsPanel);

        JLabel playerTwoName = new JLabel();
        playerTwoName.setText("PLAYER 2: " + mage.name);
        playerTwoName.setBounds(0, 0, 240, 20);
        playerTwoName.setHorizontalAlignment(JLabel.RIGHT);
        playerTwoName.setVerticalAlignment(JLabel.CENTER);
        playerTwoName.setForeground(Color.WHITE);
        playerTwoStatsPanel.add(playerTwoName);

        JLabel playerTwoHealth = new JLabel();
        playerTwoHealth.setText("HP: " + mage.getCurrentHealth() + "/" + mage.getMaxHealth());
        playerTwoHealth.setBounds(0, 20, 240, 20);
        playerTwoHealth.setHorizontalAlignment(JLabel.RIGHT);
        playerTwoHealth.setVerticalAlignment(JLabel.CENTER);
        playerTwoHealth.setForeground(Color.WHITE);
        playerTwoStatsPanel.add(playerTwoHealth);

        JLabel playerTwoAttackDamage = new JLabel();
        playerTwoAttackDamage.setText("ATK: " + mage.getBaseDamage());
        playerTwoAttackDamage.setBounds(0, 40, 240, 20);
        playerTwoAttackDamage.setHorizontalAlignment(JLabel.RIGHT);
        playerTwoAttackDamage.setVerticalAlignment(JLabel.CENTER);
        playerTwoAttackDamage.setForeground(Color.WHITE);
        playerTwoStatsPanel.add(playerTwoAttackDamage);

        // In-game Console
        JPanel console = new JPanel();
        console.setBounds(10, 110, 480, 80);
        console.setLayout(null);
        console.setOpaque(false);
        console.setBackground(Color.green);
        frame.add(console);

        JLabel consoleLog = new JLabel();
        consoleLog.setHorizontalAlignment(JLabel.LEFT);
        consoleLog.setVerticalAlignment(JLabel.CENTER);
        consoleLog.setText("> GAME START!");
        consoleLog.setOpaque(false);
        consoleLog.setForeground(Color.WHITE);
        consoleLog.setBackground(Color.red);
        consoleLog.setBounds(0, 60, 480, 20);
        console.add(consoleLog);



        frame.pack();
        frame.setVisible(true);

        waitSec(2);
        int playerTurn = 0;
        // Coin Flip
        double coinFlip = Math.round(Math.random() * 101);
        if (coinFlip % 2 == 0) {
            playerTurn = 1;
            consoleLog.setText("> Player 1: " + warrior.name + " takes the first turn!");
        } else {
            playerTurn = 2;
            consoleLog.setText("> Player 2: " + mage.name + " takes the first turn!");
        }

        attackButton.setEnabled(true);
        secretPowerButton.setEnabled(true);

        final int[] finalPlayerTurn = {playerTurn};

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (finalPlayerTurn[0] == 1) {
                    //attackButton.setEnabled(false);

                    mage.damage(warrior.getBaseDamage());
                    consoleLog.setText("> " + warrior.attack() + " Dealing " + warrior.getBaseDamage() + " damage!");
                    updateHealthText(playerTwoHealth, mage);
                    finalPlayerTurn[0] = 2;
                    checkWinner(warrior, mage, frame);
                } else {
                    //attackButton.setEnabled(false);

                    warrior.damage(mage.getBaseDamage());
                    consoleLog.setText("> " + mage.attack() + " Dealing " + mage.getBaseDamage() + " damage!");
                    updateHealthText(playerOneHealth, warrior);
                    finalPlayerTurn[0] = 1;
                    checkWinner(warrior, mage, frame);
                }
            }
        });

        secretPowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (finalPlayerTurn[0] == 1) {
                    //attackButton.setEnabled(false);

                    mage.damage((int) (warrior.getBaseDamage() * 1.5));
                    consoleLog.setText("> " + warrior.specialMove() + " Dealing " + warrior.getBaseDamage() * 1.5 + " damage!");
                    updateHealthText(playerTwoHealth, mage);
                    finalPlayerTurn[0] = 2;
                    checkWinner(warrior, mage, frame);
                } else {
                    //attackButton.setEnabled(false);

                    warrior.damage((int) (mage.getBaseDamage() * 1.5));
                    consoleLog.setText("> " + mage.specialMove() + " Dealing " + mage.getBaseDamage() * 1.5 + " damage!");
                    updateHealthText(playerOneHealth, warrior);
                    finalPlayerTurn[0] = 1;
                    checkWinner(warrior, mage, frame);
                }
            }
        });
    }



    public static void checkWinner(GameCharacter player1, GameCharacter player2, JFrame frame) {
        if (player1.getCurrentHealth() <= 0) {
            JOptionPane.showMessageDialog(null, player2.name + " WINS THE BATTLE!");
            frame.dispose();
        }
        if (player2.getCurrentHealth() <= 0) {
            JOptionPane.showMessageDialog(null, player1.name + " WINS THE BATTLE!");
            frame.dispose();
        }
    }

    public static void waitSec(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateHealthText(JLabel label, GameCharacter character) {
        label.setText("HP: " + character.getCurrentHealth() + "/" + character.getMaxHealth());
    }
}
