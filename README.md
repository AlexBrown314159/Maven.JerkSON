## WELCOME TO TARIQ'S PainfullAfternoon (Hurtlocker.JerkSON)
* **Objective:** To implement a `GroceryReporter` capable of parsing `JerkSON` and formatting to a string
* **Purpose:** To gain familiarity with [regex](https://en.wikipedia.org/wiki/Regular_expression) and [payload](https://en.wikipedia.org/wiki/Payload_(computing)) parsing

# You will need all of these today!
In this project you will find a file in the `resource` directory named `RawInput.JerkSON`.
It was supposed to be a grocery list formated in `JSON`. However, Tariq, your fearless yet petty leader decided to come reformat it in his own Object Notation. `JerkSON`... you are welcome.

## JSON Format
* In `JSON`,
  * _keys_ are encapsulated by quotes
  * _values_ are encapsulated by quotes (unless numeric)
  * _key_ and _value_ are seperated by a colon.
  * _key and value pairs_ are seperated by a comma.

```json
{
  "name" : "Milk",
  "price" : 3.25
  "type" : "food"
  "expiration" : "01/24/2016" 
}
```

## JerkSON Format
* Just like `JSON`, `JerkSON` is a [_key-value-pair-data-store_](https://en.wikipedia.org/wiki/Attribute%E2%80%93value_pair).
* In `JerkSON`,
  * _keys_ are encapsulated by quotes
  * _values_ are encapsulated by quotes (unless numeric)
  * _key_ and _value_ are seperated by any of the following (`:`, `@`, `^`, `*`, `%`)
  * _key and value pairs_ are seperated by a `##`.

```
NaMe:egGS;prICE:3.23;typE:foOd;eXPiRAtIOn:1/24/2016##
```

## Some tidbits
All string manipulation should be achieved through regex to detect and match patterns.
Its not guranteed that every Key will have a Value, and every Value will have a pair. For instance:

you may see something like this
`Name:Milk;Price:3.23;type:;expiration:1/24/2016##`

Notice how TYPE has a key but no Value.... if you try and parse this into an object your program could crash.
You will need to handle your exceptions!
I also expect you to report on how many exceptions you saw while parsing the data.
GOOD LUCK ZIPCODERS!!!! My the Odds be ever in your favor!!!!

