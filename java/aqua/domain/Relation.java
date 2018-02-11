package aqua.domain;

import aqua.common.Order;
import aqua.expressions.Condition;

import java.util.List;

public interface Relation {
  Relation orderBy(List<Order> attributesWithOrder);

  Relation where(Condition condition);

  Relation project(List<>);
}
