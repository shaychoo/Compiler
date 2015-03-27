package IC.AST;

/**
 * User-defined data type AST node.
 * 
 * @author Tovi Almozlino
 */
public class IntType extends Type {

	private String name;

	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}

	/**
	 * Constructs a new user-defined data type node.
	 *
	 * @param line
	 *            Line number of type declaration.
	 * @param name
	 *            Name of data type.
	 */
	public IntType(int line, String name) {
		super(line);
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
