package com.devstackio.fullstackcoder.observer;

import com.devstackio.fullstackcoder.code.CodeBlock;
import com.devstackio.fullstackcoder.entity.defender.IDefender;
import com.devstackio.fullstackcoder.entity.enemy.EnemyBlock;

public enum ActionObserver {
       
    INSTANCE;
    
    private EnemyBlock enemyBlock;
    private CodeBlock codeBlock;
    private IDefender defender;
    
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
                this.enemyBlock.killEnemy();
                
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
    
}
