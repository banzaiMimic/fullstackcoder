package com.devstackio.fullstackcoder.entity.enemy;

import com.devstackio.fullstackcoder.observer.ActionObserver;
import com.devstackio.fullstackcoder.observer.ActionType;
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
    private List<Enemy> enemies;
    private int enemyCount;
    private final ActionObserver actionObserver = ActionObserver.INSTANCE;
    
    public EnemyBlock( Graphics g, int num ) {
        GRAPHIX = g;
        this.enemyCount = num;
        this.enemyFactory = EnemyFactory.INSTANCE;
        this.enemies = this.createEnemies();
    }
    
    private List<Enemy> createEnemies() {
        List<Enemy> returnobj = new LinkedList();
        
        for (int i = 0; i < this.enemyCount; i++) {
            
            returnobj.add( this.enemyFactory.createRandomEnemy() );
            
        }
        return returnobj;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
    
    public void ioDraw() {
        
        for ( Enemy enemy : this.enemies ) {
            
            if ( enemy.isStationary() && !enemy.hasSentAttack() ) {
                
                this.actionObserver.sendAction( ActionType.DEFENDER_DAMAGED );
                enemy.setHasSentAttack( true );
            }
            
            enemy.draw();
            
        }
    }
    
    public void ioUpdate( int delta ) {
        for ( Enemy enemy : this.enemies ) {
            
            enemy.update( delta );
              
        }
    }
    
    public void killEnemy() {
        
        System.out.println("EnemyBlock removing enemy...");
        // remove enemy
        for ( Enemy enemy : this.getEnemies() ) {
            if ( !enemy.isDead() ) {
                this.actionObserver.sendAction( ActionType.DEFENDER_ATTACK );
                enemy.setDead(true);
                break;
            }
        }
        
    }
    
}
