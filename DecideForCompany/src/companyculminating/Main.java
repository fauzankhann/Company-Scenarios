/**
 * Project: main.java
 * Programmer: Fauzan K
 * Description: This program presents user with company related scenarios, and 
 * prompts them to make decisions that would boost the company's position for it 
 * to keep running.
 */
package companyculminating;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    //global scanners
    public static Scanner scanN = new Scanner(System.in);
    public static Scanner scanS = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {

        //declare and initialize variables
        double netWorth = 0, value = 0;
        int companyChoice = 0;
        String playerAns, insChoice, userName = null, userChoice;

        //Initialize array of objects
        Company[] company = new Company[3];

        company[0] = new StartUp();
        company[1] = new MidSize();
        company[2] = new BigSize();

        //Initializing and creating Decimal Formatter
        DecimalFormat twoDigit = new DecimalFormat("0.00");

        //Import textfile
        File myFile = new File("CompanyInfo.txt");

        Scanner readFile = new Scanner(myFile);

        //Make array list
        ArrayList<String> allNames = new ArrayList<>();
        ArrayList<Double> allMoney = new ArrayList<>();
        ArrayList<Integer> Scenarios = new ArrayList<>();

        //read textfile and put into arraylist
        while (readFile.hasNext()) {
            allNames.add(readFile.nextLine());
            allMoney.add(Double.parseDouble(readFile.nextLine()));
        }

        System.out.println("\t\tWELCOME TO THE COMPANY SIMULATOR");

        //ask user for name and search through textfile. If name DNE, make one.
        do {
            System.out.print("• Are you a returning player? (yes/no): ");
            playerAns = scanS.nextLine();
            if (!(playerAns.equalsIgnoreCase("yes")
                    || playerAns.equalsIgnoreCase("no"))) {
                System.out.print("\nPlease choose yes or no.");
            }
        } 
        while (!(playerAns.equalsIgnoreCase("yes") || 
                playerAns.equalsIgnoreCase("no")));

        //if user is returning
        if (playerAns.equalsIgnoreCase("yes")) {
            System.out.print("What is your name?: ");
            userName = scanS.nextLine();
            
            //if userName exists
            if (allNames.contains(userName)) {
                System.out.println("Welcome back... Let's see if you can"
                        + " get a higher net worth than last time.");
            } 
            else {
                System.out.println("Sorry, this user does not exist. "
                        + "Adding you in as a new player...");
            }

        } 
        else if (playerAns.equalsIgnoreCase("no")) {
            System.out.print("No problem. Adding you in as a new player"
                    + "...\nEnter your name: ");
            userName = scanS.nextLine();

        } 
        else if (!(playerAns.equalsIgnoreCase("yes")
                || playerAns.equalsIgnoreCase("no"))) {
            System.out.println("Please choose a valid input.");
        }
        
        Thread.sleep(1000);

        //ask if user wants the instructions
        do {
            System.out.print("\nDo you want to read the instructions? (yes/no): ");
            insChoice = scanS.nextLine();
            if (!(insChoice.equalsIgnoreCase("yes")
                    || insChoice.equalsIgnoreCase("no"))) {
                System.out.print("\nPlease choose yes or no.");
            }
        } 
        while (!(insChoice.equalsIgnoreCase("yes") || 
                insChoice.equalsIgnoreCase("no")));

        if (insChoice.equalsIgnoreCase("yes")) {
            instructions(); //call upon instructions method
        } 
        else {
            System.out.println("Simulator is being setup....");
        }

        Thread.sleep(1000);

        //Prompt user to pick their type of company
        do {
            System.out.println("\nWhat type of company would you like to create?");
            System.out.println("1. Startup Company");
            System.out.println("2. Mid-Sized Enterprise");
            System.out.println("3. FAANG/Big Tech Company");
            System.out.println("4. Randomly generate a company type.");
            companyChoice = intStrTrap();
            
            if (companyChoice < 1 || companyChoice > 4) {
                System.out.println("\nPlease choose a valid option.");
            }
        } while (companyChoice < 1 || companyChoice > 4);

        if (companyChoice == 1) {
            System.out.println("\nYou have gotten a Start Up Company!");
        } 
        else if (companyChoice == 2) {
            System.out.println("\nYou have gotten a Mid-Sized Company!");
        } 
        else if (companyChoice == 3) {
            System.out.println("\nYou have gotten a Big Tech Company!");
        } 
        else {
            //random number between 1-3 (picks a random company type for user)
            companyChoice = (int) (1 + Math.random() * 3);
            
            if (companyChoice == 1) {
                System.out.println("You have gotten a Start Up Company!");
            } 
            else if (companyChoice == 2) {
                System.out.println("You have gotten a Mid-Sized Enterprise!");
            } 
            else {
                System.out.println("You have gotten a FAANG/Big Sized Company!");
            }
        }

        System.out.println(company[companyChoice - 1]);

        for (int i = 0; i < 8; i++) {
            Scenarios.add(i + 1);
        }
        System.out.println("\nTime for the scenarios!");
        System.out.println("Remember to pick the best scenario for each situation"
                + " with your company type in mind.");
        System.out.println("Your company will go through various scenarious in "
                + "one economic cycle.\n");

        Thread.sleep(2000);
        
        do {
            //generate scenario randomly (and will not repeat)
            int rndNum = (int) (1 + Math.random() * 8);
            
            //Display scenarios to user depending on the random generator
            switch (rndNum) {
                case 1:
                    if (Scenarios.contains(1)) {
                        loadingScreen();
                        company[companyChoice - 1].marketCrash();
                        Scenarios.remove(Scenarios.indexOf(1));
                        System.out.println("\n" + company[companyChoice - 1] + 
                                "\n");
                    }
                    break;
                    
                case 2:
                    if (Scenarios.contains(2)) {
                        loadingScreen();
                        company[companyChoice - 1].productLaunch();
                        Scenarios.remove(Scenarios.indexOf(2));
                        System.out.println("\n" + company[companyChoice - 1] + 
                                "\n");
                    }
                    break;
                    
                case 3:
                    if (Scenarios.contains(3)) {
                        loadingScreen();
                        company[companyChoice - 1].salesDown();
                        Scenarios.remove(Scenarios.indexOf(3));
                        System.out.println("\n" + company[companyChoice - 1] + 
                                "\n");
                    }
                    break;
                    
                case 4:
                    if (Scenarios.contains(4)) {
                        loadingScreen();
                        company[companyChoice - 1].salesUp();
                        Scenarios.remove(Scenarios.indexOf(4));
                        System.out.println("\n" + company[companyChoice - 1] + 
                                "\n");
                    }
                    break;
                    
                case 5:
                    if (Scenarios.contains(5)) {
                        loadingScreen();
                        company[companyChoice - 1].newLocation();
                        Scenarios.remove(Scenarios.indexOf(5));
                        System.out.println("\n" + company[companyChoice - 1] + 
                                "\n");
                    }
                    break;
                    
                case 6:
                    if (Scenarios.contains(6)) {
                        loadingScreen();
                        company[companyChoice - 1].resources();
                        Scenarios.remove(Scenarios.indexOf(6));
                        System.out.println("\n" + company[companyChoice - 1] + 
                                "\n");
                    }
                    break;
                    
                case 7:
                    if (Scenarios.contains(7)) {
                        loadingScreen();
                        company[companyChoice - 1].pandemic();
                        Scenarios.remove(Scenarios.indexOf(7));
                        System.out.println("\n" + company[companyChoice - 1] + 
                                "\n");
                    }
                    break;
                    
                case 8:
                    if (Scenarios.contains(8)) {
                        loadingScreen();
                        company[companyChoice - 1].competition();
                        Scenarios.remove(Scenarios.indexOf(8));
                        System.out.println("\n" + company[companyChoice - 1] + 
                                "\n");
                    }
                    break;
            }
        } while (!Scenarios.isEmpty());

        System.out.println("The economic cycle has ended...loading your company"
                + " result");
        
        Thread.sleep(1000);
 
        //calculation for net worth
        netWorth = company[companyChoice - 1].getRevenue()
                - company[companyChoice - 1].getExpenses();

        System.out.println("Your final profit is $" + twoDigit.format(netWorth));
        company[companyChoice - 1].finalReport();

        Thread.sleep(1000);
        
        System.out.println("\n\nThank you for playing the Company Simulator."
                + "\nYour highest score is being saved to our files.\nA "
                + "leaderboard is also being generated and saved...enjoy!");
        
        Thread.sleep(1000);

        //add user information to array
        if (!allNames.contains(userName)) {
            allNames.add(userName);
            allMoney.add(netWorth);
        } 
        else if (netWorth > allMoney.get(allNames.indexOf(userName))) {
            allMoney.set(allNames.indexOf(userName), netWorth);
        }
        
        //call upon sorting method
        sortScores(allNames, allMoney);
        
        //Prompting use to search for a specific netWorth based on 
        do {
            System.out.print("Before seeing the leaderboard, would you like to\n"
                    + "search for other company owners by their net worth? "
                    + "(yes/no) ");
            userChoice = scanS.nextLine();
            if (!(userChoice.equalsIgnoreCase("yes") || 
                    userChoice.equalsIgnoreCase("no"))) { 
                System.out.println("\nPlease choose yes or no.\n");
            }
        } 
        while (!(userChoice.equalsIgnoreCase("yes") || 
                userChoice.equalsIgnoreCase("no")));
        
        /*Asking the user which value and calling the binarySearch method 
        if they type yes*/
        if(userChoice.equalsIgnoreCase("yes")) { 
            System.out.println("What specific net worth are you looking for?");
            value = doubleStrTrap();
            if(binarySearch(allMoney, value)) { 
                System.out.println("The net worth " + value + " exists and was "
                        + "scored by " + allNames.get(allMoney.indexOf(value)));
            } 
            else { 
                System.out.println("Sorry, no one exists with this score "
                        + "(net worth).");
            }
            System.out.println("\nNow moving into the leaderboard....\n");
            Thread.sleep(1000);

        } 
        else { 
            //Pausing the thread and moving into the leaderboard if they type no
            System.out.println("\nNow moving into the leaderboard....\n");

            Thread.sleep(1000);
        }

        System.out.println("\nLEADERBOARD SHOWN BELOW -->\n");
        
        //make table and display the leaderboards
        System.out.print("\t\t");
        for (int i = 0; i < allNames.size(); i++) {
            System.out.print(allNames.get(i) + "\t");
        }
        System.out.println();
        
        for (int j = 0; j < allNames.size(); j++) {
            System.out.print("===================");
        }
        
        System.out.print("\nScore\t|\t");

        for (int k = 0; k < allMoney.size(); k++) {
            System.out.print(allMoney.get(k) + "\t");
        }

        //allow to write on textfile
        FileWriter scoresFile = new FileWriter("CompanyInfo.txt", false);

        PrintWriter outFile = new PrintWriter(scoresFile);

        //print info to textfile
        for (int i = 0; i < allNames.size(); i++) {
            outFile.println(allNames.get(i));
            outFile.println(allMoney.get(i));
        }
        outFile.close();

    }

    /**
     * Name: instructions
     * Description: Explain the instructions to the game
     */
    public static void instructions() {
        System.out.println("INSTRUCTIONS:");
        System.out.println("\n- Your job is to make big decisions for the company "
                + "and will be given multiple real-life scenarios. \n- Every "
                + "decision you make has an impact on the profit, employees, "
                + "marketing, etc. \n- You need to make sure you have an "
                + "appropriate amount of employees and income for your company "
                + "to keep running.");
        System.out.println("Atlast, ENJOY...");
    }

    /**
     * Name: stringTrap
     * Description: If user enters a string when not applicable, 
     * make them re-enter an integer.
     */
    public static int intStrTrap() {
        while (true) {
            try {
                return scanN.nextInt();
            } 
            catch (InputMismatchException i) {
                scanN.next();
                System.out.println("\nThis is not a number. "
                        + "Please choose one of the listed options");
                System.out.println("1. Startup Company");
                System.out.println("2. Mid-Sized Enterprise");
                System.out.println("3. FAANG/Big Tech Company");
            }
        }
    }
    
    /**
     * Name: stringTrap
     * Description: If user enters a string when not applicable, make them 
     * re-enter a double.
     */
    public static double doubleStrTrap() {
        while (true) {
            try {
                return scanN.nextDouble();
            } 
            catch (InputMismatchException i) {
                scanN.next();
                System.out.println("\nThis is not a double value. "
                        + "Please enter a double value:");
            }
        }
    }

    /**
     * Name: loadingScreen
     * Description: Pauses and makes a loading effect
     * @throws InterruptedException - used to create loading effect
     */
    public static void loadingScreen() throws InterruptedException {
        String loading = "Loading Scenario...";
        for (int i = 0; i < loading.length(); i++) {
            System.out.print(loading.charAt(i) + " ");
            /*Pauses the current thread for the given period 
            of time to make a loading effect*/
            Thread.sleep(250);
        }
        System.out.println("\n");
    }

    /**
     * Name: sortScores
     * Description: A method that uses bubble sort to organize the scores in 
     * order from greatest to least
     * @param names - name of player
     * @param scores - score of player
     */
    public static void sortScores(ArrayList<String> names,
        ArrayList<Double> scores) {

        double dummy;
        String nameDummy;
        boolean flag = true;

        while (flag) {

            flag = false;

            for (int i = 0; i < scores.size() - 1; i++) {

                if (scores.get(i) < scores.get(i + 1)) {
                    dummy = scores.get(i);
                    scores.set(i, scores.get(i + 1));
                    scores.set(i + 1, dummy);

                    nameDummy = names.get(i);
                    names.set(i, names.get(i + 1));
                    names.set(i + 1, nameDummy);

                    flag = true;
                }
            }
        }
    }
    
    /**
     * Name: binarySearch 
     * Description: Uses binary search to find a specific net worth and the 
     * corresponding player which adds a search engine aspect to the game.
     * @param money - ArrayList containing all the profits or net worth values
     * @param value - The double value that the user is searching for
     * @return - A boolean which returns true or false depending on whether the
     * value is in the ArrayList or not. 
     */
    public static boolean binarySearch(ArrayList<Double> money, double value) {
            int first = 0; //first index
            int last = money.size() - 1;//last index
            int middle; //midpoint of search
            boolean found = false; //flag
            
            while (!found && first <= last)
            {
                //calculate midpoint
                middle = (first + last) / 2;
                
                //if array is found at midpoint
                if (money.get(middle) == value)
                {
                    found = true;
                }
                
                //else if value is upper half
                else if (money.get(middle) < value)
                {
                    last = middle - 1; 
                }
                
                //else if the value is in the lower half
                else if (money.get(middle) > value)
                {
                    first = middle + 1;
                }
            }
            return found;
        }
}
