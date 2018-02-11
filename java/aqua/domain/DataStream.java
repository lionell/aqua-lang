package aqua.domain;

import aqua.datatypes.Value;
import com.google.common.collect.ImmutableList;

import java.util.Iterator;
import java.util.List;

public class DataStream implements Iterable<Tuple> {
  private ImmutableList<String> attributes; // TODO(ruslans): Deprecate this.
  private ImmutableList<Value.Type> types; // TODO(ruslans): Deprecate this.
  private Iterator<Tuple> iterator;

  public DataStream(List<String> attributes, List<Value.Type> types, Iterator<Tuple> iterator) {
    this.attributes = ImmutableList.copyOf(attributes);
    this.types = ImmutableList.copyOf(types);
    this.iterator = iterator;
  }

  @Override
  public Iterator<Tuple> iterator() {
    return iterator;
  }

  public ImmutableList<String> getAttributes() {
    return attributes;
  }

  public ImmutableList<Value.Type> getTypes() {
    return types;
  }
}
