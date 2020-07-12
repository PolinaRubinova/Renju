import game.Player;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {
    Player player = new Player();

    @Test
    public void winBlack() {
        for (int j = 0; j < 5; j++) {
            player.list[0][j] = "0";
            player.list[1][j] = "1";
        }
        Assert.assertEquals("0", player.getWin());
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                player.list[i][j] = "";
            }
        }
        for (int i = 0; i < 5; i++) {
            player.list[i][0] = "0";
            player.list[i][1] = "1";
        }
        Assert.assertEquals("0", player.getWin());
        for (int i = 0; i < 5; i++) {
                player.list[i][i] = "0";
                player.list[i + 1][i] = "1";
        }
        Assert.assertEquals("0", player.getWin());
    }

    @Test
    public void winWhite() {
        for (int j = 0; j < 5; j++) {
            player.list[0][j] = "1";
            player.list[1][j] = "0";
        }
        Assert.assertEquals("1", player.getWin());
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                player.list[i][j] = "";
            }
        }
        for (int i = 0; i < 5; i++) {
            player.list[i][0] = "1";
            player.list[i][1] = "0";
        }
        Assert.assertEquals("1", player.getWin());
        for (int i = 0; i < 5; i++) {
            player.list[i][i] = "1";
            player.list[i + 1][i] = "0";
        }
        Assert.assertEquals("1", player.getWin());
    }

    @Test
    public void winFriendship() {
        String x;
        String y;
        boolean t = false;
        for (int i = 0; i < 14; i++) {

            x = t ? "0" : "1";
            y = t ? "1" : "0";

            for (int j = 0; j < 2; j ++) {
                player.list[i + j][0] = x;
                player.list[i + j][1] = x;
                player.list[i + j][2] = y;
                player.list[i + j][3] = y;
                player.list[i + j][4] = x;
                player.list[i + j][5] = x;
                player.list[i + j][6] = y;
                player.list[i + j][7] = y;
                player.list[i + j][8] = x;
                player.list[i + j][9] = x;
                player.list[i + j][10] = y;
                player.list[i + j][11] = y;
                player.list[i + j][12] = x;
                player.list[i + j][13] = x;
                player.list[i + j][14] = y;
            }
            t = !t;
        }
        player.count = 225;
        Assert.assertEquals("-", player.getWin());
    }

    @Test
    public void cantPut5() {
        String x;
        String y;
        boolean t = false;
        for (int i = 0; i < 14; i++) {
            x = t ? "0" : "1";
            y = t ? "1" : "0";

            for (int j = 0; j < 2; j ++) {
                player.list[i + j][0] = x;
                player.list[i + j][1] = x;
                player.list[i + j][2] = y;
                player.list[i + j][3] = y;
                player.list[i + j][4] = x;
                player.list[i + j][5] = x;
                player.list[i + j][6] = y;
                player.list[i + j][7] = y;
                player.list[i + j][8] = x;
                player.list[i + j][9] = x;
                player.list[i + j][10] = y;
                player.list[i + j][11] = y;
                player.list[i + j][12] = x;
                player.list[i + j][13] = x;
            }
            t = !t;
        }
        player.list[0][14] = "0";
        player.list[1][14] = "0";
        player.list[2][14] = "1";
        player.list[3][14] = "1";
        player.list[4][14] = "0";
        player.list[5][14] = "0";
        player.list[6][14] = "1";
        player.list[7][14] = "1";
        player.list[8][14] = "0";
        player.list[9][14] = "0";
        player.list[10][14] = "1";
        player.list[11][14] = "0";
        Assert.assertFalse(player.oppToPut5());
    }
}
