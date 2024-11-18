from tkinter import *

root = Tk()
root.geometry("1000x600")

def hello():
    print ("hello romjan")
frame = Frame(root, borderwidth= 6, bg= "red", relief=SUNKEN)
frame.pack(side=LEFT, anchor="nw")

b1= Button(frame, fg="black", bg="red", text="print", command=hello)
b1.pack(side=LEFT, padx=23)

b2= Button(frame, fg="black", bg="red", text="print", command=hello)
b2.pack(side=LEFT, padx=23)

b3= Button(frame, fg="black", bg="red", text="print", command=hello)
b3.pack(side=LEFT, padx=23)
root.mainloop()