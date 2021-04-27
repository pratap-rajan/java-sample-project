/**
 * The System class holds the attributes and methods of the system
 * 
 * @author 
 * @version v1.0 24-05-2020 //Initial Version
 * 			v1.1 01-06-2020 //Additional comments added
 * 			v1.2 04-06-2020 //Cosmetic Fixes (Use of \t instead of (space) for System.out.println
 */


//PART C - Scanner Class, to obtain user input for Memory & Hard Disk
import java.util.*;

public class System {
	
	//System Variable Declaration - Per UML Diagram
	private String make;
	private String model;
	private int speed;
	private int memorySize;         //In MB
	private double hardDiskSize;	//IN GB
	private double purchaseCost;
	
	//Additional Declaration
	private String checkHDStatus;
	private boolean goodMemorySize;
	private String choice;
	private int choiceNumber;
	private String userMemoryInput;
	private String userHDInput;
	
	
	//Default Constructor
	public System()
	{
		make = "undefined";
		model = "undefined";
		speed = 0;
		memorySize = 0;
		hardDiskSize = 0.0;
		purchaseCost = 0.0;
		checkHDStatus = "Low";
	}
	
	
	//Constructor to initialise make, model and speed of the system
	public System(String systemMake, String systemModel, int processorSpeed)
	{
		make = systemMake;
		model = systemModel;
		speed = processorSpeed;
	}
	
	//Get Method - Make of the System
	public String getMake()
	{
		return make;
	}
	
	//Get Method - Model of the System
	public String getModel()
	{
		return model;
	}
	
	//Get Method - ProcessorSpeed of the System
		public int getProcessorSpeed()
	{
		return speed;
	}
	
	//set the Memory Size
	public void setMemory(int systemMemorySize)
	{
		memorySize = systemMemorySize;
	}
	
	//get Method for Memory Size
	public int getMemory()
	{
		return memorySize;
	}
	
	//set the Hard Disk Size
	public void setHardDisk(double systemHardDisk)
	{
		hardDiskSize = systemHardDisk;
	}
		
	//get Method for Hard Disk Size
	public double getHardDisk()
	{
		return hardDiskSize;
	}
	
	//set the purchase cost
	public void setpurchaseCost(double systemPurchaseCost)
	{
		purchaseCost = systemPurchaseCost;
	}
	
	//Method to check Hard Disk Status is "OK" or "Low"
	public String checkHDStatus()
	{
		
		if (hardDiskSize < 2.0) {
			checkHDStatus = "Low";
		}
		
		else {
			checkHDStatus = "OK";
			
		}
		return checkHDStatus;
	}
	
	//Method to check Memory Size is "true" or "false"
	public boolean goodMemorySize(){
		
		if (memorySize < 128) {
			goodMemorySize = false;
		}
		
		else {
			goodMemorySize = true;
		}
		
		return goodMemorySize;
	}
	
	//Part A - Output Method to Display System Details
	public String displayDetails()
	{
		String displayDetail = "";
		 
		displayDetail = ("Make of your System\t\t=>\t" + make + 
						"\nModel of your System\t\t=>\t" + model + 
						"\nSpeed of your System\t\t=>\t" + speed + 
						"\nMemory of your System\t\t=>\t" + memorySize + " MB " +
						"\nHard Disk of your System\t=>\t" + hardDiskSize + " GB " +
						"\nPurchase Cost of your System\t=>\t" + purchaseCost);
		
		return displayDetail;
	}
	
	//Part A - Output Method to Diagnose System for the entered Memory and Hard Disk Size
	public String diagnoseSystem()
	{
		String diagnoseSystem = "";
		 
		checkHDStatus();
		goodMemorySize();
		diagnoseSystem = ("Hard Disk size\t\t\t=>\t" + checkHDStatus + 
						"\nMemory Size Ok\t\t\t=>\t" + goodMemorySize);
		
		return diagnoseSystem;
	}
	
