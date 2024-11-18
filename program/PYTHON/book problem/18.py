from datetime import *
def tomorrow():
    return(date.today()+timedelta(days=1))
print( "today time is : ", date.today())
print("tomorrow date will be : ", tomorrow())
