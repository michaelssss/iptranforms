package com.michaelssss.iptranforms;

import org.junit.Assert;
import org.junit.Test;

public class IPAddrTest {

  @Test
  public void testNormalIp() {
    String rightIp = "172.168.5.1";
    Assert.assertEquals(2896692481L, IPAddr.getInteger(rightIp));
  }

  @Test(expected = RuntimeException.class)
  public void testFalseIp() {
    String falseIp = "17 2.168.5.1";
    IPAddr.getInteger(falseIp);
  }

  @Test(expected = RuntimeException.class)
  public void testFalseIp1() {
    String falseIp = "333.168.5.1";
    IPAddr.getInteger(falseIp);
  }

  @Test
  public void testContainSpaceButRightIp() {
    String containSpaceIp = "172 .168.5.1";
    Assert.assertEquals(2896692481L, IPAddr.getInteger(containSpaceIp));
  }

  @Test
  public void testContainSpaceButRightIp2() {
    String containSpaceIp = " 172.168.5.1";
    Assert.assertEquals(2896692481L, IPAddr.getInteger(containSpaceIp));
  }

  @Test
  public void testContainSpaceButRightIp3() {
    String containSpaceIp = "172 . 168.5.1";
    Assert.assertEquals(2896692481L, IPAddr.getInteger(containSpaceIp));
  }

}
