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

# Day 3:
## static: 
static variable is something shared among all instances of the class, used to store common things for all the objects

static blocks are executed once when the class is first loaded

static methods belong to the class, not to any object, can be called outside the class directly using method name, no need of object. it can only access static data from class

## final:
final variable cannot be changed after it is initialized. if it is part of a class then it needs to be initialized in the constructor 
final class cannot be inherited  

final method cannot be overwritten by subclasses

## record:
public record RecordName(datatye varname, ....){}  
used to hold elements, no changes made to them, the variables will be private and final.  
they have public getter methods, used by calling function which has same name as the variable name  
also overrides, toString(), hashCode(), equals() methods

printing the record name shows the contents in readable way(toString)

equals checks if the components of the objects are the same then its equal 

you can create instance methods and statics methods for the record within the {}

## abstract classes:
cant be instantiated, used on parent classes where it doesnt make sense for them to have objects but they can be inherited and those classes can have objects like animal and dog, cat, etc

abstract methods can also be declared in the abstract class for things the subclasses should be able to do but they dont have any {} it just has ;  the actual implementation is done in the subclass 

abstract classes can also have normal methods

## interface
every method in an interface is already abstract  
every field in it is static and final 
used when you have different unrelated classes which you want to do something commmon 
instead of using extends it uses implements  
extend only works on one class while you can implement as many interfaces as you want (can also use both extend and implements)

## enum
type of class, its fields are public, static and final
used when there are known values that arent going to change which need to be used in different places so that there are no mistakes are made  
enum enumName {vals}  
each val must be in caps  
to use: enumName var = enumName.val1;  
loop through using enumNames.values()