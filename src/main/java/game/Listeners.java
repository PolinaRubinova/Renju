package game;

import java.awt.event.*;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) {
            if (Panel.state == Panel.STATES.PLAY || Panel.state == Panel.STATES.INFO) {
                Panel.state = Panel.STATES.MENU;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.MENU) {
                Menu.click = true;
            }
        }
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.PLAY) {
                Player.click = true;
            }
        }
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.END) {
                End.click = true;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {

            if (Panel.state == Panel.STATES.MENU) {
                Menu.click = false;
            }
        }
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {

            if (Panel.state == Panel.STATES.PLAY) {
                Player.click = false;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Panel.mouseX = mouseEvent.getX();
        Panel.mouseY = mouseEvent.getY();
    }
}
