package game;

import java.awt.*;
import java.io.File;

public class End {

    public static boolean click = false;

    public String but2 = (new File("src/main/resources/files/but2.png")).getAbsolutePath();
    public String but2ch = (new File("src/main/resources/files/but2ch.png")).getAbsolutePath();

    Menu.ButtMenu button1 = new Menu.ButtMenu(
            350, 250, 300, 68, "Новая игра", but2, 35);
    Menu.ButtMenu button2 = new Menu.ButtMenu(
            350, 350, 300, 68, "Меню", but2, 35);
    Menu.ButtMenu button3 = new Menu.ButtMenu(
            350, 450, 300, 68, "Выход", but2, 35);

    public void draw(Graphics2D g) {
        Font font1 = new Font("F", Font.BOLD, 70);
        g.setFont(font1);
        g.setColor(Color.BLACK);

        if ("-".equals(Player.win)) {
            g.drawString("Ничья!", 375, 120);
        } else if ("0".equals(Player.win)) {
            g.drawString("Победа черных!", 250, 120);
        } else if ("1".equals(Player.win)) {
            g.drawString("Победа белых!", 250, 120);
        }
        button1.draw(g);
        button2.draw(g);
        button3.draw(g);
    }
}