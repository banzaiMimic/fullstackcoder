package com.devstackio.fullstackcoder.gamestates.tests;

import com.devstackio.fullstackcoder.code.BlockGenerator;
import com.devstackio.fullstackcoder.code.IoKeyListener;
import com.devstackio.fullstackcoder.entity.defender.IDefender;
import com.devstackio.fullstackcoder.entity.defender.SamuraiDefender;
import com.devstackio.fullstackcoder.gamestates.SharedGameState;
import com.devstackio.fullstackcoder.observer.ActionObserver;
import com.devstackio.fullstackcoder.observer.ActionType;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class BaseDefenderTest extends SharedGameState {
    
    private ActionObserver actionObserver;
    private BlockGenerator blockGenerator;
    private IoKeyListener ioKeyListener;
    private IDefender defender;

    @Override
    public int getID() {
        return 7;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        System.out.println("[[ FullCodeBlockTest initializing... ]]");
        super.setStateBasedGame( sbg );
        
        this.actionObserver = ActionObserver.INSTANCE;
        this.ioKeyListener = IoKeyListener.INSTANCE;
        this.defender = new SamuraiDefender();
        this.blockGenerator = new BlockGenerator();
        this.blockGenerator.setDefender( this.defender );
        
        
        // create CodeBlock with matching EnemyBlock - stored in blockGenerator
        this.blockGenerator.generate( gc.getGraphics() );
        this.ioKeyListener.setCodeBlock( this.blockGenerator.getCodeBlock() );
        System.out.println("trying to set enemyBlock from fullCodeBlockTest to actionObserver");
        
        this.actionObserver.setEnemyBlock( this.blockGenerator.getEnemyBlock() );
        this.actionObserver.setDefender( this.defender );
        
        //@Todo pass reference to observables into ioKeyListener ... maybe just <this> and deal with actions via switch
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        
        this.blockGenerator.ioDraw();
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        this.blockGenerator.ioUpdate( i );
        
    }
    
    @Override
    public void keyPressed( int key, char c ) {
        this.ioKeyListener.keyPressed(key, c);
    }
    
}

// we need key listener here to dispatch an 'attack' event
// attack event for test should fire on space bar.
// attack event should trigger attack animation on our defender
// this should happen all at abstract level for shared among defenders.


// we need a base health display
// we need a damage update when enemy is touching our base
// we need a ui update when base is being damaged
// we need a game over screen 
// we need to jump to game over screen when base is destroyed
// we need to be able to go back to main menu from our game over screen