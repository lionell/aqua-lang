package aqua.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CachedIterator<T> implements Iterable<T> {
  private List<T> cache = new ArrayList<>();

  public CachedIterator(Iterator<T> iterator) {
    // TODO(ruslans): Implement lazy cached iterator.
    while (iterator.hasNext()) {
      cache.add(iterator.next());
    }
  }

  @Override
  public Iterator<T> iterator() {
    return cache.iterator();
  }
}
