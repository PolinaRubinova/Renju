package game;

import javax.swing.*;
import java.awt.*;

public class Back {

    public void draw(Graphics2D g) {

        if (Panel.state.equals(Panel.STATES.MENU)) {
            g.drawImage(new ImageIcon("C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\back_sakura.jpg").getImage(), 0, 0, null);
        }
        if (Panel.state.equals(Panel.STATES.PLAY)) {
            g.drawImage(new ImageIcon("C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\field.png").getImage(), 0, 0, null);
        }

        if (Panel.state.equals(Panel.STATES.INFO)) {
            g.drawImage(new ImageIcon("C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\back_info.png").getImage(), 0, 0, null);
        };

        if (Panel.state.equals(Panel.STATES.END)) {
            g.drawImage(new ImageIcon("C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\back_win.jpg").getImage(), 0, 0, null);
        };
    }
}
