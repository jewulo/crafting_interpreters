package crafting_interpreters.lox;

// This class is used by the lox interpreter to simulate a return in the interpreter.
// It short cuts and clear the current execution stack with a throwable object,
// That object encapsulates the returned lox value.

public class Return extends RuntimeException {
    final Object value;

    public Return(Object value) {
        super(null, null, false, false);
        this.value = value;
    }
}
