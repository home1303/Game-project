package com.mycompany.porjectgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import javax.swing.ImageIcon;

public class OBJ extends Item {
    
    public int x, y, width, height;
    public Color c;
    public Image image;
    public Window w;
    public OBJ(byte ID,int x, int y, int width, int height, Color c){
        super(ID, x, y, width, height);
        this.c = c;
        this.x =x;
        this.y= y;
        this.width = width;
     this.height = height;    
    }
    
    public void Render(Graphics g){
        
        if(ID == 2){
        ImageIcon img = new ImageIcon("image/4.png");
        image = img.getImage();
        g.drawImage(image, (int)x, (int)y, width, height, w);
        }
        else{
        ImageIcon img = new ImageIcon("image/8.png");
        image = img.getImage();
        g.drawImage(image, (int)x, (int)y, width, height, w);            
        }
    }

    
    public void tick() {
  
    }
}
