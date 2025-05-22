#-----how to withdraw CGPA ---------------
print("WELCOME FROM- MD ROMJAN ALI.")
fast_result = float(input("inter your result of 1st semister:"))
second_result = float(input("inter your result of 2nd semister:"))
thard_result =float(input("inter your result of 3rd semister:"))
forth_result = float(input("inter your result of 4th semister:"))
fifth_result =float(input("inter your result of 5th semister:"))
sixth_result = float(input("inter your result of 6th semister:"))
seventh_result = float(input("inter your result of 7th semister:"))
eighth_result = float(input("inter your result of 8th semister:"))
x = fast_result + second_result+thard_result+forth_result+fifth_result+sixth_result+seventh_result+eighth_result 
CGPA = x/8
cgpa = round(CGPA,2)
if cgpa<2.5:
    print("INVAITED CGPA")
elif cgpa>4:
    print("INTER RIGHT GPA, THANK YOU.")
else:
    print("YOUR RESULT IS CGPA:",cgpa)

