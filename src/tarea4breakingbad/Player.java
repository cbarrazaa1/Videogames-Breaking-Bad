/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea4breakingbad;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;

/**
 *
 * @author Cesar Barraza
 * @author Isabel Cruz
 */
public class Player extends Item {
    private Game game;
    
    public Player(int x, int y, int width, int height, Game game) {
        super(x,y,width,height);
        this.game = game;
    }
    public Game getGame() {
        return game;
    }
    @Override
    public void update() {
        if(getGame().getKeyManager().isKeyDown(KeyEvent.VK_LEFT)) {
          setX(getX() - 5);  
        }
        else if (getGame().getKeyManager().isKeyDown(KeyEvent.VK_RIGHT)) {
          setX(getX() + 5);  
        }
        // border collisions
        if(getX() + getWidth() >= getGame().getWidth()) {
            setX(getGame().getWidth() - getWidth());
        }
        else if(getX() <= 0) {
           setX(0); 
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }    
}