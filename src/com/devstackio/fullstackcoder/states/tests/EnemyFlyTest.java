package com.devstackio.fullstackcoder.states.tests;

import com.devstackio.fullstackcoder.entity.enemy.FlappyDragon;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EnemyFlyTest extends BasicGameState {

    private static final int NUM_DRAGONS = 3;
    private List<FlappyDragon> dragonArray;
    
    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        this.dragonArray = new ArrayList();
        
        for (int i = 0; i < NUM_DRAGONS; i++) {
            FlappyDragon dragon = new FlappyDragon();
            this.dragonArray.add( dragon );
            
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        for ( FlappyDragon dragon : this.dragonArray ) {
            dragon.draw();
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        for ( FlappyDragon dragon : this.dragonArray ) {
            dragon.update( i );
        }
    }
    
}
