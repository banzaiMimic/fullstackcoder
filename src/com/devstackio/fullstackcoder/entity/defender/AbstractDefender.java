package com.devstackio.fullstackcoder.entity.defender;

import com.devstackio.fullstackcoder.Constants;
import com.devstackio.fullstackcoder.entity.MultiAnimation;
import org.newdawn.slick.SpriteSheet;

public class AbstractDefender extends MultiAnimation {
    
    protected float x;
    protected float y;
    
    public AbstractDefender( int numanimations, SpriteSheet spritesheet ) {
        super( numanimations, spritesheet );
        this.x = Constants.INSTANCE.getDEFENDER_X();
        this.y = Constants.INSTANCE.getDEFENDER_Y();
    }
    
}

