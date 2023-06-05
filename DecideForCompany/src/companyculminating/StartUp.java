/**
 * Class Name: StartUp
 * Class Description: Display scenarios (startup company) and let user pick an option 
 * Date: June 17, 2022
 * Name: Fauzan K, Masood A.
 */
package companyculminating;

public class StartUp extends Company {
    
    //constructor
    StartUp() { 
        revenue = 2000.0;
        expenses = 2000.0; 
        inventory = 1000; 
        employees = 20; 
        type = "Start Up";
    }
    
    /**
     * Name: toString 
     * Description: Displays company's stats to user in a clean format
     * @return - company's current stats
     */
    public String toString() { 
        return(super.toString());
    }
    
    /**
     * Name: marketCrash 
     * Description: Gives user options to choose from (after given a scenario)
     */
    public void marketCrash() { 
        int userChoice;
        
            System.out.println("OH NO! The market changed and your revenue "
                    + "dropped.");
        do {
            System.out.println("Please choose an option below (remember that "
                    + "you are a " + type + ")!");
            System.out.println("1. Sell inventory to increase your revenue."
                    + "\n2. Hire 10 more employees."
                    + "\n3. Buy more inventory for the future.");
            userChoice = scanN.nextInt(); 
            
            if(userChoice < 1 || userChoice > 3) { 
                System.out.println("\nPlease choose a valid option.\n");
            }
        } 
        while(userChoice < 1 || userChoice > 3);
        
        //depending on what choice user picks, adjust the fields
        switch(userChoice) { 
            case 1: 
                System.out.println("This is not the best solution as you have "
                        + "\nincreasing expenses and things have evened out.\n"
                        + "You have not made any revenue and instead broke "
                        + "even.");
                revenue += 500;
                expenses -= 500; 
                inventory -= 250; 
                break; 
            case 2: 
                System.out.println("You broke even but having 10 new employees "
                        + "will be benefecial in the future.");
                employees += 10; 
                revenue -= 300; 
                expenses += 300;
                break; 
            case 3: 
                System.out.println("You broke even and increased inventory by "
                        + "500 items!!");
                inventory += 500; 
                expenses += 250; 
                revenue -= 250;
                break; 
        }
        System.out.println("Included below is your updated company status:");
    }
    
    /**
     * Name: productLaunch
     * Description: Display user a scenario (related to launching a product)
     */
    public void productLaunch() { 
        int userChoice; 
        
        System.out.println("Your company spent millions launching a new product"
                + " but is not receiving much attention.");
        do {
            System.out.println("Please choose an option below (remember that "
                    + "you are a " + type + ")!");
            System.out.println("1. Hire more employees for marketing."
                    + "\n2. Wait it out for sales to increase."
                    + "\n3. Buy more inventory of the product.");
            userChoice = scanN.nextInt(); 
            if(userChoice < 1 || userChoice > 3) { 
                System.out.println("Please choose a valid option.\n");
            }
        } while(userChoice < 1 || userChoice > 3);        
        
        //depending on user's choice, adjust the fields
        switch(userChoice) { 
            case 1:  
                System.out.println("You ended up gaming 10 employees and $100 "
                        + "in revenue.\nHowever, you must pay $200 in expenses.");
                employees += 10; 
                expenses += 200; 
                revenue += 100; 
                break; 
            case 2: 
                System.out.println("You got $200 in revenue and $100 in expenses."
                        + "\nEnjoy the $100 profit!");
                revenue += 200; 
                expenses += 100;
                break; 
            case 3: 
                System.out.println("You got 200 more items in your inventory and"
                        + "\nhave to pay $100 in expenses but also made $50 in "
                        + "revenue.");
                inventory += 200; 
                expenses += 100; 
                revenue += 50;
                break;     
        }
        System.out.println("Included below is your updated company status:");    
    }
    
    /**
     * Name: newLocation
     * Description: Display user a scenario (related to company moving)
     */
    public void newLocation() { 
        int userChoice; 
        
        System.out.println("Your company decided to move to a new location "
                + "which will pause your productivity for a few days and slow "
                + "down sales. What would you like to do?");
        do {
            System.out.println("Please choose an option below (remember that "
                    + "you are a " + type + ")!");
            System.out.println("1. Invest in more advertising."
                    + "\n2. Sell off excess inventory."
                    + "\n3. Hire 20 more employees.");
            userChoice = scanN.nextInt(); 
            if(userChoice < 1 || userChoice > 3) { 
                System.out.println("\nPlease choose a valid option.\n");
            }
        } 
        while(userChoice < 1 || userChoice > 3);        
        
        //depending on user's choice, adjust the fields
        switch(userChoice) { 
            case 1:  
                System.out.println("Decent choice, you gained $150 in expenses "
                        + "\nbut also $250 in revenue leading to a profit of $100.");
                expenses += 150; 
                revenue += 250; 
                break; 
            case 2: 
                System.out.println("Be careful! You might have made $200 of quick"
                        + " \ncash in revenue but also 100 items from your "
                        + "inventory.");
                inventory -= 100; 
                revenue += 200; 
                break; 
            case 3: 
                System.out.println("Ouch, hiring employees should not be the sole "
                        + "\nfocus when there are many other areas to focus on.\n"
                        + "You gained 20 employees but lost $100 in revenue.");
                employees += 20; 
                revenue -= 100;
                break;     
        }
        System.out.println("Included below is your updated company status:");    
    }        
    
