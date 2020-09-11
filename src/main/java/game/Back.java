package game;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Back {

    private String menu = (new File("src/main/resources/files/back_sakura.jpg")).getAbsolutePath();
    private String field = (new File("src/main/resources/files/field.png")).getAbsolutePath();
    private String info = (new File("src/main/resources/files/back_info.png")).getAbsolutePath();
    private String end = (new File("src/main/resources/files/back_win.jpg")).getAbsolutePath();

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
