package main;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


class HandleConnection extends Thread {

    Socket s = null;
    JTextArea display;
    public HandleConnection(Socket s, JTextArea display) {
        this.s = s;
        this.display = display;
    }
    public void run() {
        display.append("New thread started\n");
        try {
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader (new InputStreamReader(is));
            String str = br.readLine();
            while (str != null) {
                display.append("received from client : " + str + "\n");
                str = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        display.append("Thread ending\n");
    } // end of run()
}