    /**
     * Name: salesUp
     * Description: Asks user a question (related to company sales increasing)
     */
    public void salesUp() { 
        String userChoice;
        do {
            System.out.print("Sales are up! Do you want to buy more inventory? "
                + "(yes/no): ");
            userChoice = scanS.nextLine();
            if(!(userChoice.equalsIgnoreCase("yes")
                || userChoice.equalsIgnoreCase("no"))) {
                System.out.print("\nPlease choose yes or no.\n");
            }
        } 
        while (!(userChoice.equalsIgnoreCase("yes")
                || userChoice.equalsIgnoreCase("no"))); 
        
        if(userChoice.equalsIgnoreCase("yes")) { 
            System.out.println("Good choice, sales are continuing to thrive!");
            System.out.println("You earned $250!");
            revenue += 250; 
        } 
        else { 
            System.out.println("Ouch, you lost out on a really good opportunity.");
            System.out.println("You didn't earn anything but expenses increased "
                    + "by 100.");
            expenses += 100;
        }
        
        System.out.println("Included below is your updated company status:");
    }
        
    /**
     * Name: salesDown
     * Description: Asks user a question (related to company sales decreasing)
     */
    public void salesDown() { 
        String userChoice;
        do {
            System.out.print("Sales are not looking great. Do you want to invest "
                    + "in marketing? (yes/no): ");
            userChoice = scanS.nextLine();
            
            if(!(userChoice.equalsIgnoreCase("yes") || 
                    userChoice.equalsIgnoreCase("no"))) {
                System.out.print("\nPlease choose yes or no.\n");
            }
        } 
        while (!(userChoice.equalsIgnoreCase("yes") || 
                userChoice.equalsIgnoreCase("no"))); 
        
        //adjust fields depending on users choice
        if(userChoice.equalsIgnoreCase("yes")) { 
            System.out.println("Ouch, it turns out that the product just does "
                    + "not suit our demographic.");
            System.out.println("You have $250 more in expesnes to pay off now.");
            
            expenses += 250; 
        } 
        else { 
            System.out.println("Good choice, you have gained $300 in revenue "
                    + "to use for future expenses.");
            revenue += 300;
        }
        
        System.out.println("Included below is your updated company status:");
    }
    
    /**
     * Name: resources
     * Description: Gives user a scenarios (related to the resources)
     */
    public void resources() { 
        int userChoice;  
        
        System.out.println("You are currently in the developing stages of research"
                + " and want to build a new product for the ompany? Which resource"
                + " would you like to buy?");

        do {
            System.out.println("Please choose an option below (remember that "
                    + "you are a " + type + ")!");
            System.out.println("1. Look into tech parts."
                    + "\n2. Look into partner investments and their resources."
                    + "\n3. Look into high profit real estate.");
            userChoice = scanN.nextInt(); 
            
            if(userChoice < 1 || userChoice > 3) { 
                System.out.println("\nPlease choose a valid option.\n");
            }
        } while(userChoice < 1 || userChoice > 3);        
        
        switch(userChoice) { 
            case 1:  
                System.out.println("Sorry, this option is more suited for a high"
                        + " end company. You lost $250 in revenue.");
                revenue -= 250;
                break; 
            case 2: 
                System.out.println("Sorry, this option is more suited for a high"
                        + " end company. You lost $250 in revenue.");
                revenue -= 250; 
                break; 
            case 3: 
                System.out.println("Great choice, having an investment is the "
                        + "most ideal for a Start Up company. You gained "
                        + "$250 in revenue.");
                revenue += 250; 
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
            if(!(userChoice.equalsIgnoreCase("yes")
                || userChoice.equalsIgnoreCase("no"))) {
                System.out.print("\nPlease choose yes or no.\n");
            }
        } 
        while (!(userChoice.equalsIgnoreCase("yes") || 
                userChoice.equalsIgnoreCase("no"))); 
        
        //adjust fields depending on user
        if(userChoice.equalsIgnoreCase("yes")) { 
            System.out.println("You made the right choice! Your expenses have "
                    + "reduced and revenue has been maintained.");
            expenses -= 250; 
        } 
        else { 
            System.out.println("That's unfortunate! Your expenses have increased"
                    + " by $250 and revenue has decreased by $200.");
            revenue -= 200;
            expenses += 250;
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
            
            if(userChoice < 1 || userChoice > 3) { 
                System.out.println("\nPlease choose a valid option.\n");
            }
        } while(userChoice < 1 || userChoice > 3);        
        
        switch(userChoice) { 
            case 1:  
                System.out.println("Sorry, this option is more suited for a high"
                        + " end company. You lost $500 in revenue.");
                revenue -= 500;
                break; 
            case 2: 
                System.out.println("Sorry, this option is more suited for a mid"
                        + " tier end company. You lost $500 in revenue.");
                revenue -= 500; 
                break; 
            case 3: 
                System.out.println("Great choice, having the flexibility of a "
                        + "start up has allowed you to partner with other "
                        + "companies for resources. You gained $500 in revenue.");
                revenue += 500; 
                break;     
        }
        
        System.out.println("Included below is your updated company status:");  
    }
}
