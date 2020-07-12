package game;

import javax.swing.*;
import java.awt.*;

public class Window {
    public static void main(String[] args) {
        JFrame startFrame = new JFrame("Renju");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setLocation(0,0);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //startFrame.setSize(screenSize);
        startFrame.setSize(1000, 600);
        //startFrame.add(new Panel());

        Panel panel = new Panel();
        startFrame.setContentPane(panel);

        panel.mainTimer.start();
        startFrame.setVisible(true);
    }
}