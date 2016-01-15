package com.devstackio.fullstackcoder;

public enum Constants {
    
    INSTANCE;
    
    private final String GAME_TITLE = "FullStackCoder";
    private final int GAME_WIDTH = 1024;
    private final int GAME_HEIGHT = 768;
    private final int TARGET_FRAME_RATE = 60;
    private final int ENEMY_X_BOUNDS = 200;
    private final int DEFENDER_Y = 676;
    private final int DEFENDER_X = 125;     
    private final float BASE_ENEMY_SPEED = 1.9f;
    private final float DPS_AMOUNT = 10;

    public float getBASE_ENEMY_SPEED() {
        return BASE_ENEMY_SPEED;
    }

    public int getDEFENDER_Y() {
        return DEFENDER_Y;
    }

    public int getENEMY_X_BOUNDS() {
        return ENEMY_X_BOUNDS;
    }

    public int getDEFENDER_X() {
        return DEFENDER_X;
    }

    public String getGAME_TITLE() {
        return GAME_TITLE;
    }

    public int getGAME_WIDTH() {
        return GAME_WIDTH;
    }

    public int getGAME_HEIGHT() {
        return GAME_HEIGHT;
    }

    public int getFRAME_RATE() {
        return TARGET_FRAME_RATE;
    }

    public float getDPS_AMOUNT() {
        return DPS_AMOUNT;
    }
    
}
