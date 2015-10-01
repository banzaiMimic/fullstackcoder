package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.Constants;
import com.devstackio.fullstackcoder.entity.EntityState;
import com.devstackio.fullstackcoder.entity.SpriteSheets;
import com.devstackio.fullstackcoder.utils.MathUtils;
import org.newdawn.slick.Animation;

/**
 * basic enemy entity that will spawn randomly between two points on the y axis and fly to the left
 * until reaching an X_BOUNDS point where it will still animate but no longer move.
 * this is for future addition of a 'base' that will be attacked by said entity.
 * @author devstackio
 */
public class FlappyDragon extends Animation {
    
    //@Todo move all common Entity properties and methods into an AbstractEntity class
    private static final float X_BOUNDS = 200;
    private float FLY_SPEED = 1;
    private float x;
    private float y;
    private boolean stationary = false;
    private EntityState state = EntityState.ALIVE;
    
    public FlappyDragon() {
        super(SpriteSheets.INSTANCE.getFlappyDragon(), SpriteSheets.INSTANCE.getAnimSpeed());
        this.x = Constants.INSTANCE.getGAME_WIDTH();
        this.y = MathUtils.INSTANCE.getRandom( 200, 700 );
    }
    
    public void setStationary( boolean bool ) {
        this.stationary = bool;
    }
    
    public boolean getStationary() {
        return this.stationary;
    }
    @Override
    public void draw() {
        super.draw( this.x, this.y );
    }
    @Override
    public void update( long delta ) {
        
        if ( !this.stationary ) {
            if( this.canMove() ) {
                this.x-= FLY_SPEED;
            } else {
                this.stationary = true;
            }
        }
        super.update( delta );
        
    }
    
    private boolean canMove() {
        return ( this.x >= X_BOUNDS ) ? true : false;
    }
    
}
