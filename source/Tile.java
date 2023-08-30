package source;

import java.awt.Graphics2D;

import config.Settings;
import main.World;

public class Tile extends CubeObject {


    private Block block;
    public Boolean empty = true;

    public int renderedX, renderedY;

    public int fixedWidth = width / Settings.horizontalShift; 
    public int fixedHeight = height / Settings.verticalShift;

    public Tile(int x, int y, int z, Block block) {
        super(x, y, z, Settings.screenHeight/Settings.scale, Settings.screenHeight/Settings.scale, Settings.screenHeight/Settings.scale);
        this.block = block;
        this.empty = false;
    }
    public Tile(int x, int y, int z) {
        super(x, y, z, Settings.screenHeight/Settings.scale, Settings.screenHeight/Settings.scale, Settings.screenHeight/Settings.scale);
    }

    public void draw(Graphics2D g2) {
        if (this.empty) return;

        int fixedX = (DimensionManager.calculateX(this, x, z));
        int fixedY = (DimensionManager.calculateY(this, x, y, z) );

        this.renderedX = fixedX - World.x;
        this.renderedY = fixedY - World.z;


        if (renderedX + width < 0 || renderedX > Settings.screenWidth || renderedY + height < 0 || renderedY > Settings.screenHeight) return;
        g2.drawImage(block.texture, this.renderedX, this.renderedY, this.width, this.height, null);
    }
}
