package aqua.domain;

import aqua.datatypes.Value;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

import static com.google.common.collect.ImmutableList.toImmutableList;

public class Tuple {
  private ImmutableList<Value> values;

  public Tuple(ImmutableList<Value> values) {
    this.values = values;
  }

  public Value get(int index) {
    return values.get(index);
  }

  public Tuple project(List<Integer> attributes) {
    ImmutableList<Value> newValues =
        attributes.stream().map(values::get).collect(toImmutableList());
    return new Tuple(newValues);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Tuple tuple = (Tuple) o;
    return Objects.equals(values, tuple.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }
}
