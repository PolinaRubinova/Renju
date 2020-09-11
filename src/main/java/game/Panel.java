package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements ActionListener {

    public static int WIDTH = 1000;
    public static int HEIGHT = 600;

    public static int mouseX;
    public static int mouseY;

    public static enum STATES{MENU, PLAY, INFO, END}
    public static STATES state = STATES.MENU;

    private BufferedImage image;
    private Graphics2D g;


    Timer mainTimer = new Timer(30, this);

    Back back = new Back();
    Player player = new Player();
    Menu menu = new Menu();
    End end = new End();

    public Panel() {
        super();
        setFocusable(true);
        requestFocus();
        image= new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        addMouseListener(new Listeners());
        addKeyListener(new Listeners());
        addMouseMotionListener(new Listeners());
    }

    public void actionPerformed(ActionEvent e) {
        if (state.equals(STATES.MENU)) {
            back.draw(g);
            menu.draw(g);

            if (mouseX > menu.button1.getX() && mouseX < menu.button1.getX() + menu.button1.getW() &&
                    mouseY > menu.button1.getY() && mouseY < menu.button1.getY() + menu.button1.getH()) {
            menu.button1.pic = menu.but1ch;
                if (Menu.click) {
                    player.newGame();
                    state = STATES.PLAY;
                    Menu.click = false;
                }
            } else {
                menu.button1.pic = menu.but1;
            }

            if (mouseX > menu.button2.getX() && mouseX < menu.button2.getX() + menu.button2.getW() &&
                    mouseY > menu.button2.getY() && mouseY < menu.button2.getY() + menu.button2.getH()) {
                menu.button2.pic = menu.but1ch;
                if (Menu.click) {
                    state = STATES.INFO;
                    Menu.click = false;
                }
            } else {
                menu.button2.pic = menu.but1;
            }

            if (mouseX > menu.button3.getX() && mouseX < menu.button3.getX() + menu.button3.getW() &&
                    mouseY > menu.button3.getY() && mouseY < menu.button3.getY() + menu.button3.getH()) {
                menu.button3.pic = menu.but1ch;
                if (Menu.click) {
                    System.exit(0);
                }
            } else {
                menu.button3.pic = menu.but1;
            }
                gameDraw();
        }

        if (state.equals(STATES.PLAY)) {
            back.draw(g);
            player.draw(g);

            Image img = new ImageIcon(player.playerCh).getImage();

            //Ход игрока и провера на "победу"
            if (mouseX > 245 && mouseX < 747.5 && mouseY > 28 && mouseY < 530.5) {
                int x = 0;
                int y = 0;

                while (mouseX - 245 - player.getW() * x > player.getW()) x++;
                while (mouseY - 28 - player.getH() * y > player.getH()) y++;

                if (player.list[x][y].equals("")) {
                    g.drawImage(img, (int) (245 + player.getW() * x), (int) (28 + player.getH() * y), null);
                    if (Player.click) {
                        player.list[x][y] = player.turn ? "1": "0";
                        player.turn = !player.turn;
                        player.count++;
                        if (player.count >= 9 && !player.getWin().equals("")) {
                            state = STATES.END;
                            Player.win = player.getWin();
                        }
                        player.countPass = 0;
                        Player.click = false;
                    }
                }
            }

            //Кнопка "Пас". Если игроки нажмут друг за другом, то игра закончится "Ничьей"
            if (player.count >= 6 &&
                    ((player.turn && mouseX > 20 && mouseX < 170 && mouseY > 300 && mouseY < 360) ||
                    (!player.turn && mouseX > 800 && mouseX < 950 && mouseY > 300 && mouseY < 360))
                    ) {
                if (player.turn) {
                    g.drawImage(new ImageIcon(player.butPas1).getImage(), 20, 300, null);
                } else g.drawImage(new ImageIcon(player.butPas1).getImage(), 800, 300, null);
                if (Player.click) {
                    player.turn = !player.turn;
                    player.count++;
                    player.countPass++;
                    if (player.countPass == 2) {
                        state = STATES.END;
                        Player.win = "-";
                    }
                }
                Player.click = false;
            }

            gameDraw();
        }

        if (state.equals(STATES.INFO)) {
            back.draw(g);
            gameDraw();
        }

        if (state.equals(STATES.END)) {
            back.draw(g);
            end.draw(g);

            if (mouseX > end.button1.getX() && mouseX < end.button1.getX() + end.button1.getW() &&
                    mouseY > end.button1.getY() && mouseY < end.button1.getY() + end.button1.getH()) {
                end.button1.pic = end.but2ch;
                if (End.click) {
                    player.newGame();
                    state = STATES.PLAY;
                    End.click = false;
                }
            } else end.button1.pic = end.but2;

            if (mouseX > end.button2.getX() && mouseX < end.button2.getX() + end.button2.getW() &&
                    mouseY > end.button2.getY() && mouseY < end.button2.getY() + end.button2.getH()) {
                end.button2.pic = end.but2ch;
                if (End.click) {
                    state = STATES.MENU;
                    End.click = false;
                }
            } else end.button2.pic = end.but2;

            if (mouseX > end.button3.getX() && mouseX < end.button3.getX() + end.button3.getW() &&
                    mouseY > end.button3.getY() && mouseY < end.button3.getY() + end.button3.getH()) {
                end.button3.pic = end.but2ch;
                if (End.click) {
                    System.exit(0);
                }
            } else end.button3.pic = end.but2;

            gameDraw();
        }
    }

    public void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image,0,0,null);
        g2.dispose();
    }
}