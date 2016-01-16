package com.devstackio.fullstackcoder.utils;

import java.util.LinkedList;
import java.util.List;

public enum LineGenerator {
    
    INSTANCE;
    
    private int index = 0;
    
    public String[] getStaticLines() {
        List<String> lines0 = new LinkedList();
        lines0.add("Hello! remember to hit ENTER");
        lines0.add("if you get stuck it's more than likely a SPACE");
        lines0.add("enemy animations should be working...");
        return this.convertList( lines0 );
    }
    
    public String[] getLines( ) {
        
        //@Todo - parse this from a .txt or .properties file for levels...
        
        String[] newLines = {};
        
        System.out.println("start index is : " + this.index );
        
        switch( this.index ) {
            case 0:
                List<String> lines0 = new LinkedList();
                lines0.add("YEAH! this one is easy... merry kri mah");
                newLines = this.convertList( lines0 );
                break;

            case 1:
                List<String> lines1 = new LinkedList();
                lines1.add("you made it to the third CodeBlock o_O");
                lines1.add("How many sp3cial { characters }");
                lines1.add("do d0 y0u kn0w ? xD");
                newLines = this.convertList( lines1 );
                break;

            case 2:
                List<String> lines2 = new LinkedList();
                lines2.add("O_O well played...");
                lines2.add("this Block is just to test out...");
                lines2.add("the number of enemies incremented by UNO:");
                lines2.add("hopefully this line has added an enemy to our mob...");
                newLines = this.convertList( lines2 );
                break;

            case 3:
                List<String> lines3 = new LinkedList();
                lines3.add("THIS MEANS IT WORKED !! _ !! _ !!");
                lines3.add("yeAaaAaaaahhhhh!!!!!");
                lines3.add("the next code block is a small demo of the actual game...");
                newLines = this.convertList( lines3 );
                break;

            case 4:
                List<String> lines4 = new LinkedList();
                lines4.add("public static void main(String[] args) {");
                lines4.add("System.out.println(\"I have to remember to add indentation...\");");
                lines4.add("}");
                lines4.add("public void saySomething() {");
                lines4.add("int myInt = 3;");
                lines4.add("System.out.println(\"If it bleeds... we can kill it.\")");
                lines4.add("}");
                newLines = this.convertList( lines4 );
                break;

        }
        
        this.index++;
        
        return newLines;
        
    } 
    
    private String[] convertList ( List<String> lines ) {
        String[] returnobj = new String[ lines.size() ];
        int counter=0;
        for( String str : lines ) {
            returnobj[ counter ] = str;
            counter++;
        }
        return returnobj;
    }
    
}
