/**
 * 
 * @author Zach Polk
 */
public class WordListMain {
	/**
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args) {
		
		WordArrayList wl;
		WordLinkedList al;
		WordHashMap hm;
		
		wl = new WordArrayList();
		al = new WordLinkedList();
		hm = new WordHashMap();

		al.addWord("Polk");
		al.addWord("Polk");
		al.addWord("Zach");
		al.addWord("Elisha");
		al.addWord("Zach");
		al.addWord("Elisha");
		al.addWord("John");
		al.incWord("Zach");

		System.out.println("find: " + al.findWord("Zach"));
		System.out.println("find: " + al.findWord("Polk"));
		System.out.println("find: " + al.findWord("Tanner"));
		System.out.println("exists: " + al.existsWord("Zach"));
		System.out.println("exists: " + al.existsWord("Polk"));
		System.out.println("exists: " + al.existsWord("Tanner"));
		al.printWordList(1);
	}
}