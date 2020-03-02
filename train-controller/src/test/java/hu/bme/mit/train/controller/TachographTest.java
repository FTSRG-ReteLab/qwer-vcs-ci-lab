package hu.bme.mit.train.controller;

import org.junit.*;

public class TachographTest {

  @Test
  public void test_tach() {
    Tachograph t = new Tachograph();
    t.put(123,0.123,0.1);
    double rspeed = t.get(123,0.123);
    Assert.assertEquals(rspeed, 0.1, 0.1);
  }

}
