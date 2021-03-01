package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    private JPanel loginPanel;
    private JTextField idInput;
    private JTextField clientPortInput;
    private JTextField serverPortInput;
    private JTextField serverIPInput;
    private JTextField clientIPInput;
    private JButton connectButton;

    public LoginGUI() {

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idInput.getText();
                String clientPort = clientPortInput.getText();
                String clientIP = clientIPInput.getText();
                String serverPort = serverPortInput.getText();
                String serverIP = serverIPInput.getText();



            }
        });
    }

    public JPanel getPanel(){
        return loginPanel;
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("App");
//        frame.setContentPane(new LoginGUI().loginPanel);
//        frame.pack();
//        frame.setVisible(true);
//    }
    
    




}
