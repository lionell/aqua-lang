# Aqua-lang

Aqua-lang data processing language inspired by [Kusto(Azure Log Analytics)](https://docs.loganalytics.io).

## Supported datatypes

- int32
- int64
- float64
- char
- string

## EBNF

```ebnf
statement = relation, { "|", operator } ;
operator  = order by operator
          | where operator
          | project operator
          | distinct operator
          | take operator
          | join operator
          | union operator ;
```

## Order by

```ebnf
order by operator    = "order by", attribute order pair, { ",", attribute order pair } ;
attribute order pair = attribute, [ "asc" | "desc" ] ;
```

Example

```sql
T | order by country asc, price desc
```

## Where

```ebnf
where operator = "where", predicate ;
```

Example

```sql
T
| where fruit == "apple"
| where weight < 10 and available == true
```

## Project

```ebnf
project operator              = "project", attribute or name expression, [ ",", attribute or named expression ] ;
attribute or named expression = attribute
                              | named expression ;
named expression              = attribute, "=", expression ;
```

Example

```sql
T | project cost=price*quantity, price
```

## Others

```ebnf
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