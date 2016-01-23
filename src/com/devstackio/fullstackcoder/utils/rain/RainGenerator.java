package com.devstackio.fullstackcoder.utils.rain;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public enum RainGenerator {
    
    INSTANCE;
    
    private Graphics graphics;
    private List<Rain> rain;
    
    RainGenerator() {
        this.init();
    }
    
    private void init() {
        this.rain = new ArrayList();
        this.rain.add( new Rain() );
    }
    
    public void setGraphics( Graphics gfx ) {
        this.graphics = gfx;
    }
    
    public void draw( ) {
        
        for ( Rain drop : this.rain ) {
            this.graphics.setColor( Color.gray );
            this.graphics.drawLine( drop.getX1(), drop.getY1(), drop.getX2(), drop.getY2() );
        }
        
    }
    
    public void update( int delta ) {
        for ( Rain drop : this.rain ) {
            drop.update( delta );
        }
    }
    
}
