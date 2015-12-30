package com.devstackio.fullstackcoder.code;

import com.devstackio.fullstackcoder.Constants;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class CodeLine {
    
    private static final float X_BOUNDS = 200;
    private float speed;
    private float x;
    private float y;
    private boolean stationary = false;
    private String line;
    private Color color;
    
    public CodeLine( String line, float y, float speed ) {
        this.speed = speed;
        this.line = line;
        this.color = Color.white;
        this.y = y;
        this.x = (float) Constants.INSTANCE.getGAME_WIDTH();
    }
    
    public void ioDraw( Graphics g ) {
        g.drawString( this.line, this.x, this.y );
    }
    
    public void ioUpdate() {
        if ( !this.stationary ) {
            if( this.canMove() ) {
                this.x-= this.speed;
            } else {
                this.stationary = true;
            }
        }
    }
    
    public String getLine() {
        return this.line;
    }
    
    private boolean canMove() {
        return ( this.x >= X_BOUNDS ) ? true : false;
    }
    
    public char getFirstChar() {
        try {
            
            if( this.line.length() > 0 ) {
                return this.line.charAt(0);
            }
            
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return ' ';
    }
    
    /**
     * user pressed correct key, remove first char from line
     */
    public void hit() {
        int len = this.line.length();
        if( len > 0 ) {
            this.line = this.line.substring(1,len);
        }
    }
    
    public float getX() {
        return this.x;
    }
    
}
