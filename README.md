# Aqua-lang

Aqua-lang data processing language inspired by [Kusto(Azure Log Analytics)](https://docs.loganalytics.io).

## Supported datatypes

- int32
- int64
- float64
- char
- string

## EBNF

```(bnf)
<Statement> ::= <Relation> {"|" <Operator>}
<Operator>  ::= <OrderByOperator>
              | <WhereOperator>
              | <ProjectOperator>
              | <DistinctOperator>
              | <TakeOperator>
              | <JoinOperator>
              | <UnionOperator>
```

## Order by

```(bnf)
<OrderByOperator>     ::= "order by" <AttributeOrderPair> {"," <AttributeOrderPair>}
<AttributeOrderPair>  ::= <Attribute> ["asc" | "desc"]
```

Example

```(sql)
T | order by country asc, price desc
```

## Where

```(bnf)
<WhereOperator> ::= "where" <Predicate>
```

Example

```(sql)
T
| where fruit == "apple"
| where weight < 10 and available == true
```

## Project

```(bnf)
<ProjectOperator>               ::= "project" <AttributeOrNamedExpression> ["," <AttributeOrNamedExpression>]
<AttributeOrNamedExpression>    ::= <Attribute>
                                  | <NamedExpression>
<NamedExpression>               ::= <Attribute> "=" <Expression>
```

Example

```(sql)
T | project cost=price*quantity, price
```

## Others

```(bnf)
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

## TODO

- Provide more meaningful examples in README