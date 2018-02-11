package aqua.domain;

import aqua.common.Order;

import java.util.List;

public class InMemoryTable implements Relation {
  private List<Tuple> rows;

  public InMemoryTable(List<Tuple> rows) {
    this.rows = rows;
  }

  @Override
  public DataStream orderBy(List<Order> attributesWithOrder) {
    // SinglePassAlgorithms.order(rows.iterator(), attributesWithOrder);
    return null;
  }
}
