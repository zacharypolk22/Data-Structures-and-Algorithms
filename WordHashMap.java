import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * @author Zach Polk
 * 
 * Description: The implementation of WordList
 * using a Hash Map.
 */
public class WordHashMap extends WordList{
	static HashMap<String, Integer> wordsHash =
			new HashMap<String, Integer>();
	
	/**
	 * Public constructor method WordHashMap
	 */
	public WordHashMap() {
		super();
	}
	
	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
	public int findWord(String inWord) {
		if(wordsHash.containsKey(inWord)==true) {
			return wordsHash.get(inWord);
		}else {
			return 0;
		}
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
		if(wordsHash.containsKey(inWord)==true) {
			super.incTotalAllWords();
			wordsHash.replace(inWord, wordsHash.get(inWord)+1);
			return wordsHash.get(inWord);
		}else {
			super.incTotalAllWords();
			super.incNumUniqueWords();
			wordsHash.put(inWord, 1);
			return wordsHash.get(inWord);
		}
	}
	
	/**
	 * Public method incWord
	 * @param inWord String
	 * @return 0 if inWord not found, new inWord count if found
	 */
	public int incWord(String inWord) {
		if(wordsHash.containsKey(inWord)==true) {
			super.incTotalAllWords();
			wordsHash.replace(inWord, wordsHash.get(inWord)+1);
			return wordsHash.get(inWord);
		}
		
		return 0;
	}
	
	/**
	 * Public method printWordList
	 * @param inMinimum int
	 */
	public void printWordList(int inMinimum) {
		if (wordsHash.size() > 0) {
			System.out.println(super.toString());
			Iterator<Entry<String, Integer> > hash 
					= wordsHash.entrySet().iterator();
			while(hash.hasNext()) {
				Map.Entry<String, Integer> newMap 
					= (Map.Entry<String, Integer>) hash.next();
				if(newMap.getValue() >= inMinimum) {
					System.out.println(newMap.getKey() + " : " 
							+ newMap.getValue());
				}
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
