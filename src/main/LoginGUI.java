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
    private JPanel OuterPanel;
    private Client client;

    public LoginGUI(){}

    public LoginGUI(Client client) {
        this.client = client;

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.setId(idInput.getText());
                client.setClientPort(clientPortInput.getText());
                client.setClientIP(clientIPInput.getText());
                client.setServerIPAddress(serverIPInput.getText());
                client.setServerPort(serverPortInput.getText());


            }
        });
    }

    public JPanel getPanel(){
        return loginPanel;
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("App");
//        frame.setContentPane(new LoginGUI().getPanel());
//        frame.pack();
//        frame.setVisible(true);
//    }
    
    




}
