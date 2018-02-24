package com.cts.custom;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class CustomBodyContentTag extends BodyTagSupport
{
  private int iterations, howMany;

  public void setHowMany(int i)
  {
    this.howMany = i;
  }

  public void setBodyContent(BodyContent bc)
  {
    super.setBodyContent(bc);
    System.out.println("BodyContent = '" + bc.getString() + "'");
  }
  
  public int doAfterBody()
  {
    try 
    {    
      BodyContent bodyContent = super.getBodyContent();
      String      bodyString  = bodyContent.getString();
      JspWriter   out         = bodyContent.getEnclosingWriter();

      if ( iterations % 2 == 0 ) 
        out.print(bodyString.toLowerCase());
      else
        out.print(bodyString.toUpperCase());

      iterations++;
      bodyContent.clear(); // empty buffer for next evaluation
    }
    catch (IOException e) 
    {
      System.out.println("Error in BodyContentTag.doAfterBody()" + e.getMessage());
      e.printStackTrace();
    } // end of catch

    int retValue = SKIP_BODY;
    
    if ( iterations < howMany ) 
      retValue = EVAL_BODY_AGAIN;
    
    return retValue;
  }
}

