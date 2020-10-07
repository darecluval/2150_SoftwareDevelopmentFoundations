/*package cpsc2150.Speedster;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSpeedster {

    private final double EXPT_ERROR = 0.0;

    //Testing the constructor (1/1)
    @Test
    public void testConstructor_Empty() {

        DirectionalSpeedster DS = new DirectionalSpeedster();

        double foundDist = DS.getNetDistance();
        double expectedDist = 0.0;

        assertTrue((expectedDist - foundDist) == EXPT_ERROR);
    }






    //ADD TRAVEL
    //Testing addTravel (1/10)
    @Test
    public void test_addTravel_x2pt5_y3pt0_t0_timeBoundary() {

        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 0.0;

        DS.addTravel(x, y, t);

        double foundTime = DS.getTotalTime();
        double expectedTime = 0.0;

        assertTrue((expectedTime - foundTime) == EXPT_ERROR);
    }

    //Testing addTravel (2/10)
    @Test
    public void test_addTravel_totalDist() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double foundTotDist = x + y;
        double exptTotDist = DS.getTotalDistance();

        assertTrue((exptTotDist - foundTotDist) == EXPT_ERROR);

    }

    //Testing addTravel (3/10)
    @Test
    public void test_addTravel_posXposX() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundXPos = DS.getCurXPos();
        double expectedXPos = x + x2;

        assertTrue((expectedXPos - foundXPos) == EXPT_ERROR);

    }

    //Testing addTravel (4/10)
    @Test
    public void test_addTravel_posYposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundYPos = DS.getCurYPos();
        double expectedYPos = y + y2;

        assertTrue((expectedYPos - foundYPos) == EXPT_ERROR);
    }

    //Testing addTravel (5/10)
    @Test
    public void test_addTravel_posXnegX() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = -2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundXPos = DS.getCurXPos();
        double expectedXPos = x + x2;

        assertTrue((expectedXPos - foundXPos) == EXPT_ERROR);

    }

    //Testing addTravel (6/10)
    @Test
    public void test_addTravel_posYnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = -3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundYPos = DS.getCurYPos();
        double expectedYPos = y + y2;

        assertTrue((expectedYPos - foundYPos) == EXPT_ERROR);
    }

    //Testing addTravel (7/10)
    @Test
    public void test_addTravel_negXnegX() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = -2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundXPos = DS.getCurXPos();
        double expectedXPos = x + x2;

        assertTrue((expectedXPos - foundXPos) == EXPT_ERROR);
    }

    //Testing addTravel (8/10)
    @Test
    public void test_addTravel_negYnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = -3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundYPos = DS.getCurYPos();
        double expectedYPos = y + y2;

        assertTrue((expectedYPos - foundYPos) == EXPT_ERROR);
    }

    //Testing addTravel (9/10)
    @Test
    public void test_addTravel_negXposX() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundXPos = DS.getCurXPos();
        double expectedXPos = x + x2;

        assertTrue((expectedXPos - foundXPos) == EXPT_ERROR);
    }

    //Testing addTravel (10/10)
    @Test
    public void test_addTravel_negYposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundYPos = DS.getCurYPos();
        double expectedYPos = y + y2;

        assertTrue((expectedYPos - foundYPos) == EXPT_ERROR);
    }






    //GET TOTAL DISTANCE
    //Testing getTotalDistance (1/5)
    @Test
    public void test_getTotalDistance_posXposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundTotDist = DS.getTotalDistance();
        double expectedTotDist = x + y + x2 + y2;

        assertTrue((expectedTotDist - foundTotDist) == EXPT_ERROR);
    }

    //Testing getTotalDistance (2/5)
    @Test
    public void test_getTotalDistance_posXnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = -3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundTotDist = DS.getTotalDistance();
        double expectedTotDist = x + y + x2 + y2;

        assertTrue((expectedTotDist - foundTotDist) == EXPT_ERROR);
    }

    //Testing getTotalDistance (3/5)
    @Test
    public void test_getTotalDistance_negXposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = -2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundTotDist = DS.getTotalDistance();
        double expectedTotDist = x + y + x2 + y2;

        assertTrue((expectedTotDist - foundTotDist) == EXPT_ERROR);
    }

    //Testing getTotalDistance (4/5)
    @Test
    public void test_getTotalDistance_negXnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = -2.5;
        double y2 = -3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundTotDist = DS.getTotalDistance();
        double expectedTotDist = x + y + x2 + y2;

        assertTrue((expectedTotDist - foundTotDist) == EXPT_ERROR);
    }

    //Testing getTotalDistance (5/5)
    @Test
    public void test_getTotalDistance_Empty() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 0.0;
        double y = 0.0;
        double t = 0.0;

        DS.addTravel(x, y, t);

        double x2 = 0.0;
        double y2 = 0.0;
        double t2 = 0.0;

        DS.addTravel(x2, y2, t2);

        double foundTotDist = DS.getTotalDistance();
        double expectedTotDist = x + y + x2 + y2;

        assertTrue((expectedTotDist - foundTotDist) == EXPT_ERROR);
    }





    //GET NET DISTANCE
    //Testing getNetDistance (1/5)
    @Test
    public void test_getNetDistance_posXposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double foundNetDist = DS.getNetDistance();
        double expectedNetDis = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

        assertTrue((expectedNetDis - foundNetDist) == EXPT_ERROR);
    }

    //Testing getNetDistance (2/5)
    @Test
    public void test_getNetDistance_posXnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double foundNetDist = DS.getNetDistance();
        double expectedNetDis = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

        assertTrue((expectedNetDis - foundNetDist) == EXPT_ERROR);
    }

    //Testing getNetDistance (3/5)
    @Test
    public void test_getNetDistance_negXposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double foundNetDist = DS.getNetDistance();
        double expectedNetDis = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

        assertTrue((expectedNetDis - foundNetDist) == EXPT_ERROR);
    }

    //Testing getNetDistance (4/5)
    @Test
    public void test_getNetDistance_negXnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double foundNetDist = DS.getNetDistance();
        double expectedNetDis = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

        assertTrue((expectedNetDis - foundNetDist) == EXPT_ERROR);
    }

    //Testing getNetDistance (5/5)
    @Test
    public void test_getNetDistance_Empty() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 0.0;
        double y = 0.0;
        double t = 0.0;

        DS.addTravel(x, y, t);

        double foundNetDist = DS.getNetDistance();
        double expectedNetDis = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

        assertTrue((expectedNetDis - foundNetDist) == EXPT_ERROR);
    }





    //GER AVERAGE SPEED
    //Testing getAverageSpeed (1/5)
    @Test
    public void test_getAverageSpeed_1() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }

    //Testing getAverageSpeed (2/5)
    @Test
    public void test_getAverageSpeed_2() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }

    //Testing getAverageSpeed (3/5)
    @Test
    public void test_getAverageSpeed_3() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }

    //Testing getAverageSpeed (4/5)
    @Test
    public void test_getAverageSpeed_4() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }

    //Testing getAverageSpeed (5/5)
    @Test
    public void test_getAverageSpeed_5() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }





    //GET NET SPEED
    //Testing getNetSpeed (1/5)
    @Test
    public void test_getNetSpeed_1() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }

    //Testing getNetSpeed (2/5)
    @Test
    public void test_getNetSpeed_2() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }

    //Testing getNetSpeed (3/5)
    @Test
    public void test_getNetSpeed_3() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }

    //Testing getNetSpeed (4/5)
    @Test
    public void test_getNetSpeed_4() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }

    //Testing getNetSpeed (5/5)
    @Test
    public void test_getNetSpeed_5() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }

}*/

