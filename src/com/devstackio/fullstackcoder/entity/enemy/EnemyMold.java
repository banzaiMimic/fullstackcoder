package com.devstackio.fullstackcoder.entity.enemy;

/**
 * creating a basic Enemy interface since we should be able to swap between different types of enemies later ( flying, walking, whatever else comes up )
 * @author devstackio @devstackioweb
 */
public interface EnemyMold {

    void draw();

    boolean getStationary();

    void setStationary(boolean bool);

    void update(long delta);
    
}
