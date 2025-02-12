import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_bank implements ActionListener{

    JFrame frame;
    JPanel panel;
    JLabel label1, label2, label3, errorLabel;
    JButton withdrawButton, depositButton;
    TextField withdrawAmount, depositAmount;
    String withdrawString;
    String depositString;
    double withdrawMoney;
    double depositMoney;
    GridBagConstraints gbc;
    double money = 0.0;

    public GUI_bank() {
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 10, 5, 10);
        label1 = new JLabel("LuluBank");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        label1.setOpaque(true);
        panel.add(label1, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 10, 10, 10);
        label2 = new JLabel("Welcome to the bank!");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label2.setBackground(new Color(130, 30, 230));
        panel.add(label2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 10, 5, 10);
        label3 = new JLabel("Your balance: "+money+"$");
        label3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        label3.setOpaque(true);
        panel.add(label3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 10, 5, 10);
        withdrawAmount = new TextField("", 20);
        panel.add(withdrawAmount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 10, 5, 10);
        withdrawButton = new JButton("withdraw");
        withdrawButton.addActionListener(this);
        panel.add(withdrawButton, gbc);


        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(20, 10, 5, 10);
        depositAmount = new TextField("", 20);
        panel.add(depositAmount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 10, 5, 10);
        depositButton = new JButton("deposit");
        depositButton.addActionListener(this);
        panel.add(depositButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 10, 5, 10);
        errorLabel = new JLabel("");
        label3.setFont(new Font("Times New Roman", Font.BOLD, 12));
        label3.setOpaque(true);
        panel.add(errorLabel, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(new JPanel(), gbc);

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("LuluBank");
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new GUI_bank();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        errorLabel.setText("");
        if(e.getSource()==withdrawButton) {
            try {
                withdrawMoney = Double.parseDouble(withdrawAmount.getText());
                if(money == 0 || money < withdrawMoney){
                    errorLabel.setText("Insufficient funds");
                }
                else {
                    money -= withdrawMoney;
                    label3.setText("Your balance: "+money+"$");
                }
            } catch (NumberFormatException ex) {
                errorLabel.setText("Please input valid amount");
            }
                        
            
        }
        else if(e.getSource()==depositButton) {
            try {
                depositMoney = Double.parseDouble(depositAmount.getText());
                money += depositMoney;
                label3.setText("Your balance: "+money+"$");

            } catch (NumberFormatException ex) {
                errorLabel.setText("Please input valid amount");
            }

        }
    }

}
