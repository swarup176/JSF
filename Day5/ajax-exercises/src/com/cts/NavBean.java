package com.cts;

import java.io.Serializable;

import javax.faces.bean.*;

@ManagedBean 
@SessionScoped
public class NavBean implements Serializable {
  private Page currentPage = Page.A;
  
  public Page getCurrentPage() {
    return(currentPage);
  }
  
  public void doNavigation() {
    double num = Math.random();
    switch(currentPage) {
      case A: 
        currentPage = nextPage(num, Page.B);
        break;
      case B: 
        currentPage = nextPage(num, Page.C);
        break;
      case C:
        currentPage = nextPage(num, Page.VICTORY);
        break;
      case VICTORY:
        currentPage = Page.VICTORY;
        break;
      case DEFEAT:
        currentPage = Page.DEFEAT;
        break;
    }
  }
  
  public void giveUp() {
    currentPage = Page.A;
  }

  private Page nextPage(double num, Page continuePage) {
    if (num < 0.5) {
      return(continuePage);
    } else {
      return(Page.DEFEAT);
    }
  }
}
