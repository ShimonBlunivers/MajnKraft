
package main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import config.Settings;

import java.awt.Graphics;
import java.awt.Graphics2D;


public class GamePanel extends JPanel implements Runnable {

    public JFrame window;

    public static double deltaTime = 0;

    KeyHandler keys = new KeyHandler();
    MouseHandler mouse = new MouseHandler();

    Thread gameThread;

    public static World world = new World();



    public GamePanel(JFrame window){
        

        this.window = window;
        this.setPreferredSize(new Dimension(Settings.screenWidth, Settings.screenHeight));
        this.setBackground(Settings.backgroundColor);
        this.setDoubleBuffered(true);
        this.addKeyListener(keys);
        this.addMouseListener(mouse);
        this.setFocusable(true);
    }

    public void startGameThread(){
        
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double desiredFPS = Settings.FPS;
        long frameTimeNanos = (long) (1_000_000_000 / desiredFPS);
    
        long nextFrameTime = System.nanoTime();

        while (gameThread != null) {
            update();
            repaint();
    
            // Calculate remaining time until the next frame
            long currentTime = System.nanoTime();
            long remainingTime = nextFrameTime - currentTime;
    
            if (remainingTime > 0) {
                try {
                    // Sleep for the remaining time to achieve the desired FPS
                    Thread.sleep(remainingTime / 1_000_000, (int) (remainingTime % 1_000_000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    
            // Calculate and display the FPS
            long currentFrameTime = System.nanoTime() - nextFrameTime;
            nextFrameTime += frameTimeNanos;
            deltaTime = (currentFrameTime + frameTimeNanos) / 1_000_000;
            
            // int currentFPS = (int) (1_000_000_000.0 / (currentFrameTime + frameTimeNanos)) + 1;
        }
    }

    public void update(){
        mouse.update(window);
        moveCamera();

        // TESTING

        // int relativeMouseX = mouse.x + World.x;
        // int relativeMouseY = mouse.y + World.y;

        
        // System.out.println(testRect.intersects(relativeMouseX, relativeMouseY));
        // System.out.println(testOval.intersects(relativeMouseX, relativeMouseY));
        

        if (MouseHandler.rightButton) {
        }


    }

    private void moveCamera(){

        double cameraSpeed = 1;

        if (KeyHandler.UP) World.z -= cameraSpeed * deltaTime;
        if (KeyHandler.DOWN) World.z += cameraSpeed * deltaTime;
        if (KeyHandler.LEFT) World.x -= cameraSpeed * deltaTime;
        if (KeyHandler.RIGHT) World.x += cameraSpeed * deltaTime;
        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        world.render(g2);

        // Reset g2
        
        // g2.setStroke(new BasicStroke(1));
        // g2.setColor(Color.BLACK);
        // g2.drawRect(mouse.x, mouse.y, 10, 10); // Showing where the mouse is.

        // g2.drawLine(Settings.screenWidth/2, 0, Settings.screenWidth/2, Settings.screenHeight);
        // g2.drawLine(0, Settings.screenHeight/2, Settings.screenWidth, Settings.screenHeight/2);

        g2.dispose();
    }
}
