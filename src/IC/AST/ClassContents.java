package IC.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shay on 24/03/2015.
 */
public class ClassContents  {
    List<Field> fields = new ArrayList<Field>();
    List<Method> methods = new ArrayList<Method>();

    public ClassContents(){}

    public ClassContents(List<Field> fields, List<Method> methods) {
        this.fields = fields;
        this.methods = methods;
    }

    public List<Field> getFields() {
        return fields;
    }
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
    public List<Method> getMethods() {
        return methods;
    }
    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }
}
