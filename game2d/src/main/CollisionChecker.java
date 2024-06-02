package main;

import Entity.Entity;
import bloco.TileManager;

public class CollisionChecker {
    JogoPanel gp;
    public CollisionChecker(JogoPanel gp){
        this.gp = gp;

    }

    public void checkTile(Entity entity){
        int collisionMaskLeft = entity.worldX + entity.collisionMask.x; //Esquerda da máscara
        int collisionMaskRight = entity.worldX + entity.collisionMask.x + entity.collisionMask.width; //Direita da máscara
        int collisionMaskTop = entity.worldY + entity.collisionMask.y; //Topo da máscara
        int collisionMaskBottom = entity.worldY + entity.collisionMask.y + entity.collisionMask.height; //Fundo da máscara

        int leftCollision = collisionMaskLeft/gp.tileSize;
        int rightCollision = collisionMaskRight/gp.tileSize;
        int topCollision = collisionMaskTop/gp.tileSize;
        int bottomCollision = collisionMaskBottom/gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction){
            case "up":
                topCollision = (collisionMaskTop - entity.speed)/gp.tileSize;
                tileNum1 = TileManager.mapTileNum[leftCollision][topCollision];
                tileNum2 = TileManager.mapTileNum[rightCollision][topCollision];
                if(TileManager.tile[tileNum1].collision || TileManager.tile[tileNum2].collision){
                    entity.isColliding = true;
                }
                break;
            case "down":
                bottomCollision = (collisionMaskBottom + entity.speed)/ gp.tileSize;
                tileNum1 = TileManager.mapTileNum[leftCollision][bottomCollision];
                tileNum2 = TileManager.mapTileNum[rightCollision][bottomCollision];
                if(TileManager.tile[tileNum1].collision || TileManager.tile[tileNum2].collision){
                    entity.isColliding = true;
                }
                break;
            case "left":
                leftCollision = (collisionMaskLeft - entity.speed)/ gp.tileSize;
                tileNum1 = TileManager.mapTileNum[leftCollision][topCollision];
                tileNum2 = TileManager.mapTileNum[leftCollision][bottomCollision];
                if(TileManager.tile[tileNum1].collision || TileManager.tile[tileNum2].collision){
                    entity.isColliding = true;
                }
                break;
            case "right":
                rightCollision = (collisionMaskRight + entity.speed)/ gp.tileSize;
                tileNum1 = TileManager.mapTileNum[rightCollision][topCollision];
                tileNum2 = TileManager.mapTileNum[rightCollision][bottomCollision];
                if(TileManager.tile[tileNum1].collision || TileManager.tile[tileNum2].collision){
                    entity.isColliding = true;
                }
                break;
        }
    }
}