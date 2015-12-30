package com.devstackio.fullstackcoder.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * used for sharing anything between all game states
 * ex: when escape key is pressed, load menu
 * @author devstackio
 */
public abstract class SharedGameState extends BasicGameState {
    
    protected StateBasedGame game;
    protected GameContainer gc;
    protected Music music;
    
    @Override
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        System.out.println("ENTERED GAME STATE : " + this.getID());
        this.init( gc, sbg);
    }
    
    @Override
    public void keyReleased( int key, char c ) {
        try {
            switch( key ) {
                case Input.KEY_ESCAPE:
                    this.game.enterState( 1 );
                    break;
            }
        } catch ( NullPointerException e ) {
            if( this.game == null ) {
                System.err.println("-- please call super.setStateBasedGame( game ) in your extended classes Overridden init method" );
            } else {
                e.printStackTrace();
            }
            
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
}
