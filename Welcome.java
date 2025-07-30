import java.util.Scanner;
public class Welcome {
  public static void main(String[] args){
    Scanner input =  new Scanner(System.in);
    System.out.print("Enter your first name : ");
    String firstName=input.nextLine();
   System.out.print("Enter your last name : ");
    String lastName=input.nextLine();

   System.out.println("Welcome to the secound year " + firstName + " " + lastName );
   input.close();
}

}