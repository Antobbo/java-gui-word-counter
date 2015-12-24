/*WordCountTest.java
	WordCountTest to test the class
*/
import javax.swing.JFrame;
public class WordCountTest{
	public static void main(String[] args){
		WordCount wordCount = new WordCount();
		wordCount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//wordCount.setSize(900,800);
		wordCount.pack();
		wordCount.setVisible(true);
	}//end of main
}//end of WordCountTest
