package com.devstackio.fullstackcoder.gamestates.tests;

import com.devstackio.fullstackcoder.entity.SpriteSheets;
import com.devstackio.fullstackcoder.entity.enemy.Enemy;
import com.devstackio.fullstackcoder.entity.enemy.EnemyFactory;
import com.devstackio.fullstackcoder.gamestates.SharedGameState;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class EnemyFlyTest extends SharedGameState {

    private static final int NUM_DRAGONS = 3;
    private List<Enemy> flyingArray;
    
    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        System.out.println("[[ EnemyFlyTest initializing... ]]");
        super.setStateBasedGame( sbg );
        this.flyingArray = new ArrayList();
        
        for (int i = 0; i < NUM_DRAGONS; i++) {
            Enemy dragon = EnemyFactory.INSTANCE.createFlyingEnemy();
            this.flyingArray.add( dragon );
            
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        for ( Enemy dragon : this.flyingArray ) {
            dragon.draw();
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        for ( Enemy dragon : this.flyingArray ) {
            dragon.update( i );
        }
    }
    
}
