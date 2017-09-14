# Aqua-lang
Aqua-lang data processing language inspired by [Kusto(Azure Log Analytics)](https://docs.loganalytics.io).

## Supported datatypes

- int32
- int64
- float64
- char
- string

## EBNF

```(ebnf)
statement     = relation , { "|" , operator };
<Operator>  ::= <OrderByOperator>
              | <WhereOperator>
              | <ProjectOperator>
              | <DistinctOperator>
              | <TakeOperator>
              | <JoinOperator>
              | <UnionOperator>
```

## Order by
```
<OrderByOperator>     ::= "order by" <AttributeOrderPair> {"," <AttributeOrderPair>}
<AttributeOrderPair>  ::= <Attribute> ["asc" | "desc"]
```

### Example
```

```


<WhereOperator>     ::= "where" <Predicate>
<ProjectOperator>   ::= "project" <AttributeList>
<DistinctOperator>  ::= "distinct" <AttributeList>
<TakeOperator>      ::= "take" <Number>
<JoinOperator>      ::= "join" <Relation> "on" <JoinCondition> {"," <JoinCondition>}
<JoinCondition>     ::= <Relation> "." <Attribute> "==" <Relation> "." <Attribute>
<UnionOperator>     ::= "union" <Relation> {"," <Relation>}

<Predicate> ::= <Expression> "==" <Expression>
              | <Expression> "!=" <Expression>
              | <Expression> ">" <Expression>
              | <Expression> "<" <Expression>
<Expression> ::= ???
<AttributeList> ::= <Attribute> {"," <Attribute>}
                  | "*"
```

## Assignment coverage
0+, 1+, 2+, 3-, 4-, 5+, 6?(unconditioned join), 7+, 8+, 9+