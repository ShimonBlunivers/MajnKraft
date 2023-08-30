package source;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block {
    
    public BufferedImage texture;
    public String name;
    public int index;
    public boolean transparent = false;

    public Block(String name) {
        this.name = name;
        try {
                this.texture = ImageIO.read(getClass().getResourceAsStream("/files/blocks/" + name + "/texture.png"));
            } catch(IOException e){ e.printStackTrace(); }
        this.index = BlockManager.blockList.size();
        BlockManager.blockList.add(this);
    }

    public Block setTransparent(boolean t){
        this.transparent = t;
        return this;
    }

    
}
