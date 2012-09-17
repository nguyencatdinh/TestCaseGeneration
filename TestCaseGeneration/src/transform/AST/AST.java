package transform.AST;

import transform.CodeGeneration.Visitor;

public abstract class AST
        implements Cloneable
{
    public AST parent;
    public int line;
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    
    abstract public Object visit(Visitor a, Object o) throws CompilationException;
}
