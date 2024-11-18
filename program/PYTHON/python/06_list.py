#------------------------list --------------------

#----------------1.clear()	Removes all the elements from the list--------------------------
#------------2.copy()	Returns a copy of the list---------------------------------------
#------------3.count()	Returns the number of elements with the specified value------------------------------
#---------------4.extend()	Add the elements of a list (or any iterable), to the end of the current list-------------------
#-------------5.index()	Returns the index of the first element with the specified value---------------
#---------------6.insert()	Adds an element at the specified position-----------------
#------------7.pop()	Removes the element at the specified position------------------
#--------------8.remove()	Removes the item with the specified value---------------
#--------------9.reverse()	Reverses the order of the list---------------
#-------------------10.sort()	Sorts the list-----------------------




#----------------1.clear()	Removes all the elements from the list---------------


#mylist = ["apple", "banana", "cherry"]
#print(mylist)

#------------------------o determine how many items a list has, use the len() function:

#thislist = ["apple", "banana", "cherry"]
#print(len(thislist))

#List items can be of any data type:

#list1 = ["apple", "banana", "cherry"]
#list2 = [1, 5, 7, 9, 3]
#list3 = [True, False, False]
#list4 = ["romjan", "easin", "habib"]
#print(list4)

#-------------A list with strings, integers and boolean values:

#list5 = ["abc", 34, True, 40, "male"]
#print(list5)

#-----------What is the data type of a list?

#mylist1 = {"apple", "banana", "cherry", 'romjan',900}#set
#mylist2 = ("apple", "banana", "cherry", 'romjan',900)#tuple
#mylist3 = ["apple", "banana", "cherry", 'romjan',900]# list
#print(type(mylist3))

#  --------------------It is also possible to use the list() constructor when creating a new list.

#Example
#Using the list() constructor to make a List:

#thislist = list(("apple", "banana", "cherry")) # note the double round-brackets
#print(thislist)

#-------------List items are indexed and you can access them by referring to the index number:

#Example
#Print the second item of the list:

#thislist = ["romjan","habibn","maria","karim","rasheda akter"]
#print(thislist[2])
#print(thislist[4])
#print(thislist[0])

#-----------------Negative indexing means start from the end

#-1 refers to the last item, -2 refers to the second last item etc.
#ote - nagative index number start from -1,-2,-3,-4,-5,-6

#Example
#Print the last item of the list:

#thislist = ["romjan","habibn","maria","karim","rasheda akter"]
#print(thislist[-5])

# -------------------- You can specify a range of indexes by specifying where to start and where to end the range.

#When specifying a range, the return value will be a new list with the specified items.

#Example
#Return the third, fourth, and fifth item:

#thislist = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
#print(thislist[-6 :-1])

#thislist = ["romjan","habibn","maria","karim","rasheda akter"]
#leet = thislist[2:5]
#print(leet)

#-------------By leaving out the start value, the range will start at the first item:

#Example
#This example returns the items from the beginning to, but NOT including, "kiwi":

#thislist = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
#print(thislist[5:])

#-------------By leaving out the end value, the range will go on to the end of the list:

#Example
#This example returns the items from "cherry" to the end:

#thislist = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
#print(thislist[2:])

#---------------Specify negative indexes if you want to start the search from the end of the list:

#Example
#This example returns the items from "orange" (-4) to, but NOT including "mango" (-1):

#thislist = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
#print(thislist[-4:-1])
#---------------To determine if a specified item is present in a list use the in keyword:

#Example
#Check if "apple" is present in the list:

#thislist = ["apple", "banana", "cherry"]
#if "apple" in thislist:
#  print("Yes, 'apple' is in the fruits list")

  #----------------To change the value of a specific item, refer to the index number:

#Example
#Change the second item:

#thislist = ["apple", "banana", "cherry"]
#thislist[1] = "blackcurrant"
#print(thislist)

#To change the value of items within a specific range, define a list with the new values, and refer to the range of index numbers where you want to insert the new values:

#Example
#Change the values "banana" and "cherry" with the values "blackcurrant" and "watermelon":

#thislist = ["apple", "banana", "cherry", "orange", "kiwi", "mango"]
#thislist[1:3] = ["blackcurrant", "watermelon"]
#print(thislist)

#If you insert more items than you replace, the new items will be inserted where you specified, and the remaining items will move accordingly:

#Example
#Change the second value by replacing it with two new values:

#thislist1 = ["apple", "banana", "cherry"]
#thislist1[1:2] = ["blackcurrant", "watermelon"]
#print(thislist)

#If you insert less items than you replace, the new items will be inserted where you specified, and the remaining items will move accordingly:

#Example
#Change the second and third value by replacing it with one value:

thislist = ["apple", "banana", "cherry"]
thislist[1:3] = ["watermelon"]
print(thislist)

#To insert a new list item, without replacing any of the existing values, we can use the insert() method.

#The insert() method inserts an item at the specified index:

#Example
#Insert "watermelon" as the third item:

#thislist = ["apple", "banana", "cherry"]
#thislist.insert(2, "watermelon")
#print(thislist)

#To add an item to the end of the list, use the append() method:

#Example
#Using the append() method to append an item:

#thislist = ["apple", "banana", "cherry"]
#thislist.append("orange")
#print(thislist)

#To insert a list item at a specified index, use the insert() method.

#The insert() method inserts an item at the specified index:

#Example
#Insert an item as the second position:

#thislist = ["apple", "banana", "cherry"]
#thislist.insert(1, "orange")
#print(thislist)

#The remove() method removes the specified item.

#Example
#Remove "banana":

#thislist = ["apple", "banana", "cherry"]
#thislist.remove("banana")
#print(thislist)

