package com.selonj.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import sun.misc.BASE64Decoder;

/**
 * Created by Administrator on 2016-04-25.
 */
public class PEM {
  public static byte[] from(String uri) throws IOException {
    return new BASE64Decoder().decodeBuffer(content(uri));
  }

  public static String content(String uri) throws IOException {
    return content(ClassLoader.getSystemResourceAsStream(uri));
  }

  public static String content(InputStream source) throws IOException {
    return content(new InputStreamReader(source, "UTF-8"));
  }

  public static String content(InputStreamReader source2) throws IOException {
    BufferedReader in = new BufferedReader(source2);
    StringWriter out = new StringWriter();
    for (String line; (line = in.readLine()) != null; ) {
      if (isACommentLine(line)) continue;
      out.write(line);
    }
    return out.toString();
  }

  private static boolean isACommentLine(String line) {
    return line.startsWith("--");
  }
}
