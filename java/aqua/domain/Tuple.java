package aqua.domain;

import aqua.datatypes.Value;

import java.util.List;

public class Tuple {
    private List<Value> values;

    public Value get(int index) {
        return values.get(index);
    }
}
