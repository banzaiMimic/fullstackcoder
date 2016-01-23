package com.devstackio.fullstackcoder.entity.defender;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public interface IDefender {
    
    void drawHealth( Graphics g );
    void draw();
    void update(long delta);
    void setCurrentAnimation( int animationIndex );
    void addDps();
    void removeDps();
    void clearDps();
    void setGame(StateBasedGame game);
    void onPlayerJump();
    
}
