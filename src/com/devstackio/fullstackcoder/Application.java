package com.devstackio.fullstackcoder;

import java.io.File;
import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Application {
    
    public static void main(String[] args) {
        
        System.setProperty("org.lwjgl.librarypath",
            new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
        
        AppGameContainer appgc;
        
        try {
            
            appgc = new AppGameContainer( new FullStackCoder("FullStackCoder"));
            appgc.setDisplayMode(1024,768,false);
            appgc.setTargetFrameRate(60);
            appgc.start();
            
        } catch( SlickException e) {
            e.printStackTrace();
        }
        
    }
    
}
