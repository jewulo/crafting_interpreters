package crafting_interpreters.visitor_pattern_example;

public class Beginet extends Pastry {
    @Override
    void accept(PastryVisitor visitor) {
        visitor.visitBeignet(this);
    }
}
