import java.util.*;
import java.lang.Math;

public class BuggedMainClass {

   public static void main(String[] args) {
      String previousYear = "Actual 2018";
      String currentYear = "Enacted 2019";
      String contextYear = "AR 2020";
      List<String> budgetSets = Arrays.asList("Req 2020", "Sub 2020", "Pas 2020");

      BudgetRowClass row = new BudgetRowClass(previousYear, currentYear, contextYear, budgetSets);
      System.out.println(row);
   }
}

public class BudgetRowClass {
   String py;
   int pyValue;
   String cy;
   int cyValue;
   String context;
   int contextValue;

   List<String> bySetList;
   ArrayList<Integer> bySetValues = new ArrayList<Integer>();

   public BudgetRowClass(String py, String cy, String context, List<String> bySetList) {
      this.py = py;
      this.cy = cy;
      this.context = context;
      this.bySetList = bySetList;
      populateValues();
   }

   private void populateValues() {
      this.pyValue = generateRandomNum();
      this.cyValue = generateRandomNum();
      this.contextValue = generateRandomNum();

      for (String bySet : bySetList) {
         this.bySetValues.add(generateRandomNum());
      }

      contextValue = generateRandomNum();

   }

   private int generateRandomNum() {
      int max = 9;
      int min = 1;
      int range = max - min + 1;

      return (int) (Math.random() * range) + min;
   }

   public String toString() {
      String header = buildHeader();
      String row = buildRow();

      return header + row;
   }

   private String buildHeader() {
      String header = "|" + py + " | " + cy + " | ";
      for (String bySet : bySetList) {
         header += bySet + " | ";
      }
      header += context + " | \n";
      return header;
   }

   private String buildRow() {
      String rowValues = "|      " + pyValue + "     |      " + cyValue + "       |    ";

      int i = 0;
      for (String bySet : bySetList) {
         if (bySet.equals(context)) {
            rowValues += bySetValues.get(i) + " | ";
         } else {
            rowValues += bySetValues.get(i) + "     |    ";
         }
         i++;
      }

      return rowValues;
   }

}
