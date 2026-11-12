
public class MorseCodeConverter {
	
	private static MorseCodeTree morseTree = new MorseCodeTree();
	
	public static String convertToEnglish(String s) {
		
	}
	
	public static String convertToEnglish(String filename) {
		
	}
	
	public static String printTree() {
		 String s = "";
		for(String n: morseTree.toArrayList()) {
			s += n + " ";
		}
		
		return s;
	}
}
