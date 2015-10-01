package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.entity.SpriteSheets;
import java.util.EnumMap;
import java.util.Map;

/**
 * enemy factory! 'nuff said
 * @author devstackio <@devstackioweb>
 */
public class EnemyFactory {
    
    private final Map<EnemyType, EnemyMold> enemies;
    
    public EnemyFactory() {
        this.enemies = new EnumMap<>(EnemyType.class);
    }
    
    public EnemyMold createEnemy( EnemyType type ) {
        
        EnemyMold enemy = this.enemies.get(type);
        
        switch( type ) {
            
            case FLYING:
                enemy = new FlyingEnemy( SpriteSheets.INSTANCE.getFlappyDragon(), SpriteSheets.INSTANCE.getAnimSpeed() );
                break;
            case WALKING:
                break;
            
        }
        
        return enemy;
        
    }
    
}
