package crafting_interpreters.lox;

import java.util.List;

public abstract class Expr {
    interface Visitor<R> {
    R visitBinaryExpr(Binary expr);
    R visitGroupingExpr(Grouping expr);
    R visitLiteralExpr(Literal expr);
    R visitUnaryExpr(Unary expr);
    }
    static class Binary extends Expr {
    public Binary(Expr left, Token operator, Expr right) {
    this.left = left;
    this.operator = operator;
    this.right = right;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitBinaryExpr(this);
    }

    final Expr left;
    final Token operator;
    final Expr right;
 }
    static class Grouping extends Expr {
    Grouping(Expr expression) {
    this.expression = expression;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitGroupingExpr(this);
    }

    final Expr expression;
 }
    static class Literal extends Expr {
    Literal(Object value) {
    this.value = value;
    }

    // I added this new empty constructor to help with returning an empty expression in
    // the primary() method of the Parse class in Parse.java
    //    public Literal() { value = null; }
    //    removed by the end of chapter 6

        @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitLiteralExpr(this);
    }

    final Object value;
 }
    static class Unary extends Expr {
    Unary(Token operator, Expr right) {
    this.operator = operator;
    this.right = right;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitUnaryExpr(this);
    }

    final Token operator;
    final Expr right;
 }

    abstract <R> R accept(Visitor<R> visitor);
}
