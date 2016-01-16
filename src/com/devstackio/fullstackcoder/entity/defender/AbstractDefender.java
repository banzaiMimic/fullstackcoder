package com.devstackio.fullstackcoder.entity.defender;

import com.devstackio.fullstackcoder.Constants;
import com.devstackio.fullstackcoder.entity.MultiAnimation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

public class AbstractDefender extends MultiAnimation {
    
    private float x;
    private float y;
    private float health;
    private float healthWidth;
    private float healthHeight;
    private float healthX;
    private float healthY;
    private float maxHealth;
    private int dpsCount=0;
    private int pastTime=0;
    
    public AbstractDefender( int numanimations, SpriteSheet spritesheet ) {
        super( numanimations, spritesheet );
        this.x = Constants.INSTANCE.getDEFENDER_X();
        this.y = Constants.INSTANCE.getDEFENDER_Y();
        this.health = this.spriteSheet.getSprite(0, 0).getWidth();
        this.healthWidth = this.health;
        this.healthHeight = 6;
        this.healthX = this.x;
        this.healthY = this.y + this.spriteSheet.getHeight();
        this.maxHealth = this.health;
    }
    
    public void clearDps() {
        this.dpsCount = 0;
    }
    
    public void drawHealth( Graphics g ) {
        g.setColor( Color.red );
        float healthGAWidth = ((float) getHealth() / (float) getMaxHealth()) * (float) getHealthWidth();
        //g.fillRect(getHealthX(), getHealthY(), getHealthWidth(), getHealthHeight());
        g.fillRect(getHealthX(), getHealthY(), healthGAWidth, getHealthHeight());
    }
    
    @Override
    public void update( long delta ) {
        
        //System.out.println("--- delta test : " + delta );
        this.pastTime+=1;
        
        if( this.pastTime > 150 ) {
            this.updateHealth();
            this.pastTime = 0;
        }
        
    }
    
    private void updateHealth() {
        if( this.getDpsCount() > 0 && this.getHealth() > 0 ) {
            System.out.println("--updating health ---------------------------");
            this.setHealth( this.getHealth() - Constants.INSTANCE.getDPS_AMOUNT() );
            System.out.println("-- new health : " + this.getHealth() );
        }
    }
    
    public void addDps() {
        this.dpsCount++;
    }
    
    public void removeDps() {
        if( this.getDpsCount() > 0 ) {
            this.setDpsCount( this.getDpsCount()-1 );
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getHealthWidth() {
        return healthWidth;
    }

    public void setHealthWidth(float healthWidth) {
        this.healthWidth = healthWidth;
    }

    public float getHealthHeight() {
        return healthHeight;
    }

    public void setHealthHeight(float healthHeight) {
        this.healthHeight = healthHeight;
    }

    public float getHealthX() {
        return healthX;
    }

    public void setHealthX(float healthX) {
        this.healthX = healthX;
    }

    public float getHealthY() {
        return healthY;
    }

    public void setHealthY(float healthY) {
        this.healthY = healthY;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDpsCount() {
        return dpsCount;
    }

    public void setDpsCount(int dpsCount) {
        this.dpsCount = dpsCount;
    }

    public int getPastTime() {
        return pastTime;
    }

    public void setPastTime(int pastTime) {
        this.pastTime = pastTime;
    }
    
}

