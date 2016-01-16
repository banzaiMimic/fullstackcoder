package com.devstackio.fullstackcoder.code;

import com.devstackio.fullstackcoder.Constants;
import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.Graphics;

public class CodeBlock {
    
    private static final float LINE_SPACING = 20;
    private List<CodeLine> codeLines;
    private static Graphics GRAPHIX;
    private int activeLine=0;
    
    public CodeBlock( Graphics g, String[] lines ) {
        this.codeLines = this.createCodeLines( lines );
        GRAPHIX = g;
    }
    
    public CodeLine getActiveCodeLine() {
        return this.codeLines.get( this.activeLine );
    }
    
    public int getActiveLine() {
        return this.activeLine;
    }
    
    private List<CodeLine> createCodeLines( String[] lines ) {
        List<CodeLine> returnobj = new LinkedList();
        int counter=0;
        for ( String line : lines ) {
            CodeLine codeLine = new CodeLine( line, (counter*LINE_SPACING), Constants.INSTANCE.getBASE_CODE_SPEED() );
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
    
    public boolean isComplete() {
        System.out.println("stillhaslines --");
        System.out.println("activeLine is : " + this.activeLine);
        System.out.println("codeLines size : " + this.codeLines.size());
        return this.activeLine == this.codeLines.size();
    }
    
    /**
     * user has completed a line successfully
     * @return true if there are still lines left
     */
    public boolean hit() {
        this.activeLine++;
        return this.activeLine < this.codeLines.size();
    }
    
    public float getX() {
        return this.getActiveCodeLine().getX();
    }
    
}
