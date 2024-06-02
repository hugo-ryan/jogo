package objeto;

import main.JogoPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ObjetoMaior {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

    public void draw(Graphics2D g2, JogoPanel gp) {

        int screenX = worldX - gp.jogador.worldX + gp.jogador.screenX;
        int screenY = worldY - gp.jogador.worldY + gp.jogador.screenY;

        if(worldX + gp.tileSize > gp.jogador.worldX - gp.jogador.screenX &&
                worldX - gp.tileSize < gp.jogador.worldX + gp.jogador.screenX &&
                worldY + gp.tileSize > gp.jogador.worldY - gp.jogador.screenY &&
                worldY - gp.tileSize < gp.jogador.worldY + gp.jogador.screenY) {

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

        }
    }
}