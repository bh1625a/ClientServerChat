package main;

import javax.swing.*;
import java.awt.*;

public abstract class UserInterface {

    private JFrame jframe;
    private JPanel jPanel;

    public UserInterface(int height, int width){
        jPanel.setPreferredSize(new Dimension(width, height));
    }


    // Common methods to all interfaces
    public abstract void run();
    public abstract void exit();


}
