package IC.AST;

/**
 * Created by shay on 27/03/2015.
 */
public class EmptyStatement extends Statement {
    /**
     * Constructs a new statement node. Used by subclasses.
     *
     * @param line Line number of statement.
     */
    public EmptyStatement(int line) {
        super(line);
    }

    @Override
    public Object accept(Visitor visitor) {
        return null;
    }
}
