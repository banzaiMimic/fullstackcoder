package com.devstackio.fullstackcoder.entity;

import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class MultiAnimation extends Animation {
    
    protected SpriteSheet spriteSheet;
    private Animation[] animations;
    protected int currentAnimation;
    protected int numberOfAnimations;
    protected float speed;
    protected List<Integer> animationSpeeds;
    
    public MultiAnimation( int numberOfAnimations, SpriteSheet spritesheet ) {
        super();
        this.numberOfAnimations = numberOfAnimations;
        this.speed = 0;
        animationSpeeds = new LinkedList();
        this.animations = new Animation[ numberOfAnimations ];
        this.spriteSheet = spritesheet;
        this.createAnimations();
    }
    
    public void addAnimation( int index, Animation animation ) {
        this.animations[ index ] = animation;
    }
    
    protected Animation createAnimation( int startframe, int framecount, int animSpeed ) {
        
        Animation returnobj = new Animation();
        returnobj.setAutoUpdate( true );
        
        for (int i = 0; i < framecount; i++) {
            returnobj.addFrame( this.spriteSheet.getSprite( (i+startframe), 0), animSpeed );
        }
        
        return returnobj;
        
    }
    
    /**
     * fill our Animation[] with Animation objects - override
     */
    public void createAnimations() {
        
    }
    
    public void setCurrentAnimation( int animationIndex ) {
        this.currentAnimation = animationIndex;
    }

    public Animation[] getAnimations() {
        return animations;
    }

    public void setAnimations(Animation[] animations) {
        this.animations = animations;
    }
    
}
