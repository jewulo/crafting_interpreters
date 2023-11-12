package crafting_interpreters.visitor_pattern_example;

abstract public class Pastry {
    abstract void accept(PastryVisitor visitor);
}
