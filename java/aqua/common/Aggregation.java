package aqua.common;

public class Aggregation {
  private int attribute;
  private Type type;

  public enum Type {
    MIN,
    MAX,
    COUNT,
    SUM,
    AVG
  }
}
