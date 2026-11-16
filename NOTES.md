# Day 1:
just downloaded JDK(Eclipse Temurin) and an IDE(IntelliJ). Created project, created repo on github and connected them. Commited everything along with this md file.

# Day 2:
## 1. ArrayList:
uses arrays and does dynamic resizing when size is reached or when something needs to be added in the middle but accessing each element is easier because of index
## 2. LinkedList:
uses doubly linked list so no resizing needed but takes longer to access any element in the middle

funcs:  
.add(elem)  
.get(ind)  
.add(ind, elem)  
.set(ind, elem)  
.remove(elem)  

## 3. HashMap

funcs:  
.put(key, value)  
.get(key)
.containsKey(key)  
.containsValue(value)  
.putIfAbsent(key, value)  
.remove(key)  
.getOrDefault(key, defaultval)  

Iteration methods:
1. for (Map.Entry<String, Integer> entry : map.entrySet()) {   
   String key = entry.getKey();  
   Integer value = entry.getValue();  
   }  
Map.Entry represents single key value pair within map 
in this method it extracts the Set of entries from the Map, and then iterates using for-each
2. map.forEach((key, value) -> System.out.println(key + " -> " + value));  
using lambda function for read only operations
3. Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();  
   while (iterator.hasNext()) {  
   Map.Entry<String, Integer> entry = iterator.next();  
   // iterator.remove(); can be used here  
   }  
used when remove or conditional mutations need to be done

Merging methods:
1. map1.putAll(map2);  second map takes precedence for duplicate keys
2. map2.forEach((key, value) ->
   map1.merge(key, value, Integer::sum)
   );  lambda function to iterate and sums the values if two keys match (Integer::sum part) 
3. map2.forEach(
   (key, value) -> map3.merge(key, value, (v1, v2) -> new Employee(v1.getId(),v2.getName())));   another example, the merging rule is called if key exists in map3 and it calls remappingFunction(oldval(in map3), newval(in map2)). so it keeps the id from map3’s employee and the name from map2’s employee. 

## 4. HashSet
unordered

funcs:  
.add(val)  
.remove(val)  
.contains(val)  
.addAll(list) or directly put the list in the intitialization 

can loop using:  
for(String val : vals)  
vals.forEach(S.o.pln);  
using iterator, same way as HashMap but no need to make Map.Entry, just directly use iterator.next


can use TreeSet, its naturally order the elements but is slower  
can use LinkedHashSet, maintains insertion order, faster than TreeSet, not as fast as HashSet