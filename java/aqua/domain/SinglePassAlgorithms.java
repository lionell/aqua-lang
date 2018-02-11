package aqua.domain;

import aqua.common.Aggregation;
import aqua.common.Order;
import aqua.datatypes.Value;
import aqua.expressions.Condition;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static com.google.common.collect.ImmutableList.toImmutableList;

public class SinglePassAlgorithms {
  // Tuple-at-a-Time
  public static DataStream project(DataStream stream, List<Integer> attributes) {
    ImmutableList<String> newAttributes =
        attributes.stream().map(stream.getAttributes()::get).collect(toImmutableList());
    ImmutableList<Value.Type> newTypes =
        attributes.stream().map(stream.getTypes()::get).collect(toImmutableList());

    return new DataStream(
        newAttributes,
        newTypes,
        Iterators.transform(stream.iterator(), (Tuple t) -> t.project(attributes)));
  }

  // Tuple-at-a-Time
  public static DataStream select(DataStream stream, Condition condition) {
    Predicate<Tuple> predicate = (Tuple t) -> condition.check(toMap(stream.getAttributes(), t));
    return filterBy(stream, predicate);
  }

  private static Map<String, Value> toMap(List<String> attributeNames, Tuple t) {
    Map<String, Value> map = new HashMap<>();
    for (int i = 0; i < attributeNames.size(); i++) {
      map.put(attributeNames.get(i), t.get(i));
    }
    return map;
  }

  private static DataStream filterBy(DataStream stream, Predicate<Tuple> predicate) {
    Iterator<Tuple> filtered = Iterators.filter(stream.iterator(), predicate::test);
    return new DataStream(stream.getAttributes(), stream.getTypes(), filtered);
  }

  // Full-relation
  public static DataStream unique(DataStream stream) {
    Set<Tuple> seen = new HashSet<>();
    Predicate<Tuple> predicate =
        (Tuple t) -> {
          if (!seen.contains(t)) {
            seen.add(t);
            return true;
          }
          return false;
        };
    return filterBy(stream, predicate);
  }

  // Full-relation
  public static DataStream group(
      DataStream stream, List<Integer> groupingAttributes, List<Aggregation> aggregations) {
    // TODO(ruslans): Verify that there is no attribute that is not aggregated/grouped
    for (Tuple tuple : stream) {
      Tuple group = tuple.project(groupingAttributes);
    }
    // Figure out what to do with aggregations
    return null;
  }

  public static DataStream unionBag(DataStream stream1, DataStream stream2) {
    // TODO(ruslans): Verify that stream1 and stream2 have the same attributes
    return new DataStream(
        stream1.getAttributes(),
        stream1.getTypes(),
        Iterators.concat(stream1.iterator(), stream2.iterator()));
  }

  public static DataStream unionSet(DataStream stream1, DataStream stream2) {
    // Improve complexity of this operation by using set inplace and filter larger stream
    return unique(unionBag(stream1, stream2));
  }

  public static DataStream intersectionSet(DataStream stream1, DataStream stream2) {
    // Read smaller set into HashSet and then iterate over larger one outputting tuples that match
    return null;
  }

  public static DataStream order(DataStream stream, List<Order> attributes) {
  }
}
