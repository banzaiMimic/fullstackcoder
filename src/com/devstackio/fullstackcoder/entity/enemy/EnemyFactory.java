package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.entity.SpriteSheets;
import com.devstackio.fullstackcoder.utils.EnemyUtil;
import java.util.EnumMap;
import java.util.Map;

/**
 * enemy factory! 'nuff said
 * @author devstackio @devstackioweb
 */
public class EnemyFactory {
    
    private final Map<EnemyType, EnemyMold> enemies;
    
    public EnemyFactory() {
        this.enemies = new EnumMap<>(EnemyType.class);
    }
    
    /**
     * creates a random enemy from available EnemyType
     * @return random EnemyMold
     */
    public EnemyMold createRandomEnemy( ) {
        
        EnemyType type = EnemyUtil.INSTANCE.getRandomEnemyType();
        
        EnemyMold enemy = this.enemies.get(type);
        
        switch( type ) {
            
            case FLYING:
                enemy = new FlyingEnemy( SpriteSheets.INSTANCE.getFlappyDragon(), SpriteSheets.INSTANCE.getAnimSpeed() );
                break;
            case WALKING:
                enemy = new WalkingEnemy( SpriteSheets.INSTANCE.getZombieWalk(), SpriteSheets.INSTANCE.getAnimSpeed() );
                break;
            
        }
        
        return enemy;
        
    }
    
}
