package com.devstackio.fullstackcoder.entity.enemy;

import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.Graphics;

/**
 * Block of enemies - contains List of Enemy entities that will match to active CodeBlock
 * @author devstackio @devstackioweb
 */
public class EnemyBlock {
    
    private static Graphics GRAPHIX;
    private EnemyFactory enemyFactory;
    private float speed=.5f;
    private List<EnemyMold> enemies;
    private int enemyCount;
    
    public EnemyBlock( Graphics g, int num ) {
        GRAPHIX = g;
        this.enemyCount = num;
        this.enemyFactory = new EnemyFactory();
        this.enemies = this.createEnemies();
    }
    
    private List<EnemyMold> createEnemies() {
        List<EnemyMold> returnobj = new LinkedList();
        
        for (int i = 0; i < this.enemyCount; i++) {
            
            returnobj.add( this.enemyFactory.createRandomEnemy() );
            
        }
        return returnobj;
    }

    public List<EnemyMold> getEnemies() {
        return enemies;
    }
    
    public void ioDraw() {
        for ( EnemyMold enemy : this.enemies ) {
            enemy.draw();
        }
    }
    
    public void ioUpdate( int delta ) {
        for ( EnemyMold enemy : this.enemies ) {
            enemy.update( delta );
        }
    }
    
}
