package com.mycompany.porjectgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Player{
    
    public Image image;
    
    public Window w;
    public int Width, Height;
    public double x, y;
    public double velx, vely;
    
    public int id;
    
    public double Jump = 4;
    
    public int speed = 2;
    
    public boolean Falling = false;
    public boolean Jumpable = false;
    

    public Player(Window w, int x, int y, int Width, int Height){
        this.w = w;
        this.x = x;
        this.y = y;
        this.Width = Width;
        this.Height = Height;
    }
    
    public void tick(){
        x+=velx;
        y+=vely;
        
        if(vely < w.level.Garavity && Falling){
            vely += 0.1;
        }else if(!Falling && vely >0){
            vely = 0;
        }
/*        if(y+vely < 300){
        }
        else{
            vely = 0;
        }*/
        Collisions();
    }
    public void Collisions(){
        Falling = true;
        Jumpable = false;
        for(Item i : w.level.item){
            if(i.ID == ObjectIDS.Platform){
                Platform p = (Platform)i;
                
                if(new Rectangle((int)x+(int)velx,(int)y+(int)vely,Width,Height).intersects(p.x,p.y,p.width,p.height)){                    
                    if(y + Height <= p.y+1){
                        Falling = false;
                        if(vely >0){
                        vely = 0;
                        y= p.y-Height+1;
                        }
                    }else if(y < p.y){
                        velx = 0;
                    }
                    if(vely < 0){
                        Falling = true;
                        y -= (vely+1);
                        vely = -1*vely;
                    }
                     
                }
                
                float CollisionTDT = 3;
                if(!Falling || (Math.abs(y+Height-p.y) < 20 && new Rectangle((int)(x+velx*CollisionTDT),(int)(y+vely*CollisionTDT),Width,Height).intersects(p.x,p.y,p.width,p.height))){
                     Jumpable = true;
                }           
            }
            
            if(i.ID == ObjectIDS.Stair){
                Platform p = (Platform)i;
                
                if(new Rectangle((int)x+(int)velx,(int)y+(int)vely,Width,Height).intersects(p.x,p.y,p.width,p.height)){                    
                    if(y + Height <= p.y+1){
                        Falling = false;
                        if(vely >0){
                        vely = 0;
                        y= p.y-Height+1;
                        }
                    }else if(y < p.y){
                        velx = 0;
                    }
                    if(vely < 0){
                        Falling = false;
                        y -= (vely+1);
                        vely = +1*vely;
                    }
                     
                }
            }
            if(i.ID == ObjectIDS.floor2){
                Platform p = (Platform)i;
                
                if(new Rectangle((int)x+(int)velx,(int)y+(int)vely,Width,Height).intersects(p.x,p.y,p.width,p.height)){                    
                    if(y + Height <= p.y+1){
                        Falling = false;
                        if(vely >0){
                        vely = 0;
                        y= p.y-Height+1;
                        }
                    }else if(y < p.y){
                        velx = 0;
                    }
                    if(vely < 0){
                        Falling = true;
                        y += (vely+1);
                        vely = +1*vely;
                    }
                     
                }
            }
            if(i.ID == ObjectIDS.OBJ){
                OBJ obj = (OBJ)i;
                 if(new Rectangle(obj.x,obj.y,obj.width,obj.height).intersects(new Rectangle((int)x, (int)y,Width,Height))){
                     w.level.Reso();
                     
                 }
            }
            if(i.ID == ObjectIDS.Monster1){
                 if(new Rectangle((int)i.x,(int)i.y,i.width,i.height).intersects(new Rectangle((int)x, (int)y,Width, Height))){
                     System.out.println(i.ID);
                     id=i.ID;
                     w.level.reso();
 
                    
                 }
            }
            else if(i.ID == ObjectIDS.Monster2){
                 if(new Rectangle((int)i.x,(int)i.y,i.width,i.height).intersects(new Rectangle((int)x, (int)y,Width,Height))){
                   System.out.println(i.ID);
                     id=i.ID;
                     w.level.reso1();
                     
                 }
            }
            else if(i.ID == ObjectIDS.Monster3){
                 if(new Rectangle((int)i.x,(int)i.y,i.width,i.height).intersects(new Rectangle((int)x, (int)y,Width,Height))){
                     System.out.println(i.ID);
                     id=i.ID;
                     w.level.reso2();
                 }
            }
            else if(i.ID == ObjectIDS.Monster4){
                 if(new Rectangle((int)i.x,(int)i.y,i.width,i.height).intersects(new Rectangle((int)x, (int)y,Width,Height))){
                     id=i.ID;
                     w.level.reso3(); 
                 }
            }
            else if(i.ID == ObjectIDS.Monster5){
                 if(new Rectangle((int)i.x,(int)i.y,i.width,i.height).intersects(new Rectangle((int)x, (int)y,Width,Height))){
                     id=i.ID;
                     w.level.reso4();
                 }
            }
            if(i.ID == ObjectIDS.fruit){
                OBJ obj = (OBJ)i;
                 if(new Rectangle(obj.x,obj.y,obj.width,obj.height).intersects(new Rectangle((int)x, (int)y,Width,Height))){
                     w.level.Reso4(); 
                 }
            }
        }
    }
    public void Render(Graphics g){
        
        ImageIcon img = new ImageIcon("image/2.png");
        image = img.getImage();
        g.drawImage(image, (int)x, (int)y, Width, Height, w);
        
    }
    
}