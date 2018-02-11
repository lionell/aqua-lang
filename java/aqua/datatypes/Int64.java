package aqua.datatypes;

import com.google.common.base.Preconditions;

public class Int64 implements Value {
  private long value;

  private Int64(long value) {
    this.value = value;
  }

  @Override
  public Int64 parse(String s) {
    return new Int64(Integer.parseInt(s));
  }

  @Override
  public Type getType() {
    return Type.INT64;
  }

  @Override
  public int compareTo(Value value) {
    Preconditions.checkArgument(value.getType() == Type.INT64);

    Int64 other = (Int64) value;
    return Long.compare(this.value, other.value);
  }
}
