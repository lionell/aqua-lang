package aqua.datatypes;

import com.google.common.base.Preconditions;

public class Str implements Value {
  private String value;

  private Str(String value) {
    this.value = value;
  }

  @Override
  public Str parse(String s) {
    return new Str(s);
  }

  @Override
  public Type getType() {
    return Type.STRING;
  }

  @Override
  public int compareTo(Value value) {
    Preconditions.checkArgument(value.getType() == Type.STRING);

    Str other = (Str) value;
    return this.value.compareTo(other.value);
  }
}
