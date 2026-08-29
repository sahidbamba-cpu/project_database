import java.util.Scanner;
public class cards {
    public static void main(String[] args) {
        System.out.print("Please choose a position Within the Array.");
        int[] positions = new int[15];
        //This sets each position in the array with a number
        for(int i = 0; i < positions.length; positions[i] = i++) {
        }

        Scanner Response = new Scanner(System.in);
        System.out.println("Reveal each card in your deck. There are 12 cards");
        System.out.println("to end the game type 14");
        //sets a condition for the loop to validate
        boolean condition = true;
        //validates the input so in order for your card number to be revealed it must be between 0 to 13
        while(condition) {
            System.out.println("pick a number 0 to 13: ");
            int choice = Response.nextInt();
            if (0 < choice && choice < 11) {
                System.out.println("Your card number is " + positions[choice]);
            } else if (choice == 0) {
                System.out.println("Your card is the Ace which is card number is " + positions[choice]);
            } else if (choice == 11) {
                System.out.println("Your card  is the joker which is card number " + positions[choice]);
            } else if (choice == 12) {
                System.out.println("Your card  is the Queen which is card number " + positions[choice]);
            } else if (choice == 13) {
                System.out.println("Your card  is the king which is card number " + positions[choice]);
            } else if (choice == 14) {
                condition = false;
            } else {
                System.out.println("This number is to big, Please choose another Number!");
            }
        }

        System.out.println("Thanks for playing!!");
    }
}


