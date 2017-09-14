package aqua.domain;

import aqua.common.SortingOrder;
import aqua.expressions.Expression;
import aqua.expressions.Predicate;

import java.util.List;

public interface Relation extends Iterable<Tuple> {
    Relation orderBy(String attribute, SortingOrder order);
    Relation where(Predicate predicate);
    Relation project(List<String> newAttributes, List<Expression> definitions);
    Relation distinct(List<String> attributes);
    Relation take(int number);
    Relation join(Relation relation, List<String> leftAttributes, List<String> rightAttributes);
    Relation union(Relation relation);
}
