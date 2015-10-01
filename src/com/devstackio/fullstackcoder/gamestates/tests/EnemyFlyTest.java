package com.devstackio.fullstackcoder.gamestates.tests;

import com.devstackio.fullstackcoder.entity.SpriteSheets;
import com.devstackio.fullstackcoder.entity.enemy.FlyingEnemy;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EnemyFlyTest extends BasicGameState {

    private static final int NUM_DRAGONS = 3;
    private List<FlyingEnemy> flyingArray;
    
    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        this.flyingArray = new ArrayList();
        
        for (int i = 0; i < NUM_DRAGONS; i++) {
            FlyingEnemy dragon = new FlyingEnemy(SpriteSheets.INSTANCE.getFlappyDragon(), SpriteSheets.INSTANCE.getAnimSpeed());
            this.flyingArray.add( dragon );
            
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        for ( FlyingEnemy dragon : this.flyingArray ) {
            dragon.draw();
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        for ( FlyingEnemy dragon : this.flyingArray ) {
            dragon.update( i );
        }
    }
    
}
