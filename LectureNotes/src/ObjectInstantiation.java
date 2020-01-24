/*
 * Jonathan Limpus 
 * CSCI 230 Lecture Notes
 * 01/21/20 
 */
package LectureNotes; 

public class ObjectInstantiation{
    private static int someStaticMember;
    private static void someFun() {

    }

    private void nonStaticFun(){}

    ObjectInstantiation(){

    }

    public static void main(String args[]) {
        someStaticMember = 7; 
        someFun();
    }
}