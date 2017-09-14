package aqua.datatypes;

public interface Value extends Comparable<Value> {
    Value parse(String s);
    Type getType();

    enum Type {
        Int32,
        Float32,
    }
}
