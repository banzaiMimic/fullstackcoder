package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.entity.SpriteSheets;

public class EnemyZombie extends Enemy {

    public EnemyZombie(  ) {
        super( 3, SpriteSheets.INSTANCE.getEnemyZombie() );
        this.currentAnimation = 2;
        this.setDeathIndex( 1 );
    }
    
    @Override
    public void createAnimations() {
        
        this.addAnimation( 0, this.createAnimation( 0, 7, 65 )); //attack
        this.addAnimation( 1, this.createAnimation( 7, 8, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() )); // death
        this.addAnimation( 2, this.createAnimation( 15, 10, SpriteSheets.INSTANCE.getDEFENDER_ANIM_SPEED() )); // walk
        
    }
    
}
