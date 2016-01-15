package com.devstackio.fullstackcoder.entity.defender;

public interface IDefender {
    
    void draw();
    void update(long delta);
    void setCurrentAnimation( int animationIndex );
    
}
