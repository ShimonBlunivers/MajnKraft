package text;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class Text {

    private int x, y;
    private Font font;
    private Color color = Color.BLACK;
    private String text = "";

    public Text(int x, int y){
        this.x = x;
        this.y = y;
        font = new Font("Arial", Font.PLAIN, 24);

    }

    public void draw(Graphics2D g2) {
        g2.setFont(font);
        g2.setColor(color);
        g2.drawString(text, x, y);
    }

    public Text setText(String text){
        this.text = text;
        return this;
    }

    public Text setColor(Color color){
        this.color = color;
        return this;
    }
}
