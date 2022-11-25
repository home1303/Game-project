package com.mycompany.porjectgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Menu {
    
    public Garavity level;
    private Window w;
    
    private int SelectorX =0,SelectorY=0;
    private byte Selector = 0;
    private int SelectLeftBuff = 16;
    public Menu(Window w){
        this.w=w;
    }
    public void Render(Graphics g){
       
        
        g.setColor(Color.white);
        String Title = "Treasure Adventure", StG = "Start game", Op = "Option", Exit = "Exit";    
        g.setFont(new Font("Times new Roman", Font.BOLD, 44));
        FontMetrics fontM = g.getFontMetrics(g.getFont());
        g.drawString(Title, 250, 155);
        
        g.setFont(new Font("Times new Roman", Font.BOLD, 24));
        g.drawString(StG, 350, 255);
        if(Selector ==0)SelectorX = 350-64-SelectLeftBuff ;
        if(Selector ==0)SelectorY = 255-32 ;
        
        g.drawString(Op, 350, 355);
        if(Selector ==1)SelectorX = 350-64-SelectLeftBuff ;
        if(Selector ==1)SelectorY = 355-32 ;
        
        g.drawString(Exit, 350, 455);
        if(Selector ==2)SelectorX = 350-64-SelectLeftBuff ;
        if(Selector ==2)SelectorY = 455-32 ;        
        
        g.setColor(Color.red);
        if(SelectorX != 0)g.fillRect(SelectorX, SelectorY, 50, 50);
        
    }

    void tick() {
        
    }

    void Keypress(int key) {
        if(key == KeyEvent.VK_S && Selector < 3)Selector+=1;
        if(key == KeyEvent.VK_W && Selector > 0)Selector-=1;
        if(key == KeyEvent.VK_ENTER && Selector == 0){
            w.GoToGame();
        }
        if(key == KeyEvent.VK_ENTER && Selector == 1){
            
        }
        if(key == KeyEvent.VK_ENTER && Selector == 2){
            System.exit(0);
        }
    }
}
