package com.michaelssss.iptranforms;

public class MyCharaterContainer {

  private char[] chars;
  private int index;

  public MyCharaterContainer() {
    chars = new char[8];
    index = 0;
  }

  public void append(char[] cs) {
    for (char c : cs) {
      append(c);
    }
  }

  public void append(char c) {
    if (index == chars.length) {
      resize();
    }
    chars[index] = c;
    index++;
  }

  private void resize() {
    char[] newCharArray = new char[chars.length * 2];
    System.arraycopy(chars, 0, newCharArray, 0, index);
    chars = newCharArray;
  }

  @Override
  public String toString() {
    char[] chars = new char[this.index + 1];
    chars[0] = '+';
    System.arraycopy(this.chars, 0, chars, 1, this.index);
    return new String(chars);
  }

}
