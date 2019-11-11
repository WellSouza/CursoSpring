/**
 * HelloWorld.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Controller;

public interface HelloWorld extends java.rmi.Remote {
    public java.lang.String sayHello(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String helloWorld() throws java.rmi.RemoteException;
    public java.lang.String[] sayHelloToAll(Controller.Users[] arg0) throws java.rmi.RemoteException;
}
