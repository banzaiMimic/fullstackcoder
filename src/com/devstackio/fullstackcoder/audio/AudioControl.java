package com.devstackio.fullstackcoder.audio;

import org.newdawn.slick.Music;

public class AudioControl {
    
    private Music music;
    
    public AudioControl() {
        try {
            this.music = new Music("data/music/03_Chibi_Ninja.ogg");
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
    
    public void playMusic() {
        System.out.println("-- playing music... ");
        this.music.loop();
    }
    
    public void stopMusic() {
        this.music.stop();
    }
    
}
