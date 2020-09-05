package game;

import javax.swing.*;
import java.awt.*;

public class Menu {

    public static boolean click = false;

    ButtMenu button1 = new ButtMenu(10, 150, 330, 100, "Новая игра", "C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\but1.png", 45);
    ButtMenu button2 = new ButtMenu(10, 280, 330, 100, "Информация", "C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\but1.png", 45);
    ButtMenu button3 = new ButtMenu(10, 410, 330, 100, "Выход", "C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\but1.png", 45);

    public void draw(Graphics2D g) {
        Font font = new Font("idk", Font.ITALIC, 80);
        g.setFont(font);

        long length = (int) g.getFontMetrics().getStringBounds("Рэндзю", g).getWidth();
        g.drawString("Рэндзю", 170 - (int) (length / 2), 85);

        button1.draw(g);
        button2.draw(g);
        button3.draw(g);
    }

    static class ButtMenu {
        private double x;
        private double y;
        private double w;
        private double h;

        private int size;

        public Color color1;

        public String but;
        public String pic;

        public ButtMenu(int x, int y, int w, int h, String but, String pic, int size) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.but = but;
            this.pic = pic;
            this.size = size;
            color1 = Color.BLACK;
        }

        public double getX() {
            return this.x;
        }
        public double getY() {
            return this.y;
        }
        public double getW() {
            return this.w;
        }
        public double getH() {
            return this.h;
        }

        public void draw(Graphics2D g) {
            g.drawImage(new ImageIcon(pic).getImage(), (int)x, (int)y, null);
            g.setColor(color1);
            Font font = new Font("idk", Font.ITALIC, size);
            g.setFont(font);

            long length = (int) g.getFontMetrics().getStringBounds(but, g).getWidth();
            g.drawString(but, (int)(x + w / 2) - (int) (length / 2), (int) y + (int) (h / 2 + 10));
        }
    }
}