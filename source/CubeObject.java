package source;

import java.awt.Color;

public abstract class CubeObject {
    protected int x, y, z, width, height, length;
    protected Color color, outlineColor;
    
    public CubeObject(int x, int y, int z, int width, int height, int length) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public int left(){
        return x;
    }

    public int right(){
        return x + width;
    }

    public int top(){
        return y;
    }

    public int bottom(){
        return y + height;
    }

    public int front(){
        return z;
    }

    public int back(){
        return z + length;
    }

    public int X(){
        return x;
    }

    public int Y(){
        return y;
    }

    public int Z(){
        return z;
    }

    public void setX(int x){
        this.x = x;
    }    
    
    public void setY(int y){
        this.y = y;
    }

    public void setZ(int z){
        this.z = z;
    }

    public void setSize(int width, int height, int length){
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setLength(int length){
        this.length = length;
    }

}
