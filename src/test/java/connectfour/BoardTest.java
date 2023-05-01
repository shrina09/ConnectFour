package connectfour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* This class tests the board classes public methods (it only tests the win method for me 
* because I could not figure the rest out in time)
* @author Shrina
*/


public class BoardTest{
    private Board tester;

    @Before
    public void setup(){
        //set up for the test
        tester = new Board();

    }

    @Test
    public void noWin() {
        
        Assert.assertEquals((tester.winner(0)),false);
    }

    public void winHorizontal() {
        
        Assert.assertEquals((tester.winner(1)),true);
    }

    public void winVertical() {
        
        Assert.assertEquals((tester.winner(2)),true);
    }

    public void winUpDiagonal() {
        
        Assert.assertEquals((tester.winner(3)),true);
    }

    public void winDownDiagonal() {
        
        Assert.assertEquals((tester.winner(4)),true);
    }




}