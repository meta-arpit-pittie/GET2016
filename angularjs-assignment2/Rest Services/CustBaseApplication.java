/**
 * Assignment 1
 * To register the webservices package class
 * @author Arpit Pittie
 */
package com.server;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//Does not require web.xml
//to define the base URI pattern
@ApplicationPath(value="/resource" )
public class CustBaseApplication extends Application
{
	@Override
	public Set<Class<?>> getClasses( )
	{
		Set<Class<?>> rSet = new HashSet<Class<?>>( );
		rSet.add( RestCustomerServices.class ); 
		return rSet;
	}
}