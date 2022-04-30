import java.util.*;

/**
 * WordCountNode class - The data portion of the linked list
 */
class WordCountNode {
	String word;
	int count;
		
	/**
	 * WordCountNode constructor
	 * @param inWord
	 */
	public WordCountNode(String inWord) {
		word = inWord;
		count = 1;
	}	
	
	/**
	 * @return the object word datum
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * @return the object count datum
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @return the object count auto-incremented
	 */
	public int incrementCount() {
		count++;
		return count;
	}
}

/**
 * 
 * @author Zach Polk
 * 
 * Description: The implementation of WordList
 * using a Linked List.
 */
public class WordLinkedList extends WordList{
	
	static LinkedList<WordCountNode> words =
			new LinkedList<WordCountNode>();
	
	/**
	 * Public constructor method WordLinkedList
	 */
	public WordLinkedList() {
		super();
		
	}
	
	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
	public int findWord(String inWord) {
		boolean newWord = false;
		ListIterator<WordCountNode> wli = words.listIterator(); 
		
		while(wli.hasNext()) {
			WordCountNode n = (WordCountNode) wli.next();
			if(inWord.compareTo(n.getWord())==0) {
				newWord = true;
				return n.getCount();
			} 
		}
		return 0;
	}
	
	/**
	 * Public method existsWord
	 * @param inWord String
	 * @return True if inWord exists in WordList
	 */
	public boolean existsWord(String inWord) {
		if (findWord(inWord) == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Public method addWord
	 * @param inWord String
	 * @return 1 if inWord not found, new inWord count if found
	 */
	public int addWord(String inWord) {
		boolean newWord = false;
		ListIterator<WordCountNode> wli = words.listIterator(); 
		
		while(wli.hasNext()) {
			WordCountNode n = (WordCountNode) wli.next();
			if(inWord.compareTo(n.getWord())==0) {
				newWord = true;
				n.incrementCount();
				super.incTotalAllWords();
				return n.getCount();
			}
		}
		if(!newWord) {
			super.incNumUniqueWords();
			super.incTotalAllWords();
			words.add(new WordCountNode(inWord));
		}
		return  1;
	}
	
	/**
	 * Public method incWord
	 * @param inWord String
	 * @return 0 if inWord not found, new inWord count if found
	 */
	public int incWord(String inWord) {
		boolean newWord = false;
		ListIterator<WordCountNode> wli = words.listIterator(); 
		
		while(wli.hasNext()) {
			WordCountNode n = (WordCountNode) wli.next();
			if(inWord.compareTo(n.getWord())==0) {
				newWord = true;
				super.incTotalAllWords();
				n.incrementCount();
				return n.getCount();
			}
		}
		return 0;
	}
	
	/**
	 * Public method printWordList
	 * @param inMinimum int
	 */
	public void printWordList(int inMinimum) {
		ListIterator<WordCountNode> pnt = words.listIterator();
		
		System.out.println(super.toString());
		while(pnt.hasNext()) {
			WordCountNode ret = (WordCountNode) pnt.next();
			if(ret.getCount() >= inMinimum) {
				System.out.println(ret.getWord() + " : " + ret.getCount());
			}
		}
	}
	
	/**
	 * Public string method toString
	 * @return A string with Unique Words and Total Word Count
	 */
	public String toString() {
		return super.toString();
	}
}
