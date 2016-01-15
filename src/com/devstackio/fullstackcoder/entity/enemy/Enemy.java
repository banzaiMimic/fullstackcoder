package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.Constants;
import com.devstackio.fullstackcoder.entity.MultiAnimation;
import com.devstackio.fullstackcoder.utils.MathUtils;
import org.newdawn.slick.SpriteSheet;

public class Enemy extends MultiAnimation {
    
    private float x;
    private float y;
    protected boolean stationary = false;
    private int deathIndex;
    private boolean dead = false;
    private boolean remove = false;

    public Enemy( int numberOfAnimations, SpriteSheet spritesheet ) {
        super( numberOfAnimations, spritesheet );
        this.speed = Constants.INSTANCE.getBASE_ENEMY_SPEED();
        this.x = Constants.INSTANCE.getGAME_WIDTH();
        this.x = MathUtils.INSTANCE.getRandom( Constants.INSTANCE.getGAME_WIDTH()-50, Constants.INSTANCE.getGAME_WIDTH()+50 );
        this.y = Constants.INSTANCE.getGAME_HEIGHT() - this.spriteSheet.getHeight();
    }
    
    public Enemy( Enemy enemy ) {
        this( enemy.numberOfAnimations, enemy.spriteSheet );
        this.x = enemy.x;
        this.y = enemy.y;
    }
    
    /**
     * override - set currentAnimation to death animation and remove after
     */
    public void playDeath() {
        this.currentAnimation = this.getDeathIndex();
    }
    
    @Override
    public void update(long delta) {
        if (!this.stationary) {
            if (this.canMove()) {
                this.setX(this.getX() - speed);
            } else {
                this.stationary = true;
            }
        }
        super.update(delta);
    }
    
    @Override
    public void draw() {
   
        System.out.println("-- Enemy : animations length : " + this.getAnimations().length );
        System.out.println("   -- currentAnimation : " + this.currentAnimation );
        System.out.println("   -- deathIndex : " + this.getDeathIndex() );
        System.out.println("   -- curFrame : " + this.getAnimations()[ this.currentAnimation ].getFrame() );
        System.out.println("   -- frameCount : " + (this.getAnimations()[ this.currentAnimation ].getFrameCount()-1) );
        
        if( this.isDead() ) {
            this.setCurrentAnimation(deathIndex);
            if ( this.getAnimations()[ this.currentAnimation ].getFrame() == this.getAnimations()[ this.currentAnimation ].getFrameCount()-1 ) {
                System.out.println("---- dead ----");
                this.setRemove( true );
            }
        }
        
        if ( !this.getRemove() ) {
            this.getAnimations()[this.currentAnimation].draw(this.getX(), this.getY());
        }
        
    }
    
    protected boolean canMove() {
        return ( this.getX() >= Constants.INSTANCE.getENEMY_X_BOUNDS() );
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getDeathIndex() {
        return deathIndex;
    }

    public void setDeathIndex(int deathIndex) {
        this.deathIndex = deathIndex;
    }

    public boolean getRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
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
    
}
