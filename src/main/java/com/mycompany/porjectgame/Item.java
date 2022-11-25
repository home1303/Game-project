package com.mycompany.porjectgame;

import java.awt.Graphics;

public abstract class Item {
     
    protected byte ID;
    protected double x,y;
    protected int width,height;
    
            
    public Item(byte ID, double x, double y, int width, int height){
        this.ID = ID;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    
    protected abstract void Render(Graphics g);
    
    public abstract void tick();
}
