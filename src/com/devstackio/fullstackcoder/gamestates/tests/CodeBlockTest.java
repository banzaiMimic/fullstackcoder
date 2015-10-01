package com.devstackio.fullstackcoder.gamestates.tests;

import com.devstackio.fullstackcoder.code.CodeBlock;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CodeBlockTest extends BasicGameState {
    
    private CodeBlock codeBlock;

    @Override
    public int getID() {
        return 5;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        System.out.println("initializing codeBlocktest...");
        String[] lines = {"test","testtwo","testThree"};
        this.codeBlock = new CodeBlock( gc.getGraphics(), lines );
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        this.codeBlock.ioDraw();
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        this.codeBlock.ioUpdate();
        
    }
    
}
