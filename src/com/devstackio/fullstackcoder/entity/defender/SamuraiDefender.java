package com.devstackio.fullstackcoder.entity.defender;

import com.devstackio.fullstackcoder.entity.SpriteSheets;

public class SamuraiDefender extends AbstractDefender implements IDefender {
    
    public SamuraiDefender() {
        super( 5, SpriteSheets.INSTANCE.getDEFENDER_SAMURAI() );
        this.currentAnimation = 3;
    }
    
    @Override
    public void createAnimations() {
        
        this.addAnimation( 0, this.createAnimation( 0, 8, 40 ) ); // attack
        this.addAnimation( 1, this.createAnimation( 8, 4, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() ) ); // idle
        this.addAnimation( 2, this.createAnimation( 12, 4, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() ) ); // jump
        this.addAnimation( 3, this.createAnimation( 16, 6, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() ) ); // run
        this.addAnimation( 4, this.createAnimation( 24, 6, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() ) ); // swim
        
    }
    
    @Override
    public void draw() {
        
//        System.out.println("[[ SamuraiDefender : animations length : " + this.getAnimations().length );
//        System.out.println("  -- currentAnimation : " + this.currentAnimation );
        this.getAnimations()[ this.currentAnimation ].draw( this.getX(), this.getY() );
        
        if( 0 == this.currentAnimation ) {   // only want to run through 1 attack animation then return to running...

            if ( this.getAnimations()[ this.currentAnimation ].getFrame() == this.getAnimations()[ this.currentAnimation ].getFrameCount()-1 ) {
                this.setCurrentAnimation( 3 );
            }
            
        }
        
    }
    
}
