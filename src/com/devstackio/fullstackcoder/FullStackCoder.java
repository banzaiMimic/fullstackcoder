package com.devstackio.fullstackcoder;

import com.devstackio.fullstackcoder.audio.AudioControl;
import com.devstackio.fullstackcoder.gamestates.Game;
import com.devstackio.fullstackcoder.gamestates.Menu;
import com.devstackio.fullstackcoder.gamestates.SplashScreen;
import com.devstackio.fullstackcoder.gamestates.tests.CodeBlockTest;
import com.devstackio.fullstackcoder.gamestates.tests.EnemyFlyTest;
import com.devstackio.fullstackcoder.gamestates.tests.FullCodeBlockTest;
import com.devstackio.fullstackcoder.utils.EnemyUtil;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class FullStackCoder extends StateBasedGame {

    // Game state ids
    public static final int SPLASHSCREEN    = 0;
    public static final int MAINMENU        = 1;
    public static final int GAME            = 3;
    public static final int ENEMY_FLY_TEST  = 4;
    public static final int CODE_BLOCK_TEST = 5;
    public static final int FULL_BLOCK_TEST = 6;
    
    public FullStackCoder( String appName ) {
        super( appName );
    }
    
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        
        addState( new SplashScreen() );
        addState( new Menu() );
        addState( new Game() );
        addState( new EnemyFlyTest() );
        addState( new CodeBlockTest() );
        addState( new FullCodeBlockTest() );
        
        this.enterState( MAINMENU );
        AudioControl audioController = new AudioControl();
        audioController.playMusic();
        
    }

}
