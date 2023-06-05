/**
 * Class Name: Company
 * Class Description: This holds fields for a company and prints their stats
 * Date: June 17, 2022
 * Name: Fauzan K, Masood A.
 */
package companyculminating;

import java.util.Scanner;

public class Company {

    //fields
    protected double revenue, expenses;
    protected int inventory, employees;
    protected String type;
    protected Scanner scanN;
    protected Scanner scanS;

    //constructors
    public Company() {
        scanN = new Scanner(System.in);
        scanS = new Scanner(System.in);
    }

    //getters and setters
    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Scanner getScanN() {
        return scanN;
    }

    public void setScanN(Scanner scanN) {
        this.scanN = scanN;
    }

    public Scanner getScanS() {
        return scanS;
    }

    public void setScanS(Scanner scanS) {
        this.scanS = scanS;
    }

    //Override methods
    /**
     * Name: toString 
     * Description: Displays company's stats to user in a clean format
     * @return - company's current stats
     */
    public String toString() {
        return ("Here are your current stats, try to keep your revenue"
                + "as high as possible and expenses as low as possible."
                + "\nTYPE: " + type + "\nREVENUE: $" + revenue + "\nEXPENSES: $"
                + expenses + "\nINVENTORY: $" + inventory + "\nEMPLOYEES: "
                + employees);
    }

    /**
     * Name: finalReport
     * Description: prints the company's reports to user
     */
    public void finalReport() {
        System.out.print("\nTYPE: " + type + "\nREVENUE: $" + revenue
                + "\nEXPENSES: $" + expenses + "\nINVENTORY: $" + inventory
                + "\nEMPLOYEES: " + employees);
    }

    //polymorphism 
    public void marketCrash() {
        System.out.println("This is an error: Company Class");
    }

    public void productLaunch() {
        System.out.println("This is an error: Company Class");

    }

    public void salesDown() {
        System.out.println("This is an error: Company Class");
    }

    public void salesUp() {
        System.out.println("This is an error: Company Class");
    }

    public void newLocation() {
        System.out.println("This is an error: Company Class");
    }

    public void resources() {
        System.out.println("This is an error: Company Class");
    }

    public void pandemic() {
        System.out.println("This is an error: Company Class");
    }

    public void competition() {
        System.out.println("This is an error: Company Class");
    }

}