#The pop() method removes the specified index.

#Example
#Remove the second item:

#thislist = ["apple", "banana", "cherry"]
#thislist.pop(1)
#print(thislist)

#If you do not specify the index, the pop() method removes the last item.

#Example
#Remove the last item:

#thislist = ["apple", "banana", "cherry"]
#thislist.pop()
#print(thislist)

#The del keyword also removes the specified index:

#Example
#Remove the first item:

#thislist = ["apple", "banana", "cherry"]
#del thislist[0]
#print(thislist)

#The del keyword can also delete the list completely.

#Example
#Delete the entire list:

#thislist = ["apple", "banana", "cherry"]
#del thislist

#You can loop through the list items by using a for loop:

#Example
#Print all items in the list, one by one:

#thislist = ["apple", "banana", "cherry"]
#for x in thislist:
#  print(x)

#You can also loop through the list items by referring to their index number.

#Use the range() and len() functions to create a suitable iterable.

#Example
#Print all items by referring to their index number:

#thislist = ["apple", "banana", "cherry"]
#for i in range(len(thislist)):
#  print(thislist[i])

#Print all items, using a while loop to go through all the index numbers
#---row to colam()

#thislist = ["apple", "banana", "cherry"]
#i = 0
#while i < len(thislist):
#  print(thislist[i])
#  i = i + 1

#List Comprehension offers the shortest syntax for looping through lists:

#Example
#A short hand for loop that will print all items in a list:

#hislist = ["apple", "banana", "cherry"]
#[print(x) for x in thislist]

#List comprehension offers a shorter syntax when you want to create a new list based on the values of an existing list.

#Example:

#Based on a list of fruits, you want a new list, containing only the fruits with the letter "a" in the name.

#Without list comprehension you will have to write a for statement with a conditional test inside:

#Example
#fruits = ["apple", "banana", "cherry", "kiwi", "mango"]
#newlist = []

#for x in fruits:
#  if "a" in x:
#    newlist.append(x)

#print(newlist)

#With list comprehension you can do all that with only one line of code:

#Example
#fruits = ["apple", "banana", "cherry", "kiwi", "mango"]

#newlist = [x for x in fruits if "a" in x]

#print(newlist)

#newlist = [expression for item in iterable if condition == True]
#The return value is a new list, leaving the old list unchanged.

#Condition
#The condition is like a filter that only accepts the items that valuate to True.

#Example
#Only accept items that are not "apple":

#newlist = [x for x in fruits if x != "apple"]

#The condition if x != "apple"  will return True for all elements other than "apple", making the new list contain all fruits except "apple".

#The condition is optional and can be omitted:

#Example
#With no if statement:

#newlist = [x for x in fruits]

#Iterable
#The iterable can be any iterable object, like a list, tuple, set etc.

#Example
#You can use the range() function to create an iterable:

#newlist = [x for x in range(10)]

#Same example, but with a condition:

#Example
#Accept only numbers lower than 5:

#newlist = [x for x in range(10) if x < 5]

#The expression is the current item in the iteration, but it is also the outcome, which you can manipulate before it ends up like a list item in the new list:

#Example
#Set the values in the new list to upper case:

#newlist = [x.upper() for x in fruits]

#You can set the outcome to whatever you like:

#Example
#Set all values in the new list to 'hello':

#newlist = ['hello' for x in fruits]

#The expression can also contain conditions, not like a filter, but as a way to manipulate the outcome:

#Example
#Return "orange" instead of "banana":

#newlist = [x if x != "banana" else "orange" for x in fruits]

#List objects have a sort() method that will sort the list alphanumerically, ascending, by default:

#Example
#Sort the list alphabetically:

#thislist = ["orange", "mango", "kiwi", "pineapple", "banana"]
#thislist.sort()
#print(thislist)

#Example
#Sort the list numerically:(smole - largest )

#thislist = [100, 50, 65, 82, 23]
#thislist.sort()
#print(thislist)

#To sort descending, use the keyword argument reverse = True(a-z) and (z-a):


#Example
#Sort the list descending:

#thislist = [100, 50, 65, 82, 23]
#thislist.sort(reverse = True)
#print(thislist)

#thislist = [100, 50, 65, 82, 23]
#thislist.sort(reverse = False)
#print(thislist)

#You cannot copy a list simply by typing list2 = list1, because: list2 will only be a reference to list1, and changes made in list1 will automatically also be made in list2.

#There are ways to make a copy, one way is to use the built-in List method copy().

#Example
#Make a copy of a list with the copy() method:

#thislist = ["apple", "banana", "cherry"]
#mylist = thislist.copy()
#print(mylist)

#Another way to make a copy is to use the built-in method list().

#Example
#Make a copy of a list with the list() method:

#thislist = ["apple", "banana", "cherry"]
#mylist = list(thislist)
#print(mylist)

#There are several ways to join, or concatenate, two or more lists in Python.

#One of the easiest ways are by using the + operator.

#Example
#Join two list:

#list1 = ["a", "b", "c"]
#list2 = [1, 2, 3]

#list3 = list1 + list2
#print(list3)

#Another way to join two lists is by appending all the items from list2 into list1, one by one:

#Example
#Append list2 into list1:

#list1 = ["a", "b" , "c"]
#list2 = [1, 2, 3]

#for x in list2:
#  list1.append(x)

#print(list1)

#Or you can use the extend() method, which purpose is to add elements from one list to another list:

#Example
#Use the extend() method to add list2 at the end of list1:

#list1 = ["a", "b" , "c"]
#list2 = [1, 2, 3]

#list1.extend(list2)
#print(list1)