package cpsc2150.Speedster;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSpeedster {

    private final double EXPT_ERROR = 0.0;

    //Testing the constructor (1/1)
    @Test
    public void testConstructor_Empty() {

        DirectionalSpeedster DS = new DirectionalSpeedster();

        double foundDist = DS.getNetDistance();
        double expectedDist = 0.0;

        assertTrue((expectedDist - foundDist) == EXPT_ERROR);
    }






    //ADD TRAVEL
    //Testing addTravel (1/10)
    @Test
    public void test_addTravel_x2pt5_y3pt0_t0_timeBoundary() {

        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 0.0;

        DS.addTravel(x, y, t);

        double foundTime = DS.getTotalTime();
        double expectedTime = 0.0;

        assertTrue((expectedTime - foundTime) == EXPT_ERROR);
    }

    //Testing addTravel (2/10)
    @Test
    public void test_addTravel_totalDist() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double foundTotDist = x + y;
        double exptTotDist = DS.getTotalDistance();

        assertTrue((exptTotDist - foundTotDist) == EXPT_ERROR);

    }

    //Testing addTravel (3/10)
    @Test
    public void test_addTravel_posXposX() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundXPos = DS.getCurXPos();
        double expectedXPos = x + x2;

        assertTrue((expectedXPos - foundXPos) == EXPT_ERROR);

    }

    //Testing addTravel (4/10)
    @Test
    public void test_addTravel_posYposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundYPos = DS.getCurYPos();
        double expectedYPos = y + y2;

        assertTrue((expectedYPos - foundYPos) == EXPT_ERROR);
    }

    //Testing addTravel (5/10)
    @Test
    public void test_addTravel_posXnegX() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = -2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundXPos = DS.getCurXPos();
        double expectedXPos = x + x2;

        assertTrue((expectedXPos - foundXPos) == EXPT_ERROR);

    }

    //Testing addTravel (6/10)
    @Test
    public void test_addTravel_posYnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = -3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundYPos = DS.getCurYPos();
        double expectedYPos = y + y2;

        assertTrue((expectedYPos - foundYPos) == EXPT_ERROR);
    }

    //Testing addTravel (7/10)
    @Test
    public void test_addTravel_negXnegX() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = -2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundXPos = DS.getCurXPos();
        double expectedXPos = x + x2;

        assertTrue((expectedXPos - foundXPos) == EXPT_ERROR);
    }

    //Testing addTravel (8/10)
    @Test
    public void test_addTravel_negYnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = -3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundYPos = DS.getCurYPos();
        double expectedYPos = y + y2;

        assertTrue((expectedYPos - foundYPos) == EXPT_ERROR);
    }

    //Testing addTravel (9/10)
    @Test
    public void test_addTravel_negXposX() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundXPos = DS.getCurXPos();
        double expectedXPos = x + x2;

        assertTrue((expectedXPos - foundXPos) == EXPT_ERROR);
    }

    //Testing addTravel (10/10)
    @Test
    public void test_addTravel_negYposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundYPos = DS.getCurYPos();
        double expectedYPos = y + y2;

        assertTrue((expectedYPos - foundYPos) == EXPT_ERROR);
    }






    //GET TOTAL DISTANCE
    //Testing getTotalDistance (1/5)
    @Test
    public void test_getTotalDistance_posXposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundTotDist = DS.getTotalDistance();
        double expectedTotDist = x + y + x2 + y2;

        assertTrue((expectedTotDist - foundTotDist) == EXPT_ERROR);
    }

    //Testing getTotalDistance (2/5)
    @Test
    public void test_getTotalDistance_posXnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = 2.5;
        double y2 = -3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundTotDist = DS.getTotalDistance();
        double expectedTotDist = x + y + x2 + y2;

        assertTrue((expectedTotDist - foundTotDist) == EXPT_ERROR);
    }

    //Testing getTotalDistance (3/5)
    @Test
    public void test_getTotalDistance_negXposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = -2.5;
        double y2 = 3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundTotDist = DS.getTotalDistance();
        double expectedTotDist = x + y + x2 + y2;

        assertTrue((expectedTotDist - foundTotDist) == EXPT_ERROR);
    }

    //Testing getTotalDistance (4/5)
    @Test
    public void test_getTotalDistance_negXnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double x2 = -2.5;
        double y2 = -3.0;
        double t2 = 10.0;

        DS.addTravel(x2, y2, t2);

        double foundTotDist = DS.getTotalDistance();
        double expectedTotDist = x + y + x2 + y2;

        assertTrue((expectedTotDist - foundTotDist) == EXPT_ERROR);
    }

    //Testing getTotalDistance (5/5)
    @Test
    public void test_getTotalDistance_Empty() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 0.0;
        double y = 0.0;
        double t = 0.0;

        DS.addTravel(x, y, t);

        double x2 = 0.0;
        double y2 = 0.0;
        double t2 = 0.0;

        DS.addTravel(x2, y2, t2);

        double foundTotDist = DS.getTotalDistance();
        double expectedTotDist = x + y + x2 + y2;

        assertTrue((expectedTotDist - foundTotDist) == EXPT_ERROR);
    }





    //GET NET DISTANCE
    //Testing getNetDistance (1/5)
    @Test
    public void test_getNetDistance_posXposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double foundNetDist = DS.getNetDistance();
        double expectedNetDis = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

        assertTrue((expectedNetDis - foundNetDist) == EXPT_ERROR);
    }

    //Testing getNetDistance (2/5)
    @Test
    public void test_getNetDistance_posXnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double foundNetDist = DS.getNetDistance();
        double expectedNetDis = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

        assertTrue((expectedNetDis - foundNetDist) == EXPT_ERROR);
    }

    //Testing getNetDistance (3/5)
    @Test
    public void test_getNetDistance_negXposY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = 3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double foundNetDist = DS.getNetDistance();
        double expectedNetDis = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

        assertTrue((expectedNetDis - foundNetDist) == EXPT_ERROR);
    }

    //Testing getNetDistance (4/5)
    @Test
    public void test_getNetDistance_negXnegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -2.5;
        double y = -3.0;
        double t = 10.0;

        DS.addTravel(x, y, t);

        double foundNetDist = DS.getNetDistance();
        double expectedNetDis = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

        assertTrue((expectedNetDis - foundNetDist) == EXPT_ERROR);
    }

    //Testing getNetDistance (5/5)
    @Test
    public void test_getNetDistance_Empty() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 0.0;
        double y = 0.0;
        double t = 0.0;

        DS.addTravel(x, y, t);

        double foundNetDist = DS.getNetDistance();
        double expectedNetDis = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

        assertTrue((expectedNetDis - foundNetDist) == EXPT_ERROR);
    }





    //GER AVERAGE SPEED
    //Testing getAverageSpeed (1/5)
    @Test
    public void test_getAverageSpeed_Empty() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 0.0;
        double y = 0.0;
        double t = 5.0;

        DS.addTravel(x, y, t);


        double foundAvgSpeed  = DS.getAverageSpeed();
        double expectedAvgSpeed  = (x + y)/(t);

        assertTrue((expectedAvgSpeed  - foundAvgSpeed ) == EXPT_ERROR);

    }

    //Testing getAverageSpeed (2/5)
    @Test
    public void test_getAverageSpeed_EmptyNeg() {
        DirectionalSpeedster DS = new DirectionalSpeedster();


        double x = -6.5;
        double y = -7.0;
        double t = 10.0;

        DS.addTravel(x, y, t);


        double foundAvgSpeed = DS.getAverageSpeed();
        System.out.println(foundAvgSpeed);
        double expectedAvgSpeed = (x+y) / (t);
        System.out.println(expectedAvgSpeed );


        assertTrue((expectedAvgSpeed  - foundAvgSpeed ) == EXPT_ERROR);

    }

    //Testing getAverageSpeed (3/5)
    @Test
    public void test_getAverageSpeed_PosXNegX() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 4.0;
        double y = 8.5;
        double t = 7.0;

        DS.addTravel(x, y, t);

        double x2 = -6.5;
        double y2 = 7.0;
        double t2 = 14.50;

        DS.addTravel(x2, y2, t2);


        double foundAvgSpeed  = DS.getAverageSpeed();
        double expectedAvgSpeed  = ((x+x2) + (y+y2))/(t+t2);

        assertTrue((expectedAvgSpeed  - foundAvgSpeed ) == EXPT_ERROR);

    }

    //Testing getAverageSpeed (4/5)
    @Test
    public void test_getAverageSpeed_PosYNegY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 12.0;
        double y = 6.5;
        double t = 3.0;

        DS.addTravel(x, y, t);

        double x2 = 6.5;
        double y2 = -7.0;
        double t2 = 5.50;

        DS.addTravel(x2, y2, t2);


        double foundAvgSpeed  = DS.getAverageSpeed();
        double expectedAvgSpeed  = ((x+x2) + (y+y2))/(t+t2);

        assertTrue((expectedAvgSpeed  - foundAvgSpeed ) == EXPT_ERROR);

    }

    //Testing getAverageSpeed (5/5)
    @Test
    public void test_getAverageSpeed_PosXYPosXY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 9.0;
        double y = 9.0;
        double t = 4.0;

        DS.addTravel(x, y, t);

        double x2 = 6.5;
        double y2 = 7.0;
        double t2 = 14.50;

        DS.addTravel(x2, y2, t2);


        double foundAvgSpeed  = DS.getAverageSpeed();
        double expectedAvgSpeed  = ((x+x2) + (y+y2))/(t+t2);

        assertTrue((expectedAvgSpeed  - foundAvgSpeed ) == EXPT_ERROR);

    }





    //GET NET SPEED
    //Testing getNetSpeed (1/5)
    @Test
    public void test_getNetSpeed_NegXYNegXY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -8.0;
        double y = -4.0;
        double t = 3.0;

        DS.addTravel(x, y, t);

        double x2 = -6.5;
        double y2 = -7.0;
        double t2 = 7.50;

        DS.addTravel(x2, y2, t2);


        double foundNetSpeed = DS.getNetSpeed();
        System.out.println(foundNetSpeed);
        double expectedNetSpeed = (Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5))+(Math.pow((Math.pow(x2, 2) + Math.pow(y2, 2)), 0.5))/(t+t2);
        System.out.println(expectedNetSpeed);


        assertTrue((expectedNetSpeed - foundNetSpeed) == EXPT_ERROR);


    }

    //Testing getNetSpeed (2/5)
    @Test
    public void test_getNetSpeed_PosXYNegXY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 8.0;
        double y = 4.0;
        double t = 3.0;

        DS.addTravel(x, y, t);

        double x2 = -6.5;
        double y2 = -7.0;
        double t2 = 7.50;

        DS.addTravel(x2, y2, t2);


        double foundNetSpeed = DS.getNetSpeed();
        double expectedNetSpeed = (Math.pow((Math.pow(x+x2, 2) + Math.pow(y+y2, 2)), 0.5))/(t+t2);

        assertTrue((expectedNetSpeed - foundNetSpeed) == EXPT_ERROR);


    }

    //Testing getNetSpeed (3/5)
    @Test
    public void test_getNetSpeed_NegXYEmptyXY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = -8.0;
        double y = -4.0;
        double t = 3.0;

        DS.addTravel(x, y, t);

        double x2 = 0.0;
        double y2 = 0.0;
        double t2 = 0.0;

        DS.addTravel(x2, y2, t2);


        double foundNetSpeed = DS.getNetSpeed();
        double expectedNetSpeed = (Math.pow((Math.pow(x+x2, 2) + Math.pow(y+y2, 2)), 0.5))/(t+t2);

        assertTrue((expectedNetSpeed - foundNetSpeed) == EXPT_ERROR);


    }

    //Testing getNetSpeed (4/5)
    @Test
    public void test_getNetSpeed_PosXYEmptyXY() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

        double x = 8.0;
        double y = 4.0;
        double t = 3.0;

        DS.addTravel(x, y, t);

        double x2 = 0.0;
        double y2 = 0.0;
        double t2 = 0.0;

        DS.addTravel(x2, y2, t2);


        double foundNetSpeed = DS.getNetSpeed();
        double expectedNetSpeed = (Math.pow((Math.pow(x+x2, 2) + Math.pow(y+y2, 2)), 0.5))/(t+t2);

        assertTrue((expectedNetSpeed - foundNetSpeed) == EXPT_ERROR);


    }


    //Testing getNetSpeed (5/5)
    @Test
    public void test_getNetSpeed_5() {
        DirectionalSpeedster DS = new DirectionalSpeedster();

    }

}

