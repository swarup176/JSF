package com.cts.jsf.datatable;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

@ManagedBean
@SessionScoped
public class TableData implements Serializable {
   private static final Name[] names = new Name[] {
       new Name("A", "B"),
       new Name("C", "D"),
       new Name("E", "F"),
       new Name("G", "H")
   };

   public Name[] getNames() { return names;}
}
