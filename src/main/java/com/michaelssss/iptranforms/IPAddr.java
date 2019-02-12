package com.michaelssss.iptranforms;

public class IPAddr {


  private IPAddr() {
  }

  private static long takeCharsequnces2Byte(String reginoIp) {
    reginoIp = reginoIp + ".";
    char[] ipChars = reginoIp.toCharArray();
    MyCharaterContainer integerBits = new MyCharaterContainer();
    MyCharaterContainer stringBuffer = new MyCharaterContainer();
    boolean isParsingNum = false;
    boolean meetSpaceBetweenTwoNum = false;
    for (char c : ipChars) {
      //这里需要做几件事情
      //1. 如果遇上是非数字和dot，检查是否是parsingNum状态
      //    如果是parsingNum状态且char不是dot，则将meetSpaceBetweenTwoNum置为true
      //    如果是parsingNum状态char是dot，则将parsingNum状态置为false,meetSpaceBetweenTwoNum置为false，
      //    且检查解析出来的数字是否在0~255区间段并清空StringBuffer
      //2. 如果遇上是数字则parsingNum状态置为true,
      //    检查meetSpaceBetweenTwoNum状态，若是true则抛处异常
      //    否则将char插入到buffer
      if (isNum(c)) {
        if (meetSpaceBetweenTwoNum) {
          throw new RuntimeException("check Ip Format Failed");
        }
        isParsingNum = true;
        stringBuffer.append(c);
      }
      if (!isNum(c)) {
        if (isParsingNum && !isDot(c)) {
          meetSpaceBetweenTwoNum = true;
        }
        if (isParsingNum && isDot(c)) {
          meetSpaceBetweenTwoNum = false;
          isParsingNum = false;
          int parsedNum = Integer.parseUnsignedInt(stringBuffer.toString(), 10);
          if (!isLegalNum(parsedNum)) {
            throw new RuntimeException("check Ip Format Failed,over big");
          }
          integerBits
              .append(fillZero(Integer.toBinaryString(parsedNum)));
          stringBuffer = new MyCharaterContainer();
        }
      }
    }
    return Long.parseLong(integerBits.toString(), 2);
  }

  private static boolean isDot(char c) {
    return c == '.';
  }

  private static boolean isNum(char c) {
    return c >= '0' && c <= '9';
  }

  private static boolean isLegalNum(int num) {
    return num >= 0 && num <= 255;
  }

  public static long getInteger(String ip) {
    return takeCharsequnces2Byte(ip);
  }

  private static char[] fillZero(String s) {
    char[] chars = "00000000".toCharArray();
    char[] toFillChars = s.toCharArray();
    System.arraycopy(toFillChars, 0, chars, 8 - toFillChars.length, toFillChars.length);
    return chars;
  }
}
