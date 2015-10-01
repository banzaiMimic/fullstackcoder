package com.devstackio.fullstackcoder.utils;

import com.devstackio.fullstackcoder.entity.enemy.EnemyType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum EnemyUtil {
    
    INSTANCE;
    
    private final List<EnemyType> enemyTypes;
    private final Random random;
    
    EnemyUtil() {
        this.enemyTypes = new ArrayList();
        this.random = new Random();
        for ( EnemyType type : EnemyType.values() ) {
            this.enemyTypes.add( type );
        }
    }
    
    public EnemyType getRandomEnemyType() {
        
        int randIndex = this.random.nextInt( this.enemyTypes.size() );
        return this.enemyTypes.get( randIndex );
        
    }
    
}
