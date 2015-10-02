package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.Constants;
import org.newdawn.slick.SpriteSheet;

public class WalkingEnemy extends FlyingEnemy {

    public WalkingEnemy(SpriteSheet frames, int duration) {
        super(frames, duration);
        this.y = Constants.INSTANCE.getGAME_HEIGHT() - 312;
    }
    
}
