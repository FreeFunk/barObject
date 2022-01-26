package com.edgedo.common.util;

public class Test {
   public static void main(String[] args) {
      Test.A a = new Test.B();
      System.out.println(a.getClass().getSimpleName());
   }

   public static class B extends Test.A {
   }

   public static class A {
   }
}
