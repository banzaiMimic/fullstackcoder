package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.Constants;
import com.devstackio.fullstackcoder.entity.EntityState;
import com.devstackio.fullstackcoder.utils.MathUtils;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

/**
 * basic flying enemy entity that will spawn randomly between two points on the y axis and fly to the left
 * until reaching an X_BOUNDS point where it will still animate but no longer move.
 * this is for future addition of a 'base' that will be attacked by said entity.
 * @author devstackio
 */
public class FlyingEnemy extends Animation implements EnemyMold {
    
    protected static final float X_BOUNDS = 200;
    protected float speed = .5f;
    protected float x;
    protected float y;
    protected boolean stationary = false;
    protected EntityState state = EntityState.ALIVE;

    public FlyingEnemy(SpriteSheet frames, int duration) {
        super(frames, duration);
        this.x = Constants.INSTANCE.getGAME_WIDTH();
        this.y = MathUtils.INSTANCE.getRandom( 200, 700 );
    }

    @Override
    public void setStationary(boolean bool) {
        this.stationary = bool;
    }

    @Override
    public boolean getStationary() {
        return this.stationary;
    }

    @Override
    public void draw() {
        super.draw(this.x, this.y);
    }

    @Override
    public void update(long delta) {
        if (!this.stationary) {
            if (this.canMove()) {
                this.x -= speed;
            } else {
                this.stationary = true;
            }
        }
        super.update(delta);
    }

    protected boolean canMove() {
        return (this.x >= X_BOUNDS) ? true : false;
    }
    
}
