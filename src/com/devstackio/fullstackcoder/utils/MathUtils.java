package com.devstackio.fullstackcoder.utils;

import java.util.Random;

public enum MathUtils {
    
    INSTANCE;
    
    private Random random;
    
    MathUtils() {
        this.random = new Random();
    }
    
    public float getRandom( float min, float max ) {
        return min + random.nextFloat() * (max - min);
    }
    
}
