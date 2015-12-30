package com.devstackio.fullstackcoder.entity;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * singleton instance for loading and re-using all entity SpriteSheets
 * @author devstackio
 */
public enum SpriteSheets {
    
    INSTANCE;
    
    private final int ANIM_SPEED = 120;
    private SpriteSheet FLAPPY_DRAGON;
    private SpriteSheet ZOMBIE_WALK;
    
    SpriteSheets(){
        
        try {
            FLAPPY_DRAGON = this.loadFlappyDragon();
            ZOMBIE_WALK = this.loadZombieWalk();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private SpriteSheet loadFlappyDragon() throws SlickException {
        return new SpriteSheet("data/spritesheets/enemy/flappy-dragon-140x101.png",140,101);
    }
    
    private SpriteSheet loadZombieWalk() throws SlickException {
        return new SpriteSheet("data/spritesheets/enemy/zombie/zombie-walk.png",200,312);
    }
    
    public SpriteSheet getZombieWalk() {
        return ZOMBIE_WALK;
    }
    
    public SpriteSheet getFlappyDragon() {
        return FLAPPY_DRAGON;
    }
    
    public int getAnimSpeed() {
        return ANIM_SPEED;
    }
    
}
