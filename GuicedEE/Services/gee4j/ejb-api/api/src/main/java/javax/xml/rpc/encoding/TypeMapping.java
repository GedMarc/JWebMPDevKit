/*
 * Copyright (c) 2003, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package javax.xml.rpc.encoding;

import javax.xml.rpc.JAXRPCException;
import java.util.Iterator;
import javax.xml.namespace.QName;

/** The <code>javax.xml.rpc.encoding.TypeMapping</code> is the base 
 *  interface for the representation of a type mapping. A TypeMapping 
 *  implementation class may support one or more encoding styles.
 *
 *  <p>For its supported encoding styles, a TypeMapping instance 
 *  maintains a set of tuples of the type {Java type, 
 *  <code>SerializerFactory</code>, 
 *  <code>DeserializerFactory</code>, XML type}. 
 *  
 *  @version   1.0
 *  @author    Rahul Sharma
**/

public interface TypeMapping {

  /** Returns the encodingStyle URIs (as String[]) supported by  
   *  this TypeMapping instance. A TypeMapping that contains only 
   *  encoding style independent serializers and deserializers 
   *  returns <code>null</code> from this method.
   *
   *  @return Array of encodingStyle URIs for the supported 
   *          encoding styles
  **/
  public String[] getSupportedEncodings();

  /** Sets the encodingStyle URIs supported by this TypeMapping 
   *  instance. A TypeMapping that contains only encoding 
   *  independent serializers and deserializers requires 
   *  <code>null</code> as the parameter for this method.
   *
   *  @param encodingStyleURIs Array of encodingStyle URIs for the 
   *                           supported encoding styles
  **/
  public void setSupportedEncodings(String[] encodingStyleURIs);

  /** Checks whether or not type mapping between specified XML 
   *  type and Java type is registered.
   *   
   *  @param javaType Class of the Java type
   *  @param xmlType    Qualified name of the XML data type
   *  @return boolean; <code>true</code> if type mapping between the
   *           specified XML type and Java type is registered;
   *           otherwise <code>false</code>
  **/
  public boolean isRegistered(Class javaType, QName xmlType);

  /** Registers SerializerFactory and DeserializerFactory for a 
   *  specific type mapping between an XML type and Java type.
   *  This method replaces any existing registered SerializerFactory
   *  DeserializerFactory instances.
   *
   *  @param javaType Class of the Java type
   *  @param xmlType    Qualified name of the XML data type
   *  @param sf       SerializerFactory
   *  @param dsf      DeserializerFactory
   *  @throws JAXRPCException If any error during the registration
  **/
  public void register(Class javaType, QName xmlType,
		  SerializerFactory sf,
		  DeserializerFactory dsf);

  /** Gets the SerializerFactory registered for the specified
   *  pair of Java type and XML data type.
   *
   *  @param  javaType Class of the Java type
   *  @param  xmlType    Qualified name of the XML data type
   *  @return Registered SerializerFactory or <code>null</code>
   *          if there is no registered factory
   **/
  public SerializerFactory getSerializer(Class javaType,
		  QName xmlType);

  /** Gets the DeserializerFactory registered for the specified
   *  pair of Java type and XML data type.
   *
   *  @param  javaType Class of the Java type
   *  @param  xmlType    Qualified name of the XML data type
   *  @return Registered DeserializerFactory or <code>null</code>
   *          if there is no registered factory
  **/
  public DeserializerFactory getDeserializer(Class javaType,
		  QName xmlType);

  /** Removes the SerializerFactory registered for the specified
   *  pair of Java type and XML data type.
   * 
   *  @throws JAXRPCException If there is error in removing the
   *          registered SerializerFactory
  **/
  public void removeSerializer(Class javaType, QName xmlType);

  /** Removes the DeserializerFactory registered for the specified
   *  pair of Java type and XML data type.
   * 
   *  @throws JAXRPCException If there is error in removing the
   *          registered DeserializerFactory
  **/
  public void removeDeserializer(Class javaType, QName xmlType);

}

