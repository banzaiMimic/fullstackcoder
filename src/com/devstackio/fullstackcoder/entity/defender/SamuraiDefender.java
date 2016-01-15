package com.devstackio.fullstackcoder.entity.defender;

import com.devstackio.fullstackcoder.entity.SpriteSheets;
import org.newdawn.slick.Animation;

public class SamuraiDefender extends AbstractDefender implements IDefender {
    
    public SamuraiDefender() {
        super( 5, SpriteSheets.INSTANCE.getDEFENDER_SAMURAI_RUN() );
    }
    
    private Animation createAnimation( int startframe, int framecount, int animSpeed ) {
        
        Animation returnobj = new Animation();
        returnobj.setAutoUpdate( true );
        
        for (int i = 0; i < framecount; i++) {
            returnobj.addFrame( this.spriteSheet.getSprite( (i+startframe), 0), animSpeed );
        }
        
        return returnobj;
        
    }
    
    @Override
    public void createAnimations() {
        
        this.animations[0] = this.createAnimation( 0, 8, 40 );  // attack
        this.animations[1] = this.createAnimation( 8, 4, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() );  // idle
        this.animations[2] = this.createAnimation( 12, 4, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() ); // jump
        this.animations[3] = this.createAnimation( 16, 6, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() ); // run
        this.animations[4] = this.createAnimation( 24, 6, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() ); // swim
        
    }
    
    @Override
    public void draw() {
        
        SamuraiDefender.animations[ SamuraiDefender.currentAnimation ].draw( x, y );
        
        if( 0 == SamuraiDefender.currentAnimation ) {   // only want to run through 1 attack animation then return to running...

            if ( SamuraiDefender.animations[ SamuraiDefender.currentAnimation ].getFrame() == SamuraiDefender.animations[ SamuraiDefender.currentAnimation ].getFrameCount()-1 ) {
                this.setCurrentAnimation( 3 );
            }
            
        }
        
        
    }
    
}
