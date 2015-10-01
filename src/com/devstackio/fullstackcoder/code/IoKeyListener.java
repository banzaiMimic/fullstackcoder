package com.devstackio.fullstackcoder.code;

public enum IoKeyListener {
    
    INSTANCE;
    
    private CodeBlock codeBlock;
    private CodeLine activeLine;
    
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
                    System.out.println("SENDING HIT TO CODEBLOCK");
                    if( this.codeBlock.hit() ) {
                        this.activeLine = this.codeBlock.getActiveCodeLine();
                    } else {
                        System.out.println("CODE BLOCK COMPLETE!");
                    }
                }
                
            } 

        }
        
        
    }
    
}
