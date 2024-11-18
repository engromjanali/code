from tkinter import *
root = Tk()
root .geometry("1000x600")
frame = Frame(root, bg="grey", borderwidth=6, relief=SUNKEN)
frame.pack(side=LEFT, fill=Y, pady= 100)

frame2 = Frame(root,borderwidth=8, bg="grey",relief=SUNKEN)
frame2.pack(side=TOP, fill=X)

l = Label(frame, text="project romjan ali")
l.pack(pady=100)

l  = Label(frame2, text="welcome to text editor")
l.pack()
root.mainloop()