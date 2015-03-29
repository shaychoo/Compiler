package IC.AST;

import java.util.List;

/**
 * Created by NethanelS on 29/03/2015.
 */
public class WhileStatementsBlock extends StatementsBlock{

    private Expression condition;
    /**
     * Constructs a new statements block node.
     *
     * @param condition       Line number where block begins.
     * @param statements
     */
    public WhileStatementsBlock(Expression condition, List<Statement> statements) {
        super(condition.getLine(), statements);
        this.condition = condition;
    }

    public Expression getCondition() {
        return condition;
    }

}
