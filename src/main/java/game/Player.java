package game;

import javax.swing.*;
import java.awt.*;

public class Player {
    private double x;
    private double y;
    private double w;
    private double h;

    public String[][] list = new String[15][15];

    private Image imgBlack = new ImageIcon("C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\player_black38.png").getImage();
    private Image imgWhite = new ImageIcon("C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\player_white38.png").getImage();

    public boolean turn = true;
    public static boolean click = false;
    public int count = 0;

    public int countPass = 0;
    public static String win;

    public Player() {
        x = 245;
        y = 28;
        h = 33.5;
        w = 33.5;

        list[7][7] = "0";
    }

    public void newGame() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                list[i][j] = "";
            }
        }
        list[7][7] = "0";
        count = 1;
        countPass = 0;
    }

    public String getWin() {

        int countWinBlack = 0;
        int countWinWhite = 0;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (list[i][j] =="0") {
                    if (i < 11) {
                        countWinBlack = 1;
                        for (int k = 1; k < 5; k++) {
                            if (list[i + k][j] == "0") {
                                countWinBlack++;
                            }
                        }
                    }
                    if (countWinBlack != 5 && j < 11) {
                        countWinBlack = 1;
                        for (int k = 1; k < 5; k++) {
                            if (list[i][j + k] == "0") {
                                countWinBlack++;
                            }
                        }
                    }
                    if (countWinBlack != 5 && i < 11 && j < 11) {
                        countWinBlack = 1;
                        for (int k = 1; k < 5; k++) {
                            if (list[i + k][j + k] == "0") {
                                countWinBlack++;
                            }
                        }
                    }
                    if (countWinBlack != 5 && i < 11 && j > 3) {
                        countWinBlack = 1;
                        for (int k = 1; k < 5; k++) {
                            if (list[i + k][j - k] == "0") {
                                countWinBlack++;
                            }
                        }
                    }
                    if (countWinBlack == 5) return "0";
                }
                if (list[i][j] =="1") {
                    if (i < 11) {
                        countWinWhite = 1;
                        for (int k = 1; k < 5; k++) {
                            if (list[i + k][j] == "1") {
                                countWinWhite++;
                            }
                        }
                    }
                    if (countWinWhite != 5 && j < 11) {
                        countWinWhite = 1;
                        for (int k = 1; k < 5; k++) {
                            if (list[i][j + k] == "1") {
                                countWinWhite++;
                            }
                        }
                    }
                    if (countWinWhite != 5 && i < 11 && j < 11) {
                        countWinWhite = 1;
                        for (int k = 1; k < 5; k++) {
                            if (list[i + k][j + k] == "1") {
                                countWinWhite++;
                            }
                        }
                    }
                    if (countWinWhite != 5 && i < 11 && j > 3) {
                        countWinWhite = 1;
                        for (int k = 1; k < 5; k++) {
                            if (list[i + k][j - k] == "1") {
                                countWinWhite++;
                            }
                        }
                    }
                    if (countWinWhite == 5) return "1";
                }
            }
        }

        if (!oppToPut5()) return "-";
        return "";
    }

    public boolean oppToPut5() {
        int count = 0;
        String color;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                color = list[i][j];
                if (i < 11) {
                    count = 1;
                    for (int k = 1; k < 5; k++) {
                        if (list[i + k][j] == color || list[i + k][j] == "") {
                            count++;
                        }
                    }
                }
                if (count != 5 && j < 11) {
                    count = 1;
                    for (int k = 1; k < 5; k++) {
                        if (list[i][j + k] == color || list[i][j + k] == "") {
                                count++;
                        }
                    }
                }
                if (count != 5 && i < 11 && j < 11) {
                    count = 1;
                    for (int k = 1; k < 5; k++) {
                        if (list[i + k][j + k] == color || list[i + k][j + k] == "") {
                            count++;
                        }
                    }
                }
                if (count != 5 && i < 11 && j > 3) {
                    count = 1;
                    for (int k = 1; k < 5; k++) {
                        if (list[i + k][j - k] == color || list[i + k][j - k] == "") {
                            count++;
                        }
                    }
                }
                if (count == 5) return true;
            }
        }
        return false;
    }

    public double getW() { return w; }
    public double getH() { return h; }

    public void draw(Graphics2D g) {
        Font font = new Font("Arial", Font.BOLD, 40);
        g.setFont(font);

        if (turn) {
            g.setColor(Color.BLACK);
            g.drawString("Ходят", 40, 500);
            if (count >= 6) g.drawImage(new ImageIcon("C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\but_pas.png").getImage(), 20, 300, null);
        } else {
            g.setColor(Color.WHITE);
            g.drawString("Ходят", 800, 500);
            if (count >= 6) g.drawImage(new ImageIcon("C:\\Users\\User\\IdeaProjects\\Renju\\src\\main\\resources\\files\\but_pas.png").getImage(), 800, 300, null);
        }

        for (int i = 0; i < 15; i ++) {
            for (int j = 0; j < 15; j ++) {
                if (list[i][j].equals("0")) {
                    g.drawImage(imgBlack, (int) (x + w * i), (int) (y + h * j), null);
                } else if (list[i][j].equals("1")) {
                    g.drawImage(imgWhite, (int) (x + w * i), (int) (y + h * j), null);
                }
            }
        }
    }
}
