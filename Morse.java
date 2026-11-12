
public class Morse {
	void main() {
		MorseCodeTree tree = new MorseCodeTree();
		
		String word = "--. .. ...- . -- . -.-- --- ..- .-. .- -. ... .-- . .-. -.. ---";
		String[] split = word.split(" ");
		String code = "";
		
		for(int i = 0; i < split.length; i++) {
			code += tree.fetch(split[i]);
		}
		
		System.out.println(code);
	}
}