	//Part B - Display System Properties
	public String displaySystemProperties()
	{
		String displaySystemInfo = "";
		String yourOS = "";
		
		//Positive
		//For TestingOnly - By Default, the below line is commented
		//if (java.lang.System.getProperty("os.name").equalsIgnoreCase("Mac OS X")){	
	
		if (java.lang.System.getProperty("os.name").equalsIgnoreCase("Windows 10")){
			
			yourOS = "Positive - Be Awesome. Run on Windows";
			
		}
		
		//Negative
		//For Testing - By Default, the below line is commented
		//else if (java.lang.System.getProperty("os.name").equalsIgnoreCase("Mac OS X")){
		
		else if (java.lang.System.getProperty("os.name").equalsIgnoreCase("Linux")){
			yourOS = "Negative - Linux";
		}
		
		//Neutral
		else {
			yourOS = "Neutral - You've got a decent OS here";
		}
		
		displaySystemInfo = "Operating System Architecture\t=>\t" + java.lang.System.getProperty("os.arch") +
				            "\nOperating System Name\t\t=>\t" + java.lang.System.getProperty("os.name") +
				            "\nOperating System Version\t=>\t" + java.lang.System.getProperty("os.version") +
				            "\nUser Account Name\t\t=>\t" + java.lang.System.getProperty("user.name") +
				            "\nJava Version\t\t\t=>\t" + java.lang.System.getProperty("java.version") +
				            "\n" + yourOS;
		
		
		return displaySystemInfo;
		
	}
	
	//PART C - Textual Menu Display
	public void menuDisplay() {
		
		java.lang.System.out.println("");
		java.lang.System.out.println("~~~~~~~~~~~~Display System Menu~~~~~~~~~~~~");
		java.lang.System.out.println("**** Enter a Number from the Options Below ****");
		java.lang.System.out.println("Choice 1 – Print System Details\n" + 
						   "Choice 2 - Display System Properties\n" +
						   "Choice 3 – Diagnose System\n" + 
						   "Choice 4 – Set Details\n" + 
						   "Choice 5 – Quit the program");
		
	}
	public void displaySysInfo() {
		
		//Initialise Object from Scanner Class
		Scanner sc = new Scanner(java.lang.System.in);
		
		//Use of do-while loop 
		do {
			
			//Method Call
			menuDisplay();
			
			//Receive an input from end user
			choice = sc.next();
			
			//To check if the input matches a valid input pattern
			if (choice.matches("^[0-9]*"))
			{
				choiceNumber = Integer.parseInt(choice);
			}
			
			//Choice 1 - 
			if (choiceNumber == 1) {
				java.lang.System.out.println(displayDetails());
			}
			
			//Choice 2 -
			else if (choiceNumber == 2) {
				java.lang.System.out.println(displaySystemProperties());
			}
			
			//Choice 3 -
			else if (choiceNumber == 3) {
				java.lang.System.out.println(diagnoseSystem());
			}
			
			//Choice 5 -
			else if (choiceNumber == 5) {
				java.lang.System.out.println("GoodBye!");
			}
			
			//Choice 4 - Set Memory & Hard disk Input.
			else if (choiceNumber == 4) {
				java.lang.System.out.println("");
				java.lang.System.out.println("Please enter your Memory Size");
				userMemoryInput = sc.next();
				
				//Loop while user enters a proper Memory size input
				while (!userMemoryInput.matches("^[0-9]*"))
				{
					java.lang.System.out.println("");
					java.lang.System.out.println("Invalid Input - Please enter your Memory Size");
					userMemoryInput = sc.next();
				}
				//Setting Memory Input as Integer  - As per requirement.
				int MemoryInput = Integer.parseInt(userMemoryInput);
				setMemory(MemoryInput);
				
				java.lang.System.out.println("Thanks!");
				java.lang.System.out.println("Please enter your Hard Disk Size");
				userHDInput = sc.next();
				
				//Loop while user enters a proper disk size input
				while (!userHDInput.matches("^[0-9 .]*"))
				{
					java.lang.System.out.println("");
					java.lang.System.out.println("Invalid Input - Please enter your Disk Size");
					userHDInput = sc.next();
				}
				//Setting Hard Disk Input as Double - As per requirement
				double diskInput = Double.parseDouble(userHDInput);
				setHardDisk(diskInput);
			}
			
			else {
				java.lang.System.out.println("You seem to have entered an invalid Input, please enter a choice number between 1 - 5");
			}
		}
		//Loop until user enters 5 to Quit the program
		while (choiceNumber != 5);
		
		//Close Scanner Class to Avoid Resource leak - As suggested by Eclipse prompt
		sc.close();
	}  
} //end of System class
