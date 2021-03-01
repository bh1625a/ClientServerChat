package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * A simple Swing-based client for the chat server. Graphically it is a frame with a text
 * field for entering messages and a textarea to see the whole dialog.
 *
 * The client follows the following Chat Protocol. When the server sends "SUBMITNAME" the
 * client replies with the desired screen name. The server will keep sending "SUBMITNAME"
 * requests as long as the client submits screen names that are already in use. When the
 * server sends a line beginning with "NAMEACCEPTED" the client is now allowed to start
 * sending the server arbitrary strings to be broadcast to all chatters connected to the
 * server. When the server sends a line beginning with "MESSAGE" then all characters
 * following this string should be displayed in its message area.
 */
public class Client {

    private String id;
    int clientPort;
    String clientIP;
    int serverPort;
    String serverIPAddress;
    Scanner in;
    PrintWriter out;
    LoginGUI gui;
    JFrame frame = new JFrame();
    private boolean isConnected;


    /**
     * Constructs the client by laying out the GUI and registering a listener with the
     * textfield so that pressing Return in the listener sends the textfield contents
     * to the server. Note however that the textfield is initially NOT editable, and
     * only becomes editable AFTER the client receives the NAMEACCEPTED message from
     * the server.
     */
    public Client() {
        this.isConnected = false;
    }

    private void run() throws IOException {
        openLoginWindow();

    }

    public void tryConnect() throws IOException{
        try {
            Socket socket = new Socket(this.getServerIPAddress(), this.serverPort);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

//            while (in.hasNextLine()) {
//                String line = in.nextLine();
//                if (line.startsWith("SUBMITNAME")) {
//                    //out.println(getName());
//                } else if (line.startsWith("NAMEACCEPTED")) {
//                    this.frame.setTitle("Chatter - " + line.substring(13));
////                    textField.setEditable(true);
////                } else if (line.startsWith("MESSAGE")) {
////                    messageArea.append(line.substring(8) + "\n");
//                }
//            }
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    public void openLoginWindow(){
        gui = new LoginGUI(this);
        frame.setTitle("Login");
        frame.setContentPane(gui.getPanel());
        frame.pack();
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
        client.run();
    }
}
