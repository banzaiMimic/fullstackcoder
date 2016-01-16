package com.devstackio.fullstackcoder.observer;

import com.devstackio.fullstackcoder.code.BlockGenerator;
import com.devstackio.fullstackcoder.code.CodeBlock;
import com.devstackio.fullstackcoder.code.IoKeyListener;
import com.devstackio.fullstackcoder.entity.defender.IDefender;
import com.devstackio.fullstackcoder.entity.enemy.EnemyBlock;
import com.devstackio.fullstackcoder.utils.LineGenerator;
import org.newdawn.slick.Graphics;

public enum ActionObserver {
       
    INSTANCE;
    
    private BlockGenerator blockGenerator;
    private EnemyBlock enemyBlock;
    private CodeBlock codeBlock;
    private IDefender defender;
    private Graphics graphics;
    private IoKeyListener ioKeyListener;
    
    ActionObserver() {
        System.out.println("[[ initializing ActionObserver ]]");
    }
    
    public void sendAction( ActionType actionType ) {
        
        System.out.println("[[ ActionObserver action : " + actionType + " received...");
        
        switch( actionType ) {
            case LINE_COMPLETE:
                System.out.println( "  -- sending killEnemy to enemyBlock" );
                this.enemyBlock.killEnemy();
                this.defender.removeDps();
                break;
            case BLOCK_COMPLETE:
                System.out.println("  -- sending killEnemy to enemyBlock" );
                this.defender.clearDps();
                this.enemyBlock.killEnemy();
                this.blockGenerator.generate( this.graphics, LineGenerator.INSTANCE.getLines() );
                System.out.println("keylistener is : " + this.getIoKeyListener() );
                System.out.println("codeblock is : " + this.blockGenerator.getCodeBlock() );
                this.getIoKeyListener().setCodeBlock( this.blockGenerator.getCodeBlock() );
                break;
            case LEVEL_COMPLETE:
                
                break;
            case DEFENDER_ATTACK:
                this.defender.setCurrentAnimation( 0 );
                break;
            case DEFENDER_DAMAGED:
                this.defender.addDps();
                break;
        }
        
    }

    public EnemyBlock getEnemyBlock() {
        return enemyBlock;
    }

    public void setEnemyBlock(EnemyBlock enemyBlock) {
        System.out.println("-- setting enemyBlock in actionObserver to : " + enemyBlock);
        this.enemyBlock = enemyBlock;
    }

    public CodeBlock getCodeBlock() {
        return codeBlock;
    }

    public void setCodeBlock(CodeBlock codeBlock) {
        this.codeBlock = codeBlock;
    }

    public IDefender getDefender() {
        return defender;
    }

    public void setDefender(IDefender defender) {
        this.defender = defender;
    }

    public BlockGenerator getBlockGenerator() {
        return blockGenerator;
    }

    public void setBlockGenerator(BlockGenerator blockGenerator) {
        this.blockGenerator = blockGenerator;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public IoKeyListener getIoKeyListener() {
        return ioKeyListener;
    }

    public void setIoKeyListener(IoKeyListener ioKeyListener) {
        this.ioKeyListener = ioKeyListener;
    }
    
}
