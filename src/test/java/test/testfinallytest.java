package test;

import dope.testfinally;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

/**
 * @author 86176
 * @package test
 * @date 2021/2/22 4:19
 */
public class testfinallytest {
    testfinally te;
    @BeforeEach
    public  void  setup(){
        this.te = new testfinally();
    }
    @AfterEach
    public void cleanup(){
        this.te = null;
    }

    @Test
    public  void testttt(){
        assertEquals(true,testfinally.ttt());
        testfinally.ttt();
      }



}
