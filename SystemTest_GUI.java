/**
 * The SystemTest_GUI class holds main method and initialises object from System Class
 * The class extends Application class to leverage JavaFX methods
 * 
 * @author 
 * @version v1.0 24-05-2020 //Initial Version
 * 			v1.1 04-06-2020	//Cosmetic Fix (Output for Memory and HD details)
 * 			v1.2 05-06-2020 //Cosmetic Fix - 
 * 							//a) Reset Display Field and Choice Box components
 * 							//b) Added some additional messaging to help user navigate better
 * 							//c) Message to enter only whole number and no decimal
 */

//Inital Imports to work with JavaFX
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color; 
import javafx.scene.text.Font; 
import javafx.stage.Stage;


//class to extend Application class
public class SystemTest_GUI extends Application {
	
	//start Method
	public void start(Stage stage) {
		
		//Object Initiated for SystemInfo class
		System sysInfo = new System("IBM", "ThinkPad", 1200);
		sysInfo.setpurchaseCost(331.50);
		
		// create and configure Label for the drop down         
		Label welcomeLabel = new Label("Welcome To System Info Display!!");         
		welcomeLabel.setTextFill(Color.BLUE);         
		welcomeLabel.setFont(Font.font("Helvetica", 16));
		
		
		//Provide Dropdown based user selection
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		
		//getItems for the Choice Box
		choiceBox.getItems().addAll("Please Select An Option & Click Continue","Choice 1 – Print System Details", "Choice 2 - Display System Properties", 
				   "Choice 3 – Diagnose System", "Choice 4 – Set Details", "Choice 5 – Quit the program");
		
		//set Intial Value for the drop down
		choiceBox.setValue("Please Select An Option & Click Continue");
		
		// create and configure a non-editable text area to display the results      
		TextArea display = new TextArea();        
		display.setEditable(false);         
		display.setMinSize(300,150);         
		display.setMaxSize(300,150); 
		
		//create and configure 'Continue' button. 
		//This will allow user to select an option from choice box and hit continue     
		Button continueButton = new Button();         
		continueButton.setText("Continue");  
		
		// create and configure a VBox to hold our components               
		VBox root = new VBox();         
		root.setSpacing(10);         
		root.setAlignment(Pos.CENTER);
		root.setBackground(Background.EMPTY);
		
		//add the components to the VBox         
		root.getChildren().addAll(welcomeLabel, choiceBox, continueButton, display);
				
		// create a new scene - This will be the primary/main screen     
		Scene scene = new Scene(root, 400, 400, Color.LIGHTCYAN);
		
		//Operation Based on User Selection from the drop down
		continueButton.setOnAction(e ->                     
							{
								//Choice 1	
								if(choiceBox.getSelectionModel().isSelected(1))       
								{                               
									display.setText(sysInfo.displayDetails());                       
								}
								//Choice 2
								else if(choiceBox.getSelectionModel().isSelected(2))       
								{                               
									display.setText(sysInfo.displaySystemProperties());                       
								}
								//Choice 3
								else if(choiceBox.getSelectionModel().isSelected(3))       
								{                               
									display.setText(sysInfo.diagnoseSystem());                       
								}
								//Choice 4
								else if(choiceBox.getSelectionModel().isSelected(4))       
								{                               
									//create and configure new text field for screen - 2
									TextField memoryInput = new TextField();         
									memoryInput.setMaxWidth(50);         
									TextField hdInput = new TextField();         
									hdInput.setMaxWidth(50);
									
									//create and configure new display field (non-editable) for screen - 2
									TextArea display2 = new TextArea();        
									display2.setEditable(false);         
									display2.setMinSize(300,150);         
									display2.setMaxSize(300,150);
									
									//Labels for text fields
									Label memInput = new Label("Memory (MB)");         
									memInput.setTextFill(Color.BLUE);         
									memInput.setFont(Font.font("Helvetica", 16));         
									Label diskInput= new Label("Hard Disk (GB)");         
									diskInput.setTextFill(Color.BLUE);         
									diskInput.setFont(Font.font("Helvetica", 16));
									
									// create and configure a button to set Memory and Disk details         
									Button setInputButton = new Button();         
									setInputButton.setText("Set Details");        
									setInputButton.setOnAction( e1 ->                     
															{ // check that fields are not empty     
															if(memoryInput.getText().isEmpty() || hdInput.getText().isEmpty())        
															{                               
																display2.setText("Memory (MB) & Hard Disk (GB) Size - "
																		+ "\nBoth Inputs Required");                       
															}
															//check that fields are not 0
															else if (memoryInput.getText().equalsIgnoreCase("0") || hdInput.getText().equalsIgnoreCase("0"))        
															{                               
																display2.setText("Please enter a non-zero number");                       
															} 
															//check if the entries has only numbers
															else if (memoryInput.getText().matches("^[0-9]*") && hdInput.getText().matches("^[0-9]*"))
															{
																//conversion of string input to integer
																sysInfo.setMemory(Integer.parseInt(memoryInput.getText()));            
																sysInfo.setHardDisk(Double.parseDouble(hdInput.getText())); 
																
																//display the output  
																display2.setText("Memory size OK\t=>\t" + sysInfo.goodMemorySize()        
																+ "\n" + "Hard disk size\t\t=>\t "                                   
																		+ sysInfo.checkHDStatus());
																display2.appendText("\n===================================");
																display2.appendText("\nPlease press 'Main Menu' to continue re-selection"); 
																display2.appendText("\nPlease press 'Quit' to Terminate");
																display2.appendText("\n===================================");
															}
															//Error Handling - Takes care of Alphabets, AlphaNumeric and Special Char
															else                        
															{     
																display2.setText("Please enter numbers higher than Zero & no decimal");     
															}                                                                        
															}                                     
														); 
									
									//Create Quit Button
									Button quitButton = new Button();         
									quitButton.setText("Quit");        
									quitButton.setOnAction(e1 -> stage.close());
									
									//Create Back to Main Menu Button
									//This allows user to Go back to Screen 1 and Select some other options
									Button backButton = new Button();         
									backButton.setText("Main Menu");        
									backButton.setOnAction(e1 -> {
										stage.setScene(scene);
										//Reset Intial Value for the drop down - Avoids showing previous selection
										choiceBox.setValue("Please Select An Option & Click Continue");
										//Clears the Display field - Avoids showing previous outputs
										display.clear();
									});
									
									// create and configure an HBox for the labels and text inputs                       
									HBox inputComponents = new HBox(10);
									inputComponents.setAlignment(Pos.CENTER);        
									inputComponents.getChildren().addAll(memInput,memoryInput, diskInput, hdInput );
									
									HBox btnComponents = new HBox(10);
									btnComponents.setAlignment(Pos.CENTER);
									btnComponents.getChildren().addAll(setInputButton,backButton,quitButton);
									
									//create and configure VBox for screen -2
									VBox root2 = new VBox();         
									root2.setSpacing(15);         
									root2.setAlignment(Pos.CENTER);
									root2.setBackground(Background.EMPTY);
									root2.getChildren().addAll(inputComponents,btnComponents,display2); 
									
									//create scene for screen - 2
									Scene scene2 = new Scene(root2, 400, 400, Color.LIGHTCYAN);  
									
									//set scene
									stage.setScene(scene2);         
									stage.setTitle("Set System Info");        
									
									//show the stage
									stage.show();
								}
								//Choice - 5
								else if(choiceBox.getSelectionModel().isSelected(5))       
								{                              
									stage.close();
								} 
								else                        
								{      
									display.setText("Invalid Selecton..Try Again!");                         
								}                                                                        
							}                                     
						); 
		
		//add the scene to the stage, then configure the stage and make it visible        
		stage.setScene(scene);
		stage.setTitle("System Info Display");         
		stage.show();
	}
	
	//Main Method
	public static void main(String[] args) {
		
		launch(args);

	} //end of Main Method
}	//end of system test GUI class
	