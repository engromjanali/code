#class animal: 
#    def __init__(self,name) :
#        self.name = name 
#    def walk(self):
#        print(self.name + " walks")
#a = animal("puppy")
#a.walk()

#-----------------

class animal: 
    def __init__(self,name,age,id) :
        self.name = name 
        self.age = age 
        self.id = id
    def walk(self):
        print(self.name ,self.age,self.id)

class dog(animal):
    def __init__(self, name , age,id ):
        super().__init__(name, age,id)

    def sound (self):
        print(self.name + "barks")

x = dog("coco",19,90)
y = dog("älsa" , 1,80)
x.walk()
x.sound()
y.walk()
y.sound()


