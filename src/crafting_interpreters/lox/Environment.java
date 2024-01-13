package crafting_interpreters.lox;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    final Environment enclosing;
    private final Map<String, Object> values = new HashMap<>();

    Environment() {
        this.enclosing = null;
    }

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    void define(String name, Object value) {
        // See book page 120 for variable reuse
        values.put(name, value);
    }

    Object get(Token name) {
        // search the local environment (local scope)...
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        }

        // ...if not found in local scope, then search outer scope or enclosing scope...
        if (enclosing != null) return enclosing.get(name); // this is object/data recursion on functional recursion

        // ...otherwise we have an exception, variable is undefined
        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");

        // note:
        //
        /*
            { // enclosing scope
                { // local scope
                }
            }
        **/
    }

    void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, value);
            return;
        }

        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }

        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }


}
