package main;

import java.awt.Graphics2D;
// import java.util.Random;

import config.WorldGen;
import source.BlockManager;
import source.Tile;

public class World {


    public static int       x,          y,          z;
    public        int       width,      height,     length;

    public Tile data[] = {};

    public World() {
        generate();
    }

    public void generate() {
        this.width = WorldGen.worldWidth;
        this.height = WorldGen.heightLimit;
        this.length = WorldGen.worldLength;
        
        this.data = new Tile[width * height * length];

        World.x = width / 2;
        World.y = height / 2;
        World.z = length / 2;

        // Random rand = new Random();

        for (int i = 0; i < width * height * length ; i++) {

            int x = (height - 1) - i % width;
            int y = Math.floorDiv(i, width) % height;
            int z = Math.floorDiv(i, width * height);

            Tile newTile;
            if (y == 0) newTile = new Tile(x, y, z, BlockManager.BottomsoilBlock);
            else if (y > WorldGen.stopGeneratingGroundAt) newTile = new Tile(x, y, z); 

            else {
                switch((int)(y/4)){
                    case 0:
                        newTile = new Tile(x, y, z, BlockManager.GrassBlock);
                        break;
                    case 1:
                        newTile = new Tile(x, y, z, BlockManager.StoneBlock);
                        break;
                    case 2:
                        newTile = new Tile(x, y, z, BlockManager.DirtBlock);
                        break;
                    case 3:
                        newTile = new Tile(x, y, z, BlockManager.DiamondBlockBlock);
                        break;
                    case 4:
                        newTile = new Tile(x, y, z);
                        break;
                    default:
                        newTile = new Tile(x, y, z, BlockManager.GlassBlock);
                }
            }

            data[i] = newTile;
        }

    }

    public void render(Graphics2D g2) {
        for (Tile tile : data) try { tile.draw(g2); } catch(NullPointerException e) {}
    }
}