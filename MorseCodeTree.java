import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root;
	
	public MorseCodeTree() {
		buildTree();
	}
	
	
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(this.root == null && root != null) {
			this.root = root;
		}
		
		if(code.isEmpty()) {
			throw new IllegalArgumentException("Unable to Identify the Provided Morse Code");
		}
		
		char c = code.charAt(0);
		if(code.length() == 1) {
			if(c == '.') {
				if(root.left == null) {
					root.left = new TreeNode<>(letter);
				} else {
					root.left.data = letter;
				}
			}
			
			if(c == '-') {
				if(root.right == null) {
					root.right = new TreeNode<>(letter);
				}else {
					root.right.data = letter;
				}
			}
			return;
		}
		
		if(c == '.') {
			if(root.left == null) {
				root.left = new TreeNode<>("");
			}
			addNode(root.left, code.substring(1), letter);
		}
		
		if(c == '-') {
			if(root.right == null) {
				root.right = new TreeNode<>("");
			}
			addNode(root.right, code.substring(1), letter);
		}
	}
	
	@Override
	public void buildTree() {
		this.root = new TreeNode<>("");
	
		String[] morseCode = {
			    ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
			    "..", ".---", "-.-", ".-..", "--", "-.", "---",
			    ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
			    ".--", "-..-", "-.--", "--.."
			};

		String[] letters = {
				  	"a", "b", "c", "d", "e", "f",
				    "g", "h", "i", "j", "k", "l",
				    "m", "n", "o", "p", "q", "r",
				    "s", "t", "u", "v", "w", "x",
				    "y", "z"
			};
		
		for(int i = 0; i < morseCode.length; i++) {
			insert(morseCode[i], letters[i]);
		}
	}
	
	@Override
	public String fetch(String code) {
		String fetched = fetchNode(this.root, code);
		return fetched;
	}
	
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(root == null) {
			throw new IllegalArgumentException("Null Reference");
		}

		char c = code.charAt(0);
		if(code.length() == 1) {
			if(c == '.') {
				return root.left.data;
			}
			
			if(c == '-') {
				return root.right.data;
			}
		}
		
		if(c == '.') {
			return fetchNode(root.left, code.substring(1));
		}
		
		if(c == '-') {
			
			return fetchNode(root.right, code.substring(1));
		}
		
		throw new IllegalArgumentException("Invalid Tree Path");
	}
	
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}

	@Override
	public void insert(String code, String result) {
		if(this.root == null) {
			this.root = new TreeNode<>(result);
		}
		addNode(this.root, code, result);
	}
	
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null) {
			return;
		}
		
		LNRoutputTraversal(root.left, list);
		list.add(root.data);
		LNRoutputTraversal(root.right, list);

	}
	
	@Override
	public void setRoot(TreeNode<String> newNode) {
		if(newNode == null) {
			throw new IllegalArgumentException("Invalid Node Pointer: \"Null\"");
		}
		
		this.root = newNode;
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(this.root, list);
		return list;
	}



	@Override
	public LinkedConverterTreeInterface delete(String data) {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface update() {
		throw new UnsupportedOperationException();
	}
}
