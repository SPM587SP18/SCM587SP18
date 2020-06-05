/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
    import java.io.*;
public class Runtime {


  public static FileInputStream f1(String fileName)
  {
    FileInputStream fis = null;
    try
    {
      fis = new FileInputStream(fileName);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("f1: Oops, FileNotFoundException caught");
      throw new Error("f1: File not found");
    }
    System.out.println("f1: File input stream created");
    return fis;
  }

  public static FileInputStream f2(String fileName)
  {
    FileInputStream fis = null;
    try
    {
      fis = new FileInputStream(fileName);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("f2: Oops, FileNotFoundException caught");
      return fis;
    }
    finally
    {
      System.out.println("f2: finally block");
      return fis;
    }

    // Compiler error: statement not reacheable
    // System.out.println("f2: Returning from f2");
    // return fis;
  }

  public static void main(String args[])
  {
    FileInputStream fis1 = null;
    FileInputStream fis2 = null;
    String fileName = "foo.bar";
    // String fileName = null;

    System.out.println(  "main: Starting " + Runtime.class.getName()
                       + " with file name = " + fileName);

    // get file input stream 1
    try {
      fis1 = f1(fileName);
    }
    catch (Exception ex)
    {
      System.out.println("main: Oops, general exception caught");
    }
    catch (Throwable th)
    {
      System.out.println("main: Oops, throwable object caught");
    }

    // get file input stream 2
    fis2 = f2(fileName);

    System.out.println("main: " + Runtime.class.getName() + " ended");
  }
}


