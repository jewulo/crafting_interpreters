package crafting_interpreters.lox.chapter_5;

public class Token {
    final TokenType type;
    final String lexeme;
    final Object literal;
    final int line;

    Token(TokenType type, String lexeme, Object literal, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    public String tostring() {
        return type + " " + lexeme + " " + literal;
    }
}
