package com.mycompany.porjectgame;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;

public class Garavity extends JFrame implements Runnable{
    public int d=0;
    public int heart=3;
    public double Garavity = 5;
    final static int obj_x = 300;
    final static int obj_y = 350;      
    private int x_new = (int)(Math.random() * obj_x)*5;
    private int y_new = (int)(Math.random() * obj_y); 

     
    public LinkedList<Item> item = new LinkedList<Item>();
    
    public Player player;
    public Window w;
    private int seed; 
    public double CamX=-5, CamY=0;
    public int StartingX =100, StartingY = 200;
    Thread th = new Thread(this);
    
    boolean Rt = true;
    
    public Garavity(Window w){
        this.w=w;
        Random r = new Random();
        seed = r.nextInt();
        
        player = new Player(w,StartingX,StartingY, 60,60);
        
        item.add(new Platform(ObjectIDS.Platform, 100, 300, 200, 2, Color.white));
        item.add(new Platform(ObjectIDS.Platform, 375, 250, 200, 2, Color.white));
        item.add(new Platform(ObjectIDS.Platform, 400, 350, 200, 2, Color.white));
        item.add(new Platform(ObjectIDS.Stair, 700, 100, 2, 300, Color.white));//stairs
        item.add(new Platform(ObjectIDS.Platform, 0, 400, 1000, 2, Color.white));//floor down
        item.add(new Platform(ObjectIDS.Platform, 1100, 400, 1000, 2, Color.white));//floor down 2
        item.add(new Platform(ObjectIDS.floor2, 0, 100, 800, 2, Color.white));//floor haven 
        item.add(new Platform(ObjectIDS.floor2, 1100, 100, 800, 2, Color.white));//floor haven 2
        item.add(new Platform(ObjectIDS.Stair, 1500, 100, 2, 300, Color.white));//stairs
        item.add(new Monster(w, ObjectIDS.Monster1, 10, 300, 80, 60));
        item.add(new Monster(w, ObjectIDS.Monster2, 50, 0, 80, 60));
        item.add(new Monster(w, ObjectIDS.Monster3, 1120, 0, 80, 60));
        item.add(new Monster(w, ObjectIDS.Monster4, 900, 0, 80, 60));
        item.add(new Monster(w, ObjectIDS.Monster5, 1400, 300, 80, 60));
        item.add(new OBJ(ObjectIDS.fruit, 60, 50, 44, 44, Color.green));
        while((y_new < 300 || x_new >1700 || x_new < 0)){
            x_new = (int)(Math.random() * obj_x)*3;
            y_new = (int)(Math.random() * obj_y);
            System.out.println(y_new);
        }
        item.add(new OBJ(ObjectIDS.OBJ, x_new, y_new, 40, 40, Color.BLUE));
    }
    public void Render(Graphics g){
        g.translate(-(int)CamX, -(int)CamY);
        
        if(player != null)player.Render(g);
        for(Item i : item){
            i.Render(g);
        }
        player.Render(g);
        g.translate((int)CamX, (int)CamY);
        g.setColor(Color.white);
        g.drawString("score", 700, 20);
        g.drawString(""+(d), 750, 20);
        g.drawString(""+(heart), 20, 20);
        
        if(heart == 0){
            heart = 4;
            d = 0;
            w.gs = GameState.Menu;
        }
    }

    public void tick(){
       
        for(Item i : item){
            i.tick();        
        }
        if(player != null)player.tick();
    }
    public void Reso() {
        d+=1;
        for(Item i : w.level.item){
        if(i.ID == ObjectIDS.OBJ){
        OBJ obj = (OBJ)i;
        item.remove(obj);
        }
        }
        x_new = (int)(Math.random() * obj_x)*3;
        y_new = (int)(Math.random() * obj_y);
        if(d <3){
        while(y_new < 300 || x_new >1700 || x_new < 0){
        x_new = (int)(Math.random() * obj_x)*3;
        y_new = (int)(Math.random() * obj_y);
        System.out.println(y_new);
        }
        
            item.add(new OBJ(ObjectIDS.OBJ, x_new, y_new, 40, 40, Color.blue));
            System.out.println(y_new);
        }
    }
    public void Reso4() {
        if(heart != 3){           
            heart+=1;
            for(Item i : w.level.item){
                if(i.ID == ObjectIDS.fruit){
                    OBJ obj = (OBJ)i;
                    item.remove(obj);
                    
                }
            }
        }
        else{
            for(Item i : w.level.item){
                if(i.ID == ObjectIDS.fruit){
                    OBJ obj = (OBJ)i;
                    item.remove(obj);      
                }
            }
        }
    }
    
    public void LoseGame(){
        w.gs = GameState.Lose;
    }
    
    public int reso6(int a){
        
        return player.id;
        
    }

    public void reso(){
               heart-=1;
               if(heart != 0){
               w.gs = GameState.Try;
               w.level.Restart();
               }
               else{
                   w.gs = GameState.Lose;
               }
 
            }
    public void reso1(){

               heart-=1;
               if(heart != 0){
               w.gs = GameState.Try;
               w.level.Restart();
               }
               else{
                   w.gs = GameState.Lose;
               }
            }
    public void reso2(){

               heart-=1;
               if(heart != 0){
               w.gs = GameState.Try;
               w.level.Restart();
               }
               else{
                   w.gs = GameState.Lose;
               }
            }
    public void reso3(){

               heart-=1;
               if(heart != 0){
               w.gs = GameState.Try;
               w.level.Restart();
               }
               else{
                   w.gs = GameState.Lose;
               }
            }
    public void reso4(){

               heart-=1;
               if(heart != 0){
               w.gs = GameState.Try;
               w.level.Restart();
               }
               else{
                   w.gs = GameState.Lose;
               }
            }

    @Override
    public void run() {
          while(true){
        try{
            th.sleep(100);
        } catch (InterruptedException e){}
        repaint();
        }
    }

    private void Restart() {
        player.x=StartingX;
        player.y=StartingY;
        CamX =0;
        CamY =0;
    }

}