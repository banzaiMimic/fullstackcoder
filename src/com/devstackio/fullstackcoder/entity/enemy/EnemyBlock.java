package com.devstackio.fullstackcoder.entity.enemy;

import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.Graphics;

/**
 * Block of enemies - contains List of Enemy entities that will match to active CodeBlock
 * @author devstackio <@devstackioweb>
 */
public class EnemyBlock {
    
    private static Graphics GRAPHIX;
    private float speed=.5f;
    private List<EnemyMold> enemies;
    
    private List<EnemyMold> createCodeLines( String[] lines ) {
        List<EnemyMold> returnobj = new LinkedList();
        int counter=0;
        for ( String line : lines ) {
//            EnemyMold codeLine = new FlyingEnemy();
//            returnobj.add( codeLine );
//            counter++;
        }
        return returnobj;
    }
    
}
