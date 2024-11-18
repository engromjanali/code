import datetime
min6 = datetime.timezone(datetime.timedelta(hours=-6))
plus6 = datetime.timezone(datetime.timedelta(hours=6))
d = datetime.datetime.now(min6)
print(min6 ,':' ,d)
print( datetime.timezone.utc,":", d.astimezone(datetime.timezone.utc))
d_system = d.astimezone()
print("bangladesh standaed time :", d_system)
