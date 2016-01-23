package com.devstackio.fullstackcoder.utils.rain;

import com.devstackio.fullstackcoder.Constants;

public class Rain {
    
    private float x;
    private float x1;
    private float y1;
    private float x2;
    private float y2;
    private float xVelocity;
    private float yVelocity;
    
    public Rain() {
        this.initLoc();
        this.xVelocity= -.1f;
    }
    
    private void initLoc () {
        this.x = 0f;
        this.x1 = 5+ Constants.INSTANCE.getDEFENDER_X();
        this.y1 = 5+ Constants.INSTANCE.getDEFENDER_Y();
        this.x2 = 25+ Constants.INSTANCE.getDEFENDER_X();;
        this.y2 = 25+ Constants.INSTANCE.getDEFENDER_Y();
    }
    
    public void update( int delta ) {
        this.x1+=this.x;
        this.x2+=this.x;
        
        this.x+= xVelocity*delta;
        
        if ( this.x <= -26 ) {
            this.initLoc();
        }
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x) {
        this.x1 = x;
    }

    public float getY1() {
        return y1;
    }

    public void setY1(float y) {
        this.y1 = y;
    }

    public float getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public float getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }

    public float getX2() {
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public float getY2() {
        return y2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public void setX(float x) {
        this.x = x;
    }
    
    public float getX() {
        return this.x;
    }
    
}
