/*
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.taglibs.standard.lang.jstl.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.jsp.JspException;

import org.apache.taglibs.standard.lang.jstl.Evaluator;

/**
 *
 * <p>This runs a series of tests specifically for the parser.  It
 * parses various expressions and prints out the canonical
 * representation of those parsed expressions.
 *
 * <p>The expressions are stored in an input text file, with one line
 * per expression.  Blank lines and lines that start with # are
 * ignored.  The results are written to an output file (blank lines
 * and # lines are included in the output file).  The output file may
 * be compared against an existing output file to do regression
 * testing.
 * 
 * @author Nathan Abramson - Art Technology Group
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public class ParserTest
{
  //-------------------------------------
  // Properties
  //-------------------------------------

  //-------------------------------------
  // Member variables
  //-------------------------------------

  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public ParserTest ()
  {
  }

  //-------------------------------------
  /**
   *
   * Runs the tests, reading expressions from pIn and writing the
   * results to pOut.
   **/
  public static void runTests (DataInput pIn,
			       PrintStream pOut)
    throws IOException
  {
    while (true) {
      String str = pIn.readLine ();
      if (str == null) break;
      if (str.startsWith ("#") ||
	  "".equals (str.trim ())) {
	pOut.println (str);
      }
      else {
	// For testing non-ASCII values, the string @@non-ascii gets
	// converted internally to '\u1111'
	if ("@@non-ascii".equals (str)) {
	  str = "\u1111";
	}

	pOut.println ("Attribute value: " + str);
	try {
	  String result = Evaluator.parseAndRender (str);
	  pOut.println ("Parses to: " + result);
	}
	catch (JspException exc) {
	  pOut.println ("Causes an error: " + exc.getMessage ());
	}
      }
    }

  }

  //-------------------------------------
  /**
   *
   * Runs the tests, reading from the given input file and writing to
   * the given output file.
   **/
  public static void runTests (File pInputFile,
			       File pOutputFile)
    throws IOException
  {
    FileInputStream fin = null;
    FileOutputStream fout = null;
    try {
      fin = new FileInputStream (pInputFile);
      BufferedInputStream bin = new BufferedInputStream (fin);
      DataInputStream din = new DataInputStream (bin);

      try {
	fout = new FileOutputStream (pOutputFile);
	BufferedOutputStream bout = new BufferedOutputStream (fout);
	PrintStream pout = new PrintStream (bout);

	runTests (din, pout);

	pout.flush ();
      }
      finally {
	if (fout != null) {
	  fout.close ();
	}
      }
    }
    finally {
      if (fin != null) {
	fin.close ();
      }
    }
  }

  //-------------------------------------
  /**
   *
   * Performs a line-by-line comparison of the two files, returning
   * true if the files are different, false if not.
   **/
  public static boolean isDifferentFiles (DataInput pIn1,
					  DataInput pIn2)
    throws IOException
  {
    while (true) {
      String str1 = pIn1.readLine ();
      String str2 = pIn2.readLine ();
      if (str1 == null &&
	  str2 == null) {
	return false;
      }
      else if (str1 == null ||
	       str2 == null) {
	return true;
      }
      else {
	if (!str1.equals (str2)) {
	  return true;
	}
      }
    }
  }

  //-------------------------------------
  /**
   *
   * Performs a line-by-line comparison of the two files, returning
   * true if the files are different, false if not.
   **/
  public static boolean isDifferentFiles (File pFile1,
					  File pFile2)
    throws IOException
  {
    FileInputStream fin1 = null;
    try {
      fin1 = new FileInputStream (pFile1);
      BufferedInputStream bin1 = new BufferedInputStream (fin1);
      DataInputStream din1 = new DataInputStream (bin1);

      FileInputStream fin2 = null;
      try {
	fin2 = new FileInputStream (pFile2);
	BufferedInputStream bin2 = new BufferedInputStream (fin2);
	DataInputStream din2 = new DataInputStream (bin2);

	return isDifferentFiles (din1, din2);
      }
      finally {
	if (fin2 != null) {
	  fin2.close ();
	}
      }
    }
    finally {
      if (fin1 != null) {
	fin1.close ();
      }
    }
  }

  //-------------------------------------
  // Main method
  //-------------------------------------
  /**
   *
   * Runs the parser test
   **/
  public static void main (String [] pArgs)
    throws IOException
  {
    if (pArgs.length != 2 &&
	pArgs.length != 3) {
      usage ();
      System.exit (1);
    }

    File in = new File (pArgs [0]);
    File out = new File (pArgs [1]);

    runTests (in, out);

    if (pArgs.length > 2) {
      File compare = new File (pArgs [2]);
      if (isDifferentFiles (out, compare)) {
	System.out.println ("Test failure - output file " +
			    out +
			    " differs from expected output file " +
			    compare);
      }
      else {
	System.out.println ("tests passed");
      }
    }
  }

  //-------------------------------------
  static void usage ()
  {
    System.err.println ("usage: java org.apache.taglibs.standard.lang.jstl.test.ParserTest {input file} {output file} [{compare file}]");
  }

  //-------------------------------------

}
