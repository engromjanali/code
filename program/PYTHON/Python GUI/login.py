from tkinter import *
def getvals():
    print(f"the user id is : {userid.get()}")
    print(f"the pass id is : {passwd.get()}")

root = Tk()
root.geometry("500x500")
userL = Label(root, text="user id")
passwdL = Label(root, text="password")
userL.grid()
passwdL.grid(row=1)

# variable classes in tkinter
# BooleanVar, DoubleVar, IntVar, StringVar
userid = StringVar()
passwd = StringVar()
user_entry = Entry(root, textvariable=userid)
pass_entry = Entry(root, textvariable=passwd)

user_entry.grid(row=0, column=1)
pass_entry.grid(row=1, column=1)

Button(root, text="login", bg="red", command=getvals).grid()
root.mainloop()