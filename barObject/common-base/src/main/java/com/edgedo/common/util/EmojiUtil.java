package com.edgedo.common.util;

import com.github.binarywang.java.emoji.EmojiConverter;

public class EmojiUtil {
   private static EmojiConverter emojiConverter = EmojiConverter.getInstance();

   public static String emojiConverterUnicodeStr(String emojiStr) {
      String result = emojiConverter.toUnicode(emojiStr);
      return result;
   }

   public static String emojiConverterToAlias(String str) {
      String result = emojiConverter.toAlias(str);
      return result;
   }
}
