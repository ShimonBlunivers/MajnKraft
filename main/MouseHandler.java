package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Point;

import javax.swing.JFrame;

public class MouseHandler extends MouseAdapter {

    public int x = 0;
    public int y = 0;

    public static boolean leftButton;
    public static boolean rightButton;

    public void update(JFrame window){
        Point mousePosition = window.getMousePosition();
        if(mousePosition != null){
            x = mousePosition.x - window.getInsets().left;
            y = mousePosition.y - window.getInsets().top;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // This method is called when the mouse is clicked
        // You can get the x and y position of the mouse click using e.getX() and e.getY()
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // This method is called when the mouse enters the component
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // This method is called when the mouse exits the component
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // This method is called when the mouse button is pressed
        if (e.getButton() == 1) leftButton = true;
        if (e.getButton() == 3) rightButton = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // This method is called when the mouse button is released
        if (e.getButton() == 1) leftButton = false;
        if (e.getButton() == 3) rightButton = false;
    }
}


