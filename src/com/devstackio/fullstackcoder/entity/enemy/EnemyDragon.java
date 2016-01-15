package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.entity.SpriteSheets;
import com.devstackio.fullstackcoder.utils.MathUtils;

public class EnemyDragon extends Enemy {
    
    public EnemyDragon(  ) {
        super( 2, SpriteSheets.INSTANCE.getEnemyDragon() );
        this.currentAnimation = 1; // flying
        this.setY( MathUtils.INSTANCE.getRandom( 200, 450 ) );
        this.setDeathIndex( 0 );
        this.setAttackIndex( 1 );
    }
    
    @Override
    public void createAnimations() {
        
        this.addAnimation( 0, this.createAnimation( 0, 4, 120 ) ); // death
        this.addAnimation( 1, this.createAnimation( 4, 4, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() ));  // fly
        
    }

    
}
