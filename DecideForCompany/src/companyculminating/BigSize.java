/**
 * Class Name: BigSize
 * Class Description: Display scenarios (BigSize company) and let user pick an option
 * Date: June 17, 2022
 * Name: Fauzan K, Masood A.
 */
package companyculminating;

public class BigSize extends MidSize {

    //fields
    private double stock;

    //constructors
    BigSize() {
        revenue = 500.0;
        expenses = 2500.0;
        inventory = 10;
        employees = 5000;
        partnerships = 30;
        stock = 600.0;
        type = "Big Size";
    }

    //getters and setters
    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    /**
     * Name: toString
     * Description: Displays company's stats to user in a clean format
     * @return - company's current stats, with stocks included
     */
    public String toString() {
        return (super.toString() + "\nStock Value: $" + stock);
    }

    /**
     * Name: finalReport Description: prints the company's reports to user (with
     * stock)
     */
    public void finalReport() {
        super.finalReport();
        System.out.print("\nStock Value: $" + stock);
    }

    /**
     * Name: resources 
     * Description: Gives user a scenarios (related to the
     * resources)
     */
    public void resources() {
        int userChoice;

        System.out.println("You are currently in the developing stages of research"
                + " and want to build a new product for the company? \nWhich "
                + "resource would you like to buy?");

        do {
            System.out.println("Please choose an option below (remember that "
                    + "you are a " + type + ")!");
            System.out.println("1. Look into tech parts."
                    + "\n2. Look into partner investments and their resources."
                    + "\n3. Look into high profit real estate.");
            userChoice = scanN.nextInt();
            
            if (userChoice < 1 || userChoice > 3) {
                System.out.println("\nPlease choose a valid option.\n");
            }
        } while (userChoice < 1 || userChoice > 3);

        switch (userChoice) {
            case 1:
                System.out.println("Great stuff! You were able to invest in "
                        + "the latest microchips and now have $250 more in revenue "
                        + "and stock value as well as 2 new partnerships.");
                revenue += 250;
                stock += 250;
                partnerships += 2;
                break;
            case 2:
                System.out.println("Sorry, this option is suited for a mid sized"
                        + " company with more capital. You lost $250 in revenue "
                        + "current stock value has decreased by $500");
                revenue -= 250;
                stock -= 500;
                break;
            case 3:
                System.out.println("Sorry, this option is suited for a mid sized"
                        + " company with more capital. You lost $250 in revenue "
                        + "current stock value has decreased by $500");
                revenue -= 250;
                stock -= 500;
                break;
        }
        System.out.println("Included below is your updated company status:");

    }

    /**
     * Name: pandemic 
     * Description: Gives user a scenarios (related to the pandemic)
     */
    public void pandemic() {
        String userChoice;
        do {
            System.out.print("The pandemic hit! Do you want to lay off 20 "
                    + "employees? (yes/no): ");
            userChoice = scanS.nextLine();

            if (!(userChoice.equalsIgnoreCase("yes")
                    || userChoice.equalsIgnoreCase("no"))) {
                System.out.print("\nPlease choose yes or no.\n");
            }
        } while (!(userChoice.equalsIgnoreCase("yes")
                || userChoice.equalsIgnoreCase("no")));

        if (userChoice.equalsIgnoreCase("yes")) {
            System.out.println("Ouch, your business can still handle that many "
                    + "employees. Inventory and revenue has dropped by 300 and "
                    + "200 respectively.");
            revenue -= 200;
            inventory -= 300;
        } 
        else {
            System.out.println("You made the right choice! You did gain $100 in "
                    + "expenses but overall stock value and output continues to "
                    + "thrive and increased by $200.");
            stock += 200;
            expenses += 100;
        }

        System.out.println("Included below is your updated company status:");

    }

    /**
     * Name: competition
     * Description: Gives user a scenarios (related to competition)
     */
    public void competition() {
        int userChoice;

        System.out.println("Some neighbouring competition has arrived. Your "
                + "overall revenue is dropping! What would you like to do? ");

        do {
            System.out.println("Please choose an option below (remember that "
                    + "you are a " + type + ")!");
            System.out.println("1. Go head to head with your new tech."
                    + "\n2. Go for a settlement."
                    + "\n3. Try and partner with them on a new product.");
            userChoice = scanN.nextInt();
            if (userChoice < 1 || userChoice > 3) {
                System.out.println("\nPlease choose a valid option.\n");
            }
        } while (userChoice < 1 || userChoice > 3);

        switch (userChoice) {
            case 1:
                System.out.println("Great choice! You had enough capital as a "
                        + "big tech company. You were able buy the competition "
                        + "and have $300 more in revenue, inventory, and stock "
                        + "value.");
                revenue += 300;
                inventory += 300;
                stock += 300;
                break;
            case 2:
                System.out.println("Sorry, this option is more suited for a"
                        + " smaller company. You lost $500 in revenue and $200 "
                        + "in stock value.");
                revenue -= 500;
                stock -= 200;
                break;
            case 3:
                System.out.println("Sorry, this option is more suited for a"
                        + " smaller company. You lost $500 in revenue and $200 "
                        + "in stock value.");
                revenue -= 500;
                stock -= 200;
                break;
        }
        System.out.println("Included below is your updated company status:");
    }

}
