package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatGUI {
    private JTextField messageInput;
    private JButton sendButton;
    private JTextArea displayMessages;
    private JList listOfUsers;
    private JPanel mainPanel;
    private JPanel listPanel;

    public ChatGUI() {
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        ChatGUI gui = new ChatGUI();
        JFrame frame = new JFrame("Chat");
        frame.setContentPane(gui.mainPanel);

        frame.pack();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
