package com.devstackio.fullstackcoder.entity;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public enum SpriteSheets {
    
    INSTANCE;
    
    private final int ANIM_SPEED = 50;
    private final SpriteSheet FLAPPY_DRAGON;
    
    SpriteSheets(){
        
        FLAPPY_DRAGON = this.loadFlappyDragon();
        
    }
    
    private SpriteSheet loadFlappyDragon() {
        
        try {
            
            return new SpriteSheet("data/spritesheets/enemy/flappy-dragon-140x101.png",140,101);
            
        } catch(SlickException e ) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public SpriteSheet getFlappyDragon() {
        return FLAPPY_DRAGON;
    }
    
    public int getAnimSpeed() {
        return ANIM_SPEED;
    }
    
}
