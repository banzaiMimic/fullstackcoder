package com.devstackio.fullstackcoder.gamestates;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
    
    private StateBasedGame game;
    
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.game = sbg;
    }
    
    @Override
    public void keyReleased( int key, char c ) {
        switch( key ) {
            case Input.KEY_1:
                this.game.enterState( 3 );
               break;
            case Input.KEY_2:
                break;
            case Input.KEY_3:
                break;
            case Input.KEY_4:
                this.game.enterState( 4 );
                break;
            default:
                break;
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor( Color.white );
        g.drawString( "devstackio's : FullStackCoder", 100, 10 );
        g.drawString( "1. Play Game", 100, 100 );
        g.drawString( "2. High Scores", 100, 120 );
        g.drawString( "3. Quit", 100, 140 );
        g.drawString( "-- Development Tests --", 100, 160 );
        g.drawString( "4. Enemy Fly Test", 100, 180 );
        g.drawString( "5. CodeBlock Test", 100, 200 );
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
    }
    
    
    
}
