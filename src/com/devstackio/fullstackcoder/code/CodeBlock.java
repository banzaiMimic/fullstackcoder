package com.devstackio.fullstackcoder.code;

import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.Graphics;

public class CodeBlock {
    
    private static final float LINE_SPACING = 20;
    private float speed=1;
    private List<CodeLine> codeLines;
    private static Graphics GRAPHIX;
    
    public CodeBlock( Graphics g, String[] lines ) {
        this.codeLines = this.createCodeLines( lines );
        this.speed = 1;
        GRAPHIX = g;
    }
    
    private List<CodeLine> createCodeLines( String[] lines ) {
        List<CodeLine> returnobj = new LinkedList();
        int counter=0;
        for ( String line : lines ) {
            CodeLine codeLine = new CodeLine( line, (counter*LINE_SPACING), this.speed );
            returnobj.add( codeLine );
            counter++;
        }
        return returnobj;
    }
    
    public void ioDraw() {
        for ( CodeLine codeLine : codeLines ) {
            codeLine.ioDraw( GRAPHIX );
        }
    }
    
    public void ioUpdate() {
        for ( CodeLine codeLine : codeLines ) {
            codeLine.ioUpdate();
        }
    }
    
}
