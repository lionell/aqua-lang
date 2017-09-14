package aqua.datatypes;

import com.google.common.base.Preconditions;

public class Int32 implements Value {
    private int value;

    private Int32(int value) {
        this.value = value;
    }

    @Override
    public Int32 parse(String s) {
        return new Int32(Integer.parseInt(s));
    }

    @Override
    public Type getType() {
        return Type.Int32;
    }

    @Override
    public int compareTo(Value value) {
        Preconditions.checkArgument(value.getType() == Type.Int32);

        Int32 other = (Int32) value;
        return Integer.compare(this.value, other.value);
    }
}
