package com.devstackio.fullstackcoder.entity;

import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class MultiAnimation extends Animation {
    
    protected static SpriteSheet spriteSheet;
    protected static Animation[] animations;
    protected static int currentAnimation;
    protected List<Integer> animationSpeeds;
    protected float x;
    protected float y;
    
    public MultiAnimation( int numberOfAnimations, SpriteSheet spritesheet ) {
        super();
        animationSpeeds = new LinkedList();
        this.animations = new Animation[ numberOfAnimations ];
        this.spriteSheet = spritesheet;
        this.createAnimations();
    }
    
    /**
     * fill our Animation[] with Animation objects - override
     */
    public void createAnimations() {
        
    }
    
    public void setCurrentAnimation( int animationIndex ) {
        this.currentAnimation = animationIndex;
    }
    
    @Override
    public void draw() {
        
        System.out.println("--multianimation check : x is : " + x);
        this.animations[ this.currentAnimation ].draw( x, y );
        
    }
    
}
