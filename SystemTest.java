/**
 * The SystemTest class holds main method and initialises object from System Class
 * to test the defined methods
 * 
 * @author 
 * @version v1.0 24-05-2020 //Initial Version
 * 			v1.1 04-06-2020 //Cosmetic Fixes
 */

public class SystemTest {
	String choiceNumber = "";
	

	public static void main(String[] args) {
		//Part A
		//Set Values to Make, Model and Speed
		System s2 = new System("Dell", "Inspiron", 2400);
		
		//Calling the default Constructor.
		//System s2 = new System();
		
		//Set Value for Hard Disk, Memory and Cost
		s2.setHardDisk(20);
		s2.setMemory(128);
		s2.setpurchaseCost(300.00);
		
		//"To resolve this name clash, we can use the extended package name in the code to differentiate between the two classes."
		//"Java in Two Semester - 4th Edition By - Quentin Charatan & Aaron Kans"
		java.lang.System.out.println("");
		java.lang.System.out.println("Assignment 2 - Part A");
		java.lang.System.out.println("");
		java.lang.System.out.println("~~~~~~~~~~~~The Details of your System~~~~~~~~~~~~");
		
		//Output after calling Set Variables
		java.lang.System.out.println(s2.displayDetails());
		java.lang.System.out.println(s2.diagnoseSystem());
		
		
		//PART B -Display System Properties
		java.lang.System.out.println("");
		java.lang.System.out.println("Assignment 2 - Part B");
		java.lang.System.out.println("");
		java.lang.System.out.println("~~~~~~~~~~~~Display System Properties~~~~~~~~~~~~");
		java.lang.System.out.println(s2.displaySystemProperties());
		
		//PART C - Menu Based Output & Selection
		System s3 = new System("HP", "ProBook", 2600);
		s3.setpurchaseCost(300.00);
		java.lang.System.out.println("");
		java.lang.System.out.println("Assignment 2 - Part C");
		s3.displaySysInfo();
		
	} //end of Main
}	//end of Test Class
