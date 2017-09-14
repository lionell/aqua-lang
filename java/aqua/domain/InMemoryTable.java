package aqua.domain;

import aqua.common.SortingOrder;
import aqua.datatypes.Value.Type;
import aqua.expressions.Expression;
import aqua.expressions.Predicate;
import com.google.common.collect.ImmutableList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.ImmutableList.toImmutableList;

public class InMemoryTable implements Relation {
    private ImmutableList<String> attributes;
    private ImmutableList<Type> types;
    private List<Tuple> tuples;

    private InMemoryTable(ImmutableList<String> attributes, ImmutableList<Type> types, List<Tuple> tuples) {
        this.attributes = attributes;
        this.types = types;
        this.tuples = tuples;
    }

    @Override
    public Relation orderBy(String attribute, SortingOrder order) {
        int index = attributes.indexOf(attribute);
        if (index == -1) {
            throw new IllegalArgumentException("Can't find attribute with name '" + attribute + "'");
        }
        return orderBy(index, order);
    }

    private Relation orderBy(int index, SortingOrder order) {
        Comparator<Tuple> comparator = Comparator.comparing(a -> a.get(index));
        if (order == SortingOrder.DESC) {
            comparator = comparator.reversed();
        }

        ImmutableList<Tuple> rows =
                tuples.stream()
                        .sorted(comparator)
                        .collect(toImmutableList());
        return new InMemoryTable(attributes, types, rows);
    }

    @Override
    public Relation where(Predicate predicate) {
        return null;
    }

    @Override
    public Relation project(List<String> newAttributes, List<Expression> definitions) {
        return null;
    }

    @Override
    public Relation distinct(List<String> attributes) {
        return null;
    }

    @Override
    public Relation take(int number) {
        return null;
    }

    @Override
    public Relation join(Relation relation, List<String> leftAttributes, List<String> rightAttributes) {
        return null;
    }

    @Override
    public Relation union(Relation relation) {
        return null;
    }

    @Override
    public Iterator<Tuple> iterator() {
        return tuples.iterator();
    }
}
