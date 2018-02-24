/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.taghandler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Biswajit
 */
public class CustomTag extends TagSupport{
    
    /* Invokes when the start tag of the custom tag is encountered */
  public int doStartTag() throws JspException
  {
    try
    {
      /* Creating an instance of the JSPWriter for displaying the output */
      JspWriter out=pageContext.getOut();
      out.println("<BR><B>Hi This is my Custom tag<B>");
    }
    catch (Exception ioException)
    {
      System.err.println("IO Exception");
      System.err.println("ioException.toString()");
    }
    /* Returning the SKIP_BODY, as the body content is not be evaluated */
    return SKIP_BODY;
  }
  /* Invokes when the end tag of the custom tag is encountered */
  public int doEndTag() throws JspException
  {
      /* Skip the processing of the rest of the page */
      return SKIP_PAGE;
   }
    
}
