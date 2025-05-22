import datetime 
from datetime import timedelta
t = datetime.time(2,5,50)
print("time is : ", t )
y = datetime.date.today()
print(y)
dt = datetime.datetime.combine(y,t)
print( dt) 


