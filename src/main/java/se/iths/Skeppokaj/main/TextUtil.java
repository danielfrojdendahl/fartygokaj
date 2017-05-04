package se.iths.Skeppokaj.main;
import java.util.Scanner;

public class TextUtil{
  public static String getReply(String prompt){
    System.out.println(prompt);
    return new Scanner(System.in).nextLine();
  }
}
