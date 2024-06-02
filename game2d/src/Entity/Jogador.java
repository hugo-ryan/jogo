package Entity;

import main.JogoPanel;
import main.Movimentar;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.abs;

public class Jogador extends Entity {

    JogoPanel gp;
    Movimentar keyH;

    public int screenX;
    public int screenY;


    public Jogador (JogoPanel gp, Movimentar keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2  - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2  - (gp.tileSize / 2);

        collisionMask = new Rectangle(8, 16, 32, 32);

        setDefaultValues();
        getJogadorImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }
    public void getJogadorImage() {
        try {
            //mostrando mudança
            up1 = ImageIO.read(new File("game2d/res/jogador/boy_up_1.png"));
            up2 = ImageIO.read(new File("game2d/res/jogador/boy_up_2.png"));
            down1 = ImageIO.read(new File("game2d/res/jogador/boy_down_1.png"));
            down2 = ImageIO.read(new File("game2d/res/jogador/boy_down_2.png"));
            left1 = ImageIO.read(new File("game2d/res/jogador/boy_left_1.png"));
            left2 = ImageIO.read(new File("game2d/res/jogador/boy_left_2.png"));
            right1 = ImageIO.read(new File("game2d/res/jogador/boy_right_1.png"));
            right2 = ImageIO.read(new File("game2d/res/jogador/boy_right_2.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){ //Fazer ele parar a animação se não estiver se mexendo.
            //Troca as direções
            if(keyH.upPressed) {
                direction = "up";
            }
            else if(keyH.downPressed) {
                direction = "down";

            }
            else if(keyH.leftPressed) {
                direction = "left";

            }
            else {
                direction = "right";

            }
            //Checando colisão
            isColliding = false;
            gp.cChecker.checkTile(this);

            if(!isColliding){
                switch (direction){
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 10) {
                if(spritNum ==1) {
                    spritNum = 2;
                }
                else if(spritNum == 2) {
                    spritNum = 1;
                }
                spriteCounter = 0;
            }
        }



    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spritNum == 1) {
                    image = up1;
                }
                if(spritNum == 2) {
                    image = up2;
                }
                break;

            case "down":
                if(spritNum == 1) {
                    image = down1;
                }
                if(spritNum == 2) {
                    image = down2;
                }
                break;

            case "left":
                if(spritNum == 1) {
                    image = left1;
                }
                if(spritNum == 2) {
                    image = left2;
                }
                break;

            case "right":
                if(spritNum == 1) {
                    image = right1;
                }
                if(spritNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

        //Ver a máscara de colisão (Se quiser tirar só comentar essas duas linhas)
        //g2.setColor(Color.red);
        //g2.drawRect(screenX + collisionMask.x, screenY + collisionMask.y, collisionMask.width, collisionMask.height);
    }
}
