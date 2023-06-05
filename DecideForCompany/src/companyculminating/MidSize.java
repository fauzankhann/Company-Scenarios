/**
 * Class Name: MidSize
 * Class Description: Display scenarios (MidSize company) and let user pick an option 
 * Date: June 17, 2022
 * Name: Fauzan K, Masood A.
 */
package companyculminating;

public class MidSize extends StartUp {
    
    //fields
    protected int partnerships;
    
    //constructors
    MidSize() { 
        revenue = 2500.0;
        expenses = 1500.0; 
        inventory = 1000; 
        employees = 20; 
        partnerships = 5; 
        type = "Mid Size";
    }
    
    //getters and setters
    public int getPartnerships() {
        return partnerships;
    }

    public void setPartnerships(int partnerships) {
        this.partnerships = partnerships;
    }

    /**
     * Name: toString 
     * Description: Displays company's stats to user in a clean format
     * @return - company's current stats, with partnerships included
     */
    public String toString() { 
        return(super.toString() + "\nPARTNERSHIPS: " + partnerships);
    }
    
    /**
     * Name: finalReport
     * Description: prints the company's reports to user (with partnerships)
     */
    public void finalReport() { 
        super.finalReport();
        System.out.print("\nPARTNERSHIPS: " + partnerships);
    }
    
    /**
     * Name: resources
     * Description: Gives user a scenarios (related to the resources)
     */
    public void resources() { 
        int userChoice;  

        System.out.println("You are currently in the developing stages of research"
                + " and want to build a \nnew product for the company? Which resource"
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
                System.out.println("Great choice, having the flexibility of a "
                        + "start up has allowed you to partner with other \n"
                        + "companies for resources. You gained $250 in revenue. "
                        + "and 15 more partnerships.");
                revenue += 250; 
                partnerships += 15; 
                break; 
            case 3: 
                System.out.println("Sorry, this option is suited for a mid sized"
                        + " company with more capital. You lost $250 in revenue.");
                revenue -= 250; 
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
                    + "employees? (yes/no)");
            userChoice = scanS.nextLine();
            
            if(!(userChoice.equalsIgnoreCase("yes")
                || userChoice.equalsIgnoreCase("no"))) {
                System.out.print("\nPlease choose yes or no.\n");
            }
        } 
        while (!(userChoice.equalsIgnoreCase("yes")
                || userChoice.equalsIgnoreCase("no"))); 
        
        //adjust fields depending on users choice
        if(userChoice.equalsIgnoreCase("yes")) { 
            System.out.println("Ouch, your business can still handle that many "
                    + "employees. Inventory and revenue has dropped.");
            revenue -= 200; 
            inventory -= 300; 
        } 
        else { 
            System.out.println("You made the right choice! You did gain $100 in "
                    + "expenses but overall revenue has increased.");
            revenue += 250;
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
                + "overall revenue is dropping! \nWhat would you like to do? ");

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
        
        //adjust fields depending on users choice
        switch(userChoice) { 
            case 1:  
                System.out.println("Sorry, this option is more suited for a high"
                        + " end company. You lost $500 in revenue.");
                revenue -= 500;
                break; 
            case 2: 
                System.out.println("Great choice, a settlement is perfect for "
                        + "a mid-sized \nenterprise with many partnerships. You "
                        + "gained $500 in revenue and one new partnership.");
                revenue += 500; 
                partnerships += 1;
                break; 
            case 3: 
                System.out.println("Sorry, this option is more suited for a high"
                        + " end company. You lost $500 in revenue.");
                revenue -= 500; 
                break;     
        }
        System.out.println("Included below is your updated company status:");  
    }
    
}
