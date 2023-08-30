package source;

import java.util.ArrayList;

public class BlockManager {
        // BLOCKS INIT

        public static ArrayList<Block> blockList = new ArrayList<>();

        public static Block GrassBlock = new Block("grass");
        public static Block DirtBlock = new Block("dirt");
        public static Block BottomsoilBlock = new Block("bottomsoil");
        public static Block StoneBlock = new Block("stone");    
        public static Block GlassBlock = new Block("glass").setTransparent(true);
        public static Block DiamondBlockBlock = new Block("diamond-block");
    


}
