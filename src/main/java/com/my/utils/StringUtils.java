package com.my.utils;

public class StringUtils {

  private StringUtils() {}

  /**
   * Gets the length of a String in null-safe manner.
   *
   * @param str to check the length
   * @return length of String; 0 if null.
   */
  public static int length(final String str) {
    return str == null ? 0 : str.length();
  }

  /**
   * Indicates if String is empty.
   *
   * @param str to check for empty.
   * @return true of empty; false otherwise.
   */
  public static boolean isEmpty(final String str) {
    return str == null || str.isEmpty();
  }
}
