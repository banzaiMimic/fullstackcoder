package com.devstackio.fullstackcoder;

import java.io.File;
import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Application {
    
    public static void main(String[] args) {
        
        System.setProperty("org.lwjgl.librarypath",
            new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
        
        Constants constants = Constants.INSTANCE;
        AppGameContainer appgc;
        
        try {
            
            appgc = new AppGameContainer( new FullStackCoder( constants.getGAME_TITLE() ));
            appgc.setDisplayMode( constants.getGAME_WIDTH(),constants.getGAME_HEIGHT(),false );
            appgc.setVSync( true );
            appgc.setMaximumLogicUpdateInterval(10);
            appgc.setTargetFrameRate( constants.getFRAME_RATE() );
            
            appgc.start();
            
        } catch( SlickException e) {
            e.printStackTrace();
        }
        
    }
    
}
