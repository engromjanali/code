# Write a Python script to concatenate following dictionaries to create a new one
# Input
# dic1={1:10, 2:20}
# dic2={3:30, 4:40}
# dic3={5:50,6:60}
# Output
# {1: 10, 2: 20, 3: 30, 4: 40, 5: 50, 6: 60}
 
a ={1:10, 2:20}
b= {3:30, 4:40}
c= {5:50, 6:60}
d = {}
for i in (a,b,c):
    d.update(i)
print(d)




