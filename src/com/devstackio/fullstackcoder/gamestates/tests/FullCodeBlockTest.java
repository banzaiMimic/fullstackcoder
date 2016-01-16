package com.devstackio.fullstackcoder.gamestates.tests;

import com.devstackio.fullstackcoder.code.BlockGenerator;
import com.devstackio.fullstackcoder.code.IoKeyListener;
import com.devstackio.fullstackcoder.gamestates.SharedGameState;
import com.devstackio.fullstackcoder.observer.ActionObserver;
import com.devstackio.fullstackcoder.utils.LineGenerator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class FullCodeBlockTest extends SharedGameState {
    
    private ActionObserver actionObserver;
    private BlockGenerator blockGenerator;
    private IoKeyListener ioKeyListener;

    @Override
    public int getID() {
        return 6;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        System.out.println("[[ FullCodeBlockTest initializing... ]]");
        super.setStateBasedGame( sbg );
        this.actionObserver = ActionObserver.INSTANCE;
        this.ioKeyListener = IoKeyListener.INSTANCE;
        this.blockGenerator = new BlockGenerator();
        // create CodeBlock with matching EnemyBlock - stored in blockGenerator
        this.blockGenerator.generate( gc.getGraphics(), LineGenerator.INSTANCE.getStaticLines() );
        this.ioKeyListener.setCodeBlock( this.blockGenerator.getCodeBlock() );
        System.out.println("trying to set enemyBlock from fullCodeBlockTest to actionObserver");
        this.actionObserver.setEnemyBlock( this.blockGenerator.getEnemyBlock() );
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
