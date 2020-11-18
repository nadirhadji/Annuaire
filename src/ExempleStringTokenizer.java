
//importation de la calsse StringTokenizer
import java.util.StringTokenizer;


public class ExempleStringTokenizer {
   
   public static void exemple1 () {
      String s = "machin:truc:chose:bidule";
      StringTokenizer tokens = new StringTokenizer(s, ":");
      String token;
      
      System.out.println("Le nombre de jetons : " + tokens.countTokens());
   
      while (tokens.hasMoreTokens()) {
         token = tokens.nextToken();
         System.out.println(token);
      }
   }
   
   public static void exemple2 () {

      String s = "machin\ntruc\nchose\nbidule";
      StringTokenizer tokens = new StringTokenizer(s, "\n");
      String token;
      String s2 = "";
      
      while (tokens.hasMoreTokens()) {
         token = tokens.nextToken();
         s2 = s2 + token + "-";
      }
      s2 = s2.substring(0, s2.length() - 1);
      
      System.out.println(s2);
   }
   
   public static void main (String [] args) {
      
      System.out.println("EXEMPLE 1");
      exemple1();
      
      System.out.println("\nEXEMPLE 2");
      exemple2();

      System.out.println("\n\n");
   }
   
   
   
   
   
}
