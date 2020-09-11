package game;

import javax.swing.*;
import java.awt.*;

public class Back {

    private String menu = "src/main/resources/files/back_sakura.jpg";
    private String field = "src/main/resources/files/field.png";
    private String info = "src/main/resources/files/back_info.png";
    private String end = "src/main/resources/files/back_win.jpg";

    public void draw(Graphics2D g) {

        if (Panel.state.equals(Panel.STATES.MENU)) {
            g.drawImage(new ImageIcon(menu).getImage(), 0, 0, null);
        }

        if (Panel.state.equals(Panel.STATES.PLAY)) {
            g.drawImage(new ImageIcon(field).getImage(), 0, 0, null);
        }

        if (Panel.state.equals(Panel.STATES.INFO)) {
            g.drawImage(new ImageIcon(info).getImage(), 0, 0, null);
        };

        if (Panel.state.equals(Panel.STATES.END)) {
            g.drawImage(new ImageIcon(end).getImage(), 0, 0, null);
        };
    }
}
