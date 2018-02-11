# Aqua-lang

Aqua-lang data processing language inspired by [Kusto(Azure Log Analytics)](https://docs.loganalytics.io).

## Supported datatypes

- [x] int64
- [ ] float64
- [ ] char
- [x] string

## Extended BNF

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

### Project operator

Select the columns to include, rename or drop, and insert new computed columns.

The order of the columns in the result is specified by the order of the arguments. Only the columns specified in the arguments are included in the result: any others in the input are dropped.

```sql
Fruits
| project
    price,               -- Just project
    cost=price*quantity, -- Compose new column
    count=quantitiy      -- Rename column
```

#### Syntax

```ebnf
project operator  = "project", new attribute, { ",", new attribute } ;
new attribute     = attribute, [ "=", expression ] ;
```

### Where operator

Filters a table to the subset of rows that satisfy a predicate.

```sql
Fruits
| where name == "apple"
| where weight < 10 and available == true
```

#### Syntax

```ebnf
where operator = "where", condition ;
```

### Join operator

Merge the rows of two tables to form a new table by matching values of the specified column(s) from each table.

```sql
Fruits
| join Market on id
| order by name asc, price desc
```

#### Syntax

```ebnf
join operator = "join", [ join parameters ], relation, "on", attribute ;
join parameters = "kind", "=", [ "inner" | "outer" | "full" ] ;
```

### Order-by operator

```ebnf
order by operator = "order by", attribute order, { ",", attribute order } ;
attribute order   = attribute, [ "asc" | "desc" ] ;
```

Example

```sql
Fruits | order by weight desc, price asc
```

### Distinct

```ebnf
distinct operator = "distinct", attribute, [ ",", attribute ] ;
```

Example

```sql
Fruits | distinct name, availability
```

### Take operator

Return up to the specified number of rows.

```sql
Fruits
| order by price asc
| take 10
```

#### Syntax

```ebnf
take operator = "take" number ;
```

### Others

```ebnf
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

## School assignment coverage

0+, 1+, 2+, 3-, 4-, 5+, 6?(unconditioned join), 7+, 8+, 9+

## TODO

- Provide more meaningful examples in README

## Note

Some information on this README page is taken from [Language Reference](https://docs.loganalytics.io/docs/Language-Reference).