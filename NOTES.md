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

# Day 4

## generics
put <T> in the class name and then we can just use T as the datatype in variables and methods  
when instantiating the class you put <wrapper class of datatype> so that the generic class knows what datatype it's handling  
bounded generic: in the T in the class name you can also extend other classes so that it can only be objects of the parent class as the datatype and the variables with T datatype can use methods of the parent class. this also works with interfaces but uses extends keyword only instead of implements  
to inherit multiple classes/ interfaces, first put the class name and then use & for every interface inherited(can only use one class cause java)  

also works directly in methods, the parameter will have T var and the definition will have <T>
for multiple generics use <T, V>  

wildcard: if there is a method which takes in a list but the datatype instead known then <?> is used in the parameter and it can accept any type then  
also can extend classes, interfaces

## Exception Handling
try {} catch( exception e) {}  
Exception can be used to catch any exception  
can also stack multiple catches to catch different exceptions  
can also use | to put multiple exceptions in same catch

finally block executes after try catch, executes no matter what, meaning that even if there is a return statement the finally block will still run  
a return statement in the finally block overrides any other return statement in try or catch

subclasses of runtimeexception are unchecked exceptions and java doesnt directly handle them, the program ends if the exception occurs. all other exceptions are checked exceptions, throw a compile time error so that you need to have code to handle it

## Custom Exceptions:  
make a new exception class that extends Exception and in the try block throw new exceptionname();   
if a method has the throw exception but doesnt handle it with try catch then the method declaration needs to have: throws exceptionname   

if you want to pass a parameter with the exception then in the new exception class a constructor needs to be created to handle that by just putting super(parameter);  
This parameter can also be a Throwable instead of just a String. this is used when the custom exception is caused by some other exception so in the throwable you can pass in the exception which caused it.