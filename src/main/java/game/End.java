package game;

import java.awt.*;

public class End {

    public static boolean click = false;
    Menu.ButtMenu button1 = new Menu.ButtMenu(350, 250, 300, 68, "Новая игра", "C:\\Users\\User\\IdeaProjects\\_1\\src\\main\\resources\\files\\but2.png", 35);
    Menu.ButtMenu button2 = new Menu.ButtMenu(350, 350, 300, 68, "Меню", "C:\\Users\\User\\IdeaProjects\\_1\\src\\main\\resources\\files\\but2.png", 35);
    Menu.ButtMenu button3 = new Menu.ButtMenu(350, 450, 300, 68, "Выход", "C:\\Users\\User\\IdeaProjects\\_1\\src\\main\\resources\\files\\but2.png", 35);

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