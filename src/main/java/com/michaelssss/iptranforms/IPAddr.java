package com.michaelssss.iptranforms;

import java.util.ArrayList;
import java.util.List;

public class IPAddr {

  private List<Integer> ip;

  private IPAddr() {
  }

  public static IPAddr newInstance(String reginoIp) {
    IPAddr ipAddr = new IPAddr();
    ipAddr.ip = isValidatedStringIp(reginoIp);
    return ipAddr;
  }

  private static List<Integer> isValidatedStringIp(String reginoIp) {
    List<Integer> ip = new ArrayList<>();
    String[] splitByDot = reginoIp.split("\\.");
    try {
      for (String fourByte : splitByDot) {
        ip.add(Integer.parseInt(fourByte.trim()));
      }
    } catch (NumberFormatException e) {
      throw new RuntimeException("check Ip Format Failed");
    }
    return ip;
  }

  public long getInteger() {
    StringBuffer stringBuffer = new StringBuffer();
    for (Integer integer : this.ip) {
      stringBuffer.append(fillZero(Integer.toBinaryString(integer)));
    }
    return Long.parseLong(stringBuffer.toString(), 2);
  }

  private String fillZero(String s) {
    char[] chars = "00000000".toCharArray();
    char[] toFillChars = new StringBuffer(s).reverse().toString().toCharArray();
    for (int i = 0; i < toFillChars.length; i++) {
      chars[i] = toFillChars[i];
    }
    return new StringBuffer(new String(chars)).reverse().toString();
  }
}
