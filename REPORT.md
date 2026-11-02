\#

1a.

  -----------------------------------------------------------------------
  \#                Method            Part of the text  Returns
  ----------------- ----------------- ----------------- -----------------
  1                 parseValue        the whole text    The whole HashMap

  2                 parseObject       the whole text    A HashMap
                                                        containing "a"
                                                        and "c"

  3                 parseValue        \[1, {"b":        An ArrayList
                                      true}\]           containing 1 and
                                                        the object {"b":
                                                        true}

  4                 parseArray        \[1, {"b":        An ArrayList
                                      true}\]           containing 1 and
                                                        the object {"b":
                                                        true}

  5                 parseValue        1                 The integer 1

  6                 parseValue        {"b": true}       A HashMap
                                                        containing "b"
                                                        mapped to true

  7                 parseObject       {"b": true}       A HashMap
                                                        containing "b"
                                                        mapped to true

  8                 parseValue        true              The Boolean value
                                                        true

  9                 parseValue        {}                An empty HashMap

  10                parseObject       {}                An empty HashMap
  -----------------------------------------------------------------------

1b. (1)

The maximum number of these calls in progress at the same time is 7.
This happens when the parser reaches true. The calls in progress are the
outer parseValue, outer parseObject, parseValue for the array,
parseArray, parseValue for the inner object, parseObject for the inner
object, and parseValue for true.

1c. (1)

The base cases consists of numbers handled by parseNumber, strings
handled by parseString, and literals such as true, false, and null
handled by parseLiteral. These values do not require parsing another
object or array.

2a. (2)

A HashMap lookup is quick because hashCode() is used to determine the
bucket where a key should be stored. This allows the program to search a
user's count in O(1) average time. If the counts were stored in an
ArrayList of (user, count) pairs, the program would have to search
through the pairs until it found the correct user, which would take O(n)
time.

2b. (1)

A HashMap lookup can become slow when many keys face hash collisions and
end up in the same bucket. In the worst case, the lookup can approach
O(n).

2c. (1)

Using Object as the value type means the program does not automatically
know the specific type of a value. The code may need to cast the value
to a List, Map, String, or another type. An incorrect cast can cause a
ClassCastException.

Question 3. HashSet in parseObject (4 points)

3a. (2)

set.add(key) returns true if the key was added and false if the key was
already in the set. In my parseObject method, I used contains to see
whether the key was already present. If it were, I threw a
JsonParseException.

3b. (1)

I would keep the separate HashSet because it tracked every key that has
already appeared, even when a key has a null value. It also keeps
duplicate-key detection separate from storing the object's values.

3c. (1)

A security tool might reject duplicate keys due to the fact that
allowing the last value to win could overwrite important security
information. This could make a log ambiguous or misleading.

Question 4. Using the structures (5 points)

4a.

My output was:

Unique source IPs: 11 \[10.0.4.35, 203.0.113.99, 198.51.100.23,
198.51.100.7, 10.0.7.19, 10.0.7.8, 192.0.2.14, 203.0.113.50, 10.0.4.22,
203.0.113.51, 10.0.4.21\]

There were 37 total authentication events and 11 unique source IP
addresses. A HashSet removes the duplicates because it only stores one
copy of each value. When an IP that is already in the set is added
again, another copy is not stored.

4b.

In eventsByUser, the HashMap connects each username to its events, while
the List stores the individual events belonging to that user. I use
containsKey() on the HashMap before using a user for the first time so I
can create a new ArrayList for that user. The value associated with the
key "admin" has the type List`<Object>`{=html}, and it contains 11
events.

4c.

flowsTouchingBlocklist copies the blocklist from a List into a HashSet
because HashSet.contains() has an average time complexity of O(1), while
searching through a List can take O(n). As both the blocklist and number
of flows grow, repeatedly searching the List would require more
comparisons, while the HashSet provides faster average lookups.

Question 5.

Recursion appeared in my JSON parser when parseObject() and parseArray()
both called up parseValue() to parse nested values, which could then
call parseObject() or parseArray() again.

I used a HashMap to represent JSON objects and to associate usernames
with their failed login counts and authentication events.

I used a HashSet in parseObject() to detect duplicate keys and in
uniqueIps() to collect unique IP addresses without duplicates.

I used List and ArrayList to represent JSON arrays and to store the
authentication events associated with each user.

The hardest bug that I had encountered was when Java could not find the
HashMap class in LogDemo.java. I found the problem by reading the
compiler error, which said couldn't find symbol: class HashMap. I fixed
it by adding import java.util.HashMap; at the top of the file.
