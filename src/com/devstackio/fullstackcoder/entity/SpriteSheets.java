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
    private final int DEFENDER_ANIM_SPEED = 60;
    private SpriteSheet ENEMY_DRAGON;
    private SpriteSheet ENEMY_ZOMBIE;
    private SpriteSheet DEFENDER_SAMURAI;
    
    SpriteSheets(){
        this.init();
    }
    
    private void init() {
        try {
            
            ENEMY_DRAGON = this.loadEnemyDragon();
            ENEMY_ZOMBIE = this.loadEnemyZombie();
            DEFENDER_SAMURAI = this.loadDefenderSamuraiRun();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private SpriteSheet loadDefenderSamuraiRun() throws SlickException {
        return new SpriteSheet("data/spritesheets/defender/samurai/samurai-120x87-32.png",120,87);
    }
    
    private SpriteSheet loadEnemyDragon() throws SlickException {
        return new SpriteSheet("data/spritesheets/enemy/dragon/dragon-140x220.png",140,220);
    }
    
    private SpriteSheet loadEnemyZombie() throws SlickException {
        return new SpriteSheet("data/spritesheets/enemy/zombie/zombie-288x210.png",288,210);
    }
    
    public SpriteSheet getEnemyZombie() {
        return ENEMY_ZOMBIE;
    }
    
    public SpriteSheet getEnemyDragon() {
        return ENEMY_DRAGON;
    }
    
    public int getAnimSpeed() {
        return ANIM_SPEED;
    }

    public SpriteSheet getDEFENDER_SAMURAI() {
        return DEFENDER_SAMURAI;
    }

    public void setDEFENDER_SAMURAI(SpriteSheet DEFENDER_SAMURAI_RUN) {
        this.DEFENDER_SAMURAI = DEFENDER_SAMURAI_RUN;
    }

    public int getDEFENDER_ANIM_SPEED() {
        return DEFENDER_ANIM_SPEED;
    }
    
}
