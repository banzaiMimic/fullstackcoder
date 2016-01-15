package com.devstackio.fullstackcoder.code;

import com.devstackio.fullstackcoder.entity.defender.IDefender;
import com.devstackio.fullstackcoder.entity.enemy.EnemyBlock;
import org.newdawn.slick.Graphics;

/**
 * will act as main control for generating CodeBlocks / CodeLines and matching Enemy entities
 * -Todo this should be able to pull individual blocks from full levels from some LevelParser that would load from a json file.
 * @author devstackio @devstackioweb
 */
public class BlockGenerator {
    
    private CodeBlock codeBlock;
    private EnemyBlock enemyBlock;
    private String[] lines;
    private IDefender defender;
    
    public BlockGenerator() {
        
        String[] hardCodedLinesForNow = {"hello","this is blockGenerator!","cookin somethin..."};
        this.lines = hardCodedLinesForNow;
        
    }
    
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
    
    public void generate( Graphics g ) {
        
        this.codeBlock = new CodeBlock( g, this.lines);
        this.enemyBlock = new EnemyBlock( g, this.lines.length );
        
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