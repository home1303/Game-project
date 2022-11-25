
package com.mycompany.porjectgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;

public class Monster extends Item{
    
    private Item StandingOn = null;
    private Window w;
    private boolean Monsterleft = false;
    Image image;
    private Player player;
    
    public Monster(Window w, byte ID, double x, double y, int width, int height){
        super(ID, x, y, width, height);
        this.w=w;

    }
    @Override
    public void Render(Graphics g) {
        ImageIcon img = new ImageIcon("image/6.png");
        image = img.getImage();
        g.drawImage(image, (int)x, (int)y, width, height, w);
    }

    @Override
    public void tick() {
        if(StandingOn == null){
            y+=w.level.Garavity;
        for(Item i : w.level.item){
            if(i.ID == ObjectIDS.Platform){
                if(new Rectangle((int)x, (int)y, width, height).intersects(new Rectangle((int)i.x, (int)i.y, i.width, i.height))){
                    StandingOn = i;
                }
            }
            if(i.ID == ObjectIDS.floor2){
                if(new Rectangle((int)x, (int)y, width, height).intersects(new Rectangle((int)i.x, (int)i.y, i.width, i.height))){
                    StandingOn = i;
                }
            }
        }
        }else{
            y = StandingOn.y-height;
            if(x+width >= StandingOn.x+StandingOn.width || x <= StandingOn.x)Monsterleft = !Monsterleft;
            if(Monsterleft){
                x--;
            }else{
                x++;
            }
        }

    }
}
