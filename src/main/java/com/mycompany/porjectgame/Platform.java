package com.mycompany.porjectgame;

import java.awt.Color;
import java.awt.Graphics;




public class Platform extends Item {
    
    public Color c;
    
    public Platform(byte ID,int x, int y, int width, int height, Color c){
        super(ID, x, y, width, height);
        this.c = c; 
    }

    public void Render(Graphics g){
        g.setColor(c);
        g.fillRect((int)x, (int)y, width, height);
    }
    public void tick(){
        
    }

}
