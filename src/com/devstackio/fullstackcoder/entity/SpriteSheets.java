package com.devstackio.fullstackcoder.entity;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * singleton instance for loading and re-using all entity SpriteSheets
 * //http://instantsprite.com/
 * @author devstackio
 */
public enum SpriteSheets {
    
    INSTANCE;
    
    private final int ANIM_SPEED = 120;
    private final int DEFENDER_ANIM_SPEED = 70;
    private SpriteSheet FLAPPY_DRAGON;
    private SpriteSheet ZOMBIE_WALK;
    private SpriteSheet DEFENDER_SAMURAI_RUN;
    
    SpriteSheets(){
        this.init();
    }
    
    private void init() {
        try {
            
            FLAPPY_DRAGON = this.loadFlappyDragon();
            ZOMBIE_WALK = this.loadZombieWalk();
            DEFENDER_SAMURAI_RUN = this.loadDefenderSamuraiRun();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private SpriteSheet loadDefenderSamuraiRun() throws SlickException {
        return new SpriteSheet("data/spritesheets/defender/samurai/samurai-120x87-32.png",120,87);
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

    public SpriteSheet getDEFENDER_SAMURAI_RUN() {
        return DEFENDER_SAMURAI_RUN;
    }

    public void setDEFENDER_SAMURAI_RUN(SpriteSheet DEFENDER_SAMURAI_RUN) {
        this.DEFENDER_SAMURAI_RUN = DEFENDER_SAMURAI_RUN;
    }

    public int getDEFENDER_ANIM_SPEED() {
        return DEFENDER_ANIM_SPEED;
    }
    
}
