package com.devstackio.fullstackcoder;

public enum Constants {
    
    INSTANCE;
    
    private static final String GAME_TITLE = "FullStackCoder";
    private static final int GAME_WIDTH = 1024;
    private static final int GAME_HEIGHT = 768;
    private static final int TARGET_FRAME_RATE = 60;

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
    
}
