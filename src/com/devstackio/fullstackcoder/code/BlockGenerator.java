package com.devstackio.fullstackcoder.code;

import com.devstackio.fullstackcoder.entity.defender.IDefender;
import com.devstackio.fullstackcoder.entity.enemy.EnemyBlock;
import com.devstackio.fullstackcoder.observer.ActionObserver;
import org.newdawn.slick.Graphics;

/**
 * will act as main control for generating CodeBlocks / CodeLines and matching Enemy entities
 * -Todo this should be able to pull individual blocks from full levels from some LevelParser that would load from a json file.
 * @author devstackio @devstackioweb
 */
public class BlockGenerator {
    
    private CodeBlock codeBlock;
    private EnemyBlock enemyBlock;
    private IDefender defender;
    
    public void ioDraw() {
        if ( this.getDefender() != null ) {
            this.getDefender().draw();
        }
        this.codeBlock.ioDraw();
        this.enemyBlock.ioDraw();
    }
    
    public void ioUpdate( int delta ) {
        this.codeBlock.ioUpdate();
        this.enemyBlock.ioUpdate( delta );
        if ( this.getDefender() != null ) {
            this.getDefender().update( delta );
        }
    }
    
    public void generate( Graphics g, String[] newLines ) {
        
        this.codeBlock = new CodeBlock( g, newLines );
        this.enemyBlock = new EnemyBlock( g, newLines.length );
        
        ActionObserver.INSTANCE.setEnemyBlock( this.getEnemyBlock() );
        
    }
    
    public IDefender getDefender() {
        return this.defender;
    }

    public CodeBlock getCodeBlock() {
        return codeBlock;
    }

    public EnemyBlock getEnemyBlock() {
        return enemyBlock;
    }

    public void setDefender(IDefender defender) {
        this.defender = defender;
    }
    
}