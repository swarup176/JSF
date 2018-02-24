package com.cts;

import javax.faces.model.DataModel;
import javax.faces.model.ArrayDataModel;

public class TableData {
   private DataModel filterModel = null;
   public static final Name[] names = {
      new Name("A", "B"),
      new Name("C", "D"),
      new Name("E", "F"),
      new Name("G", "H"),
   };

   public TableData() {
      filterModel = new SortFilterModel(new ArrayDataModel(names));
   }
   public DataModel getNames() {
      return filterModel;
   }
   public String deleteNames() {
      if (!getAnyNamesMarkedForDeletion())
         return null;

      Name[] currentNames = (Name[]) filterModel.getWrappedData();
      Name[] newNames = new Name[currentNames.length 
         - getNumberOfNamesMarkedForDeletion()];

      for(int i = 0, j = 0; i < currentNames.length; ++i) {
         Name name = (Name) currentNames[i];
         if (!name.isMarkedForDeletion()) {
            newNames[j++] = name;
         }
      }
      filterModel.setWrappedData(newNames);
      return null;
   }
   
   public int getNumberOfNamesMarkedForDeletion() {
      Name[] currentNames = (Name[]) filterModel.getWrappedData();
      int cnt = 0;

      for(int i = 0; i < currentNames.length; ++i) {
         Name name = (Name) currentNames[i];
         if (name.isMarkedForDeletion())
            ++cnt;
      }
      return cnt;
   }
   
   public boolean getAnyNamesMarkedForDeletion() {
      Name[] currentNames = (Name[]) filterModel.getWrappedData();
      for(int i = 0; i < currentNames.length; ++i) {
         Name name = (Name) currentNames[i];
         if (name.isMarkedForDeletion())
            return true;
      }
      return false;
   }
}
