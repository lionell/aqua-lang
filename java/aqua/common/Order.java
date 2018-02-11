package aqua.common;

public class Order {
  private Type type;
  private int attribute;

  public enum Type {
    ASC,
    DESC,
  }
}
