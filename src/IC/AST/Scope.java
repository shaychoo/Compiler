package IC.AST;

/**
 * Created by shay on 27/03/2015.
 */
public class Scope extends ASTNode {
    /**
     * Constructs an AST node corresponding to a line number in the original
     * code. Used by subclasses.
     *
     * @param line The line number.
     */
    protected Scope(int line) {
        super(line);
    }

    @Override
    public Object accept(Visitor visitor) {
        return null;
    }
}
