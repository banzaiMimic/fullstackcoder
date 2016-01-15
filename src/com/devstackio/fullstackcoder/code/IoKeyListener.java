package com.devstackio.fullstackcoder.code;

//@Todo might put dispatcher / observer in here to notify super SharedStateGame 

import com.devstackio.fullstackcoder.observer.ActionObserver;
import com.devstackio.fullstackcoder.observer.ActionType;

//@Todo - Base Defender -- http://opengameart.org/content/samurai-animated
public enum IoKeyListener {
    
    INSTANCE;
    
    private ActionObserver actionObserver;
    private CodeBlock codeBlock;
    private CodeLine activeLine;
    
    IoKeyListener() {
        this.actionObserver = ActionObserver.INSTANCE;
    }
    
    public void setCodeBlock( CodeBlock codeBlock ) {
        this.codeBlock = codeBlock;
        this.activeLine = this.codeBlock.getActiveCodeLine();
    }
    
    public void keyPressed(int key, char c) {
        
        System.out.println("pressed int is : " + key);
        System.out.println("pressed char is : " + c );
//        System.out.println("checking vs : " + this.activeLine.getFirstChar());
        if( this.activeLine.getLine().length() > 0 ) {
            //still has characters, test for char match
            if( c == this.activeLine.getFirstChar() ) {
                this.activeLine.hit();
            }
        } else {
            //line is empty, test for 'return' int if codeBlock still has lines...
            
            if ( !this.codeBlock.isComplete() ) {
                
                if ( key == 28 ) {
                    //@Todo - move this to ActionObserver
                    System.out.println("IoKeyListener : sending hit to codeBlock");
                    if( this.codeBlock.hit() ) {
                        this.actionObserver.sendAction( ActionType.LINE_COMPLETE );
                        this.activeLine = this.codeBlock.getActiveCodeLine();
                    } else {
                        this.actionObserver.sendAction( ActionType.BLOCK_COMPLETE );
                        System.out.println("CODE BLOCK COMPLETE!");
                    }
                }
                
            } 

        }
        
        
    }
    
}
