package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.utils.EnemyUtil;
import java.util.EnumMap;
import java.util.Map;

/**
 * enemy factory! 'nuff said
 * @author devstackio @devstackioweb
 */
public enum EnemyFactory {
    
    INSTANCE;
    
    private final Map<EnemyType, Enemy> enemies;
    
    EnemyFactory() {
        this.enemies = new EnumMap<>(EnemyType.class);
    }
    
    /**
     * creates a random enemy from available EnemyType
     * @return random EnemyMold
     */
    public Enemy createRandomEnemy( ) {
        
        EnemyType type = EnemyUtil.INSTANCE.getRandomEnemyType();
        
        Enemy enemy = this.enemies.get(type);
        
        switch( type ) {
            
            case FLYING:
                enemy = new EnemyDragon();
                break;
            case WALKING:
                enemy = new EnemyZombie();
                break;
            
        }
        
        return enemy;
        
    }
    
    public Enemy createFlyingEnemy() {
        return new EnemyDragon();
    }
    
}
