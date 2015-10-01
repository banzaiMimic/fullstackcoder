package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.entity.EntityState;
import com.devstackio.fullstackcoder.entity.SpriteSheets;
import com.devstackio.fullstackcoder.utils.MathUtils;
import org.newdawn.slick.Animation;

public class FlappyDragon extends Animation {
    
    private static final float FLY_SPEED = 5;
    private static final float X_BOUNDS = 50;
    private float x;
    private float y;
    private boolean stationary = false;
    private EntityState state = EntityState.ALIVE;
    
    public FlappyDragon() {
        super(SpriteSheets.INSTANCE.getFlappyDragon(), SpriteSheets.INSTANCE.getAnimSpeed());
        this.x = 500;
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
