/*WordCount.java
Application determines how many times a word has occurred in the text given
*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.*;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.StringTokenizer;
import java.awt.Dimension;//to sort specify the dimension
public class WordCount extends JFrame{
	private JTextArea textInput;
	private JTextArea textOutput;
	private JButton processButton;
	private JButton clearButton;
	private JLabel instructions;
	private GridBagLayout gbLayout;
	/* private GridBagConstraints inputConstraints;//declare constraints input textAea
	private GridBagConstraints outputConstraints;//declare constraints output textArea
	private GridBagConstraints CountConstraints;//declare constraints count button
	private GridBagConstraints ClearConstraints;//declare constraints clear button
	private GridBagConstraints instructionsConstraints;//declare constraints JLabel */
	private String stringToTest;//holds string pasted in textarea
	private String[] tokens;//array of tokenized strings
	Map<String,Integer> mp = new HashMap<String, Integer>();//declaring a map object
	public WordCount(){
		super("Word count application");
		gbLayout = new GridBagLayout();//create new GBL object
		setLayout(gbLayout);//set JFrame GBL
		textInput = new JTextArea(10,12);//holds the input text
		textOutput = new JTextArea(10,15);//hold the output text
		textOutput.setMargin(new Insets(5,5,5,5));//sets margins inside the element
		textInput.setMargin(new Insets(5,5,5,5));//sets margins inside the element
		stringToTest = "";//initialize to empty string
		processButton = new JButton("Count");//action abutton
		clearButton = new JButton("Clear");//to clear textArea
		instructions = new JLabel("Copy and paste text in the below text area, click Count to count the words.\n");//holding instructions		
		textInput.setText("");//initialize to empty string
		textOutput.setText("");//initialize to empty string
		
		
		
		add(instructions, new GridBagConstraints(0,0,2,1,0,0,CENTER,HORIZONTAL, new Insets(10,15,10,15),0,0));//adding instruction jlabel and constraints
		//shouldn't grow vertically, where is the padding on the left
		add(new JScrollPane(textInput), new GridBagConstraints(0,1,2,1,0.5,0.5,CENTER,BOTH,new Insets(10,15,10,15),10,10));//adding textInput and constraints
		add(processButton, new GridBagConstraints(0,2,1,1,1.0,1.0,CENTER,HORIZONTAL,new Insets(10,15,10,15),1,1));//adding processButton and constraints
		add(clearButton, new GridBagConstraints(1,2,1,1,1.0,1.0,CENTER,HORIZONTAL,new Insets(10,15,10,15),1,1));//adding clearButton and constraints
		add(new JScrollPane(textOutput), new GridBagConstraints(0,3,2,1,0.5,0.5,CENTER,BOTH,new Insets(10,15,10,15),1,1));//adding textOutput		
		
		/* textOutput.setMargin(new Insets(5,5,5,5));//sets margins inside the element
		textInput.setMargin(new Insets(5,5,5,5));//sets margins inside the element */
		
		ProcessButtonHandling handler1 = new ProcessButtonHandling();
		ClearButtonHandling handler2 = new ClearButtonHandling();
		processButton.addActionListener(handler1);
		clearButton.addActionListener(handler2);
	}//end of constructor
	public String getString(){
		return stringToTest;
	}
	//inner class for event handlings
	private class ProcessButtonHandling implements ActionListener{
		public void actionPerformed(ActionEvent event){
			stringToTest = textInput.getText();
			processString(getString());//call function to split string
			countWords();//count words and place results in the hashmap
			printMap();//print the map values and keys in the textArea
		}//end of actionPerformed
	}//end of inner class
	private class ClearButtonHandling implements ActionListener{
		public void actionPerformed(ActionEvent event){
			textOutput.setText("");
			textInput.setText("");
		}//end of actionPerformed
	}//end of inner class
	public void processString(String testingString){		
		//String[] tokens = testingString.split("(?=[,.])|\\s+");
		testingString = testingString.replaceAll("[,.;:]","");//remove the characters in brackets and replace them with nothing
		tokens = testingString.split(" ");//split string using space as delimiter
		/* System.out.printf("Number of elements: %d\nTokens are \n", tokens.length);
		//print to test
		for(String token : tokens){
			System.out.println(token);
		}	 */	
	}
	public void countWords(){
		for(int i = 0; i < tokens.length; i++){
			if(mp.containsKey(tokens[i])){
				//increment Integer
				mp.put(tokens[i], mp.get(tokens[i]) + 1);//add it to the hashmap and increment integer
			} 
			else{
				mp.put(tokens[i],1);//add it to the hashmap
			}
		}
		/* for (String token : tokens) {
             mp.put(token, mp.getOrDefault(token, 0) + 1);
        } */
	}
	public void printMap(){
		for(Map.Entry<String, Integer> entry : mp.entrySet()){//loop thru map to print data
			//System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			textOutput.append("Key = " + entry.getKey() + ",\t Value = " + entry.getValue() + "\n");
			System.out.println("Key = " + entry.getKey() + ",\t Value = " + entry.getValue()+ "\n");//for debug purposes
		}
	}
}//end of WordCount
