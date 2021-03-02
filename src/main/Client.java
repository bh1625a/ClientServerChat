package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Client {

    private String id;
    int clientPort;
    String clientIP;
    int serverPort;
    String serverIPAddress;
    Scanner in;
    PrintWriter out;
    LoginGUI loginGui;
    ChatGUI chatGUI;
    JFrame frame = new JFrame();
    JFrame frame2 = new JFrame();
    private boolean isConnected;



    public Client() {
        this.isConnected = false;
    }

    private void run() throws IOException {
        if (!isConnected) {
            openLoginWindow();
        } else {
            openChatWindow();
        }

    }

    public void tryConnect() throws IOException{
            Socket socket = new Socket(this.getServerIPAddress(), this.getServerPort());

            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.startsWith("SUBMITID")) {
                    out.println(this.getId());
                    isConnected = true;
                    break;
                }
            }
    }

    public void openLoginWindow(){
        loginGui = new LoginGUI(this);
        frame.setTitle("Login");
        frame.setContentPane(loginGui.getPanel());
        frame.pack();
    }

    public void openChatWindow(){
        chatGUI = new ChatGUI();
        frame2.setTitle("Chat");
        frame2.setContentPane(chatGUI.getPanel());
        frame2.pack();
    }

    public void setId(String id){
        this.id = id;
    }

    public void setClientPort(String clientPort) {
        this.clientPort = Integer.valueOf(clientPort);
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public void setServerIPAddress(String ipAddress){
        this.serverIPAddress = ipAddress;
    }

    public void setServerPort(String portNumber){
        this.serverPort = Integer.valueOf(portNumber);
    }

    public String getId() {
        return id;
    }

    public int getClientPort() {
        return clientPort;
    }

    public String getClientIP() {
        return clientIP;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getServerIPAddress() {
        return serverIPAddress;
    }

    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.err.println("Pass the server IP as the sole command line argument");
//            return;
//        }
        Client client = new Client();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.frame2.setVisible(true);
        client.run();
    }
}
