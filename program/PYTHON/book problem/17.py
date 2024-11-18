from datetime import date
from datetime import timedelta

def yesterday ( ):
    today = date.today()
    yesterday = today-timedelta(days=1)
    return(yesterday)
print('yesterday was : ',yesterday())
print( "today id : ", date.today())