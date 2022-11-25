package com.mycompany.porjectgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyBoard  implements KeyListener{
    
    private Window w;
    
    public boolean WDown = false;
    
    
    public Player player;
    public KeyBoard(Window w){
        this.w=w;
        w.addKeyListener(this);
    }
  
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(w.gs == GameState.Game){
            if(key == KeyEvent.VK_SPACE){
                w.gs = GameState.Menu;
            }
        switch (key) {
            case KeyEvent.VK_D:
                w.level.player.velx = w.level.player.speed;
                w.level.CamX +=3;
                break;
            case KeyEvent.VK_A:
                w.level.player.velx = -w.level.player.speed;
                w.level.CamX -=3;
                break;
            case KeyEvent.VK_W:
                if(w.level.player.Jumpable){
                    w.level.player.vely = -w.level.player.Jump;
                }   break;
            case KeyEvent.VK_LEFT:
                if(w.level.player.Jumpable){
                    w.level.CamX -=4;
                }   break;
            case KeyEvent.VK_RIGHT:
                if(w.level.player.Jumpable){
                    w.level.CamX +=4;
                }   break;
            default:
                break;
        }
    }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(w.gs == GameState.Game){
        switch (key) {
            case KeyEvent.VK_D:
                w.level.player.velx = 0;
                break;
            case KeyEvent.VK_A:
                w.level.player.velx = 0;
                break;
            case KeyEvent.VK_W:
                break;
            default:
                break;
        }
    
        }else if(w.gs == GameState.Menu){
            w.menu.Keypress(key);
        }
        else if(w.gs == GameState.Lose){
            w.lose.Keypress(key);
        }
        else if(w.gs == GameState.Try){
            w.tt.Keypress(key);
        }
    }
}
