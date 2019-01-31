package com.michaelssss.iptranforms;

import org.junit.Assert;
import org.junit.Test;

public class IPAddrTest {

  @Test
  public void testNormalIp() {
    String rightIp = "172.168.5.1";
    IPAddr ipAddr = IPAddr.newInstance(rightIp);
    Assert.assertEquals(2896692481L, ipAddr.getInteger());
  }

  @Test(expected = RuntimeException.class)
  public void testFalseIp() {
    String falseIp = "17 2.168.5.1";
    IPAddr.newInstance(falseIp);
  }

  @Test
  public void testContainSpaceButRightIp() {
    String containSpaceIp = "172 .168.5.1";
    IPAddr ipAddr = IPAddr.newInstance(containSpaceIp);
    Assert.assertEquals(2896692481L, ipAddr.getInteger());
  }
  @Test
  public void testContainSpaceButRightIp2() {
    String containSpaceIp = " 172.168.5.1";
    IPAddr ipAddr = IPAddr.newInstance(containSpaceIp);
    Assert.assertEquals(2896692481L, ipAddr.getInteger());
  }
  @Test
  public void testContainSpaceButRightIp3() {
    String containSpaceIp = "172 . 168.5.1";
    IPAddr ipAddr = IPAddr.newInstance(containSpaceIp);
    Assert.assertEquals(2896692481L, ipAddr.getInteger());
  }
}
