package aqua.datatypes;

public interface Value extends Comparable<Value> {
  Value parse(String s);

  Type getType();

  enum Type {
    INT64,
    FLOAT64,
    CHAR,
    STRING
  }
}
