package com.devstackio.fullstackcoder.code;

import com.devstackio.fullstackcoder.Constants;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class CodeLine {
    
    private static final float X_BOUNDS = 200;
    private float speed;
    private String line;
    private Color color;
    private float x;
    private float y;
    private boolean stationary = false;
    
    public CodeLine( String line, float y, float speed ) {
        this.speed = speed;
        this.line = line;
        this.color = Color.white;
        this.y = y;
        this.x = (float) Constants.INSTANCE.getGAME_WIDTH();
    }
    
    public void ioDraw( Graphics g ) {
        System.out.println("----");
        System.out.println("line x is : " + this.x);
        System.out.println("line y is : " + this.y);
        System.out.println("line line is : " + this.line);
        g.drawString( this.line, this.x, this.y );
    }
    
    public void ioUpdate() {
        if ( !this.stationary ) {
            if( this.canMove() ) {
                System.out.println("speed is : " + this.speed);
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
    
}
