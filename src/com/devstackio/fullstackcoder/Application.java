package com.devstackio.fullstackcoder;

import java.io.File;
import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Application {
    
    private static final String GAME_TITLE = "FullStackCoder";
    private static final int GAME_WIDTH = 1024;
    private static final int GAME_HEIGHT = 768;
    private static final int FRAME_RATE = 60;
    
    public static void main(String[] args) {
        
        System.setProperty("org.lwjgl.librarypath",
            new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
        
        AppGameContainer appgc;
        
        try {
            
            appgc = new AppGameContainer( new FullStackCoder( GAME_TITLE ));
            appgc.setDisplayMode( GAME_WIDTH,GAME_HEIGHT,false );
            appgc.setTargetFrameRate( FRAME_RATE );
            appgc.start();
            
        } catch( SlickException e) {
            e.printStackTrace();
        }
        
    }
    
}
