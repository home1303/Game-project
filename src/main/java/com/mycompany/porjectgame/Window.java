package com.mycompany.porjectgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends Canvas implements Runnable{
    

    private static final long serialVersionUID = 1L;
    private Thread thread;
    private boolean running = false;
    public KeyBoard keylistener = new KeyBoard(this);
    public Garavity level = new Garavity(this);
    
    public GameState gs = GameState.Menu;
    
    public Menu  menu = new Menu(this);

    public Lose  lose = new Lose(this);
   
    public Try tt = new Try(this);
    
    
    public Label socre;
    public Image image;
    

    
    public Window(String title){
        JFrame frame = new JFrame(title);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(this);
        
    }
    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public void stop(){
        running = false;
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void run() {
        long lasttime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int update = 0;
        int frame = 0;
                
        while(running){
            long now = System.nanoTime();
            delta +=(now - lasttime) / ns;
            lasttime = now;
            while(delta >=1){
                tick();
                update++;
                delta--;
            }
            Render();
            frame++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frame + " TICKS: " + update);
                frame = 0;
                update = 0;
            }
        }
        stop();
    }
    
    
    public void tick(){
        
        if(gs == GameState.Game)level.tick();
        if(gs == GameState.Menu)menu.tick();
        if(gs == GameState.Lose)lose.tick();
        if(gs == GameState.Try)tt.tick();
    }


    public void Render(){  
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
        this.createBufferStrategy(2);
        bs = this.getBufferStrategy();
        }
        Graphics g = bs.getDrawGraphics();
 

        ImageIcon img = new ImageIcon("image/3.jpg");
        image = img.getImage();
        g.drawImage(image,0, 0, this.getWidth(), this.getHeight(), this);
        
        

        if(gs == GameState.Game)level.Render(g);
        if(gs == GameState.Menu)menu.Render(g);
        if(gs == GameState.Lose)lose.Render(g);
        if(gs == GameState.Try)tt.Render(g);
        
        bs.show();
        g.dispose();
    }

    void GoToGame() {
        gs = GameState.Game;
    }

    void GoToMenu() {
        gs = GameState.Menu;
    }
    void GoToLose() {
        gs = GameState.Lose;
    }
    void GoToTry() {
        gs = GameState.Try;
    }
}
