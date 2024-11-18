from tkinter import *

def fun():
    with open("program\PYTHON\Python GUI\data.txt", "a") as f:
        f.write(f"{name.get(), roll.get(), age.get(), subject.get(), reguler.get()}\n")

root = Tk()
root.geometry("500x500")

Label(root, text="welcome To Romjan Ali Page").grid()

Label(root, text="Name :").grid(row=1, column=0)
Label(root, text="Roll :").grid(row=2, column=0)
Label(root, text="Age :").grid(row=3, column=0)
Label(root, text="Subject :").grid(row=4, column=0)

name = StringVar()
roll = IntVar()
age = IntVar()
subject = StringVar()
reguler = IntVar()

E1 = Entry(root, textvariable=name)
E2 = Entry(root, textvariable=roll)
E3 = Entry(root, textvariable=age)
E4 = Entry(root, textvariable=subject)

E1.grid(row=1, column=1)
E2.grid(row=2, column=1)
E3.grid(row=3, column=1)
E4.grid(row=4, column=1)

# service = Checkbutton(text="check here", variable=reguler, command=fun) #it's right also
service = Checkbutton(text="check here", variable=reguler)
service.grid(row=5, column=1)

Button(root, text="submit", command=fun).grid(row=6, column=1)


root.mainloop()

