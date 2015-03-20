package IC.Parser;

import java_cup.runtime.Symbol;
import java.util.ArrayList;

public class Token extends Symbol {


    private int id;
    private int line;
    private int column;
    private String value;
    private String IDName;

    public Token(int id, int line) {
        super(id, null);
        this.id = id;
        this.line = line+1;
    }

    public Token(int id, int line,String value) {
        super(id, null);
        this.id = id;
        this.line = line +1;
        this.value = value;
    }

    public Token(int id, int line,int column, String value) {
        super(id,null);
        this.id = id;
        this.line = line +1;
        this.column = column;
        this.value = value;

    }

    public String toString() {
        return value  + "\t" + getTag(this.id) +"\t"+ line + ":" + this.column;
    }


    public int getVal()
    {
        return this.id;
    }

    public String getTag(int tagId) {
        ArrayList<String> tokenList = new ArrayList<String>();
        tokenList.add("(");
        tokenList.add(")");
        tokenList.add("while");
        tokenList.add(" ");
        tokenList.add("=");
        tokenList.add("NEW_LINE");
        tokenList.add("boolean");
        tokenList.add("ID");
        tokenList.add("break");
        tokenList.add("class");
        tokenList.add("CLASS_ID");
        tokenList.add(",");
        tokenList.add("continue");
        tokenList.add("/");
        tokenList.add(".");
        tokenList.add("==");
        tokenList.add("extends");
        tokenList.add("else");
        tokenList.add("false");
        tokenList.add(">");
        tokenList.add(">=");
        tokenList.add("void");
        tokenList.add("if");
        tokenList.add("int");
        tokenList.add("INTEGER");
        tokenList.add("&&");
        tokenList.add("[");
        tokenList.add("{");
        tokenList.add("lentgh");
        tokenList.add("new");
        tokenList.add("!");
        tokenList.add("||");
        tokenList.add("<");
        tokenList.add("<=");
        tokenList.add("-");
        tokenList.add("%");
        tokenList.add("*");
        tokenList.add("!=");
        tokenList.add("null");
        tokenList.add("+");
        tokenList.add("]");
        tokenList.add("}");
        tokenList.add("return");
        tokenList.add(";");
        tokenList.add("static");
        tokenList.add("string");
        tokenList.add("QUOTE");
        tokenList.add("this");
        tokenList.add("true");



        return tokenList.get(tagId-1);
    }
}

