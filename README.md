# Aqua-lang

Aqua-lang data processing language inspired by [Kusto(Azure Log Analytics)](https://docs.loganalytics.io).

## Supported datatypes

- [x] int64
- [ ] float64
- [ ] char
- [x] string

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

### Project

```ebnf
project operator  = "project", new attribute, { ",", new attribute } ;
new attribute     = attribute, [ "=", expression ] ;
```

Example

```sql
T | project cost=price*quantity, price
```

### Where

```ebnf
where operator = "where", predicate ;
```

Example

```sql
T
| where fruit == "apple"
| where weight < 10 and available == true
```

### Join

```ebnf
join operator = "join", [ join parameters ], relation, "on", attribute ;
```

Example

```sql
T | join T1 on id
```

### Order by

```ebnf
order by operator    = "order by", attribute order, { ",", attribute order } ;
attribute order = attribute, [ "asc" | "desc" ] ;
```

Example

```sql
T | order by country asc, price desc
```

### Distinct

```ebnf
distinct operator = "distinct", attribute, [ ",", attribute ] ;
```

Example

```sql
T | distinct fruit, availability
```

### Take

### Others

```ebnf
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
