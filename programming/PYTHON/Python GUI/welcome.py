from tkinter import *

root = Tk()

# widthxheight
root.geometry("500x500")

# width,height
root.minsize(300,300)

# width,height
root.maxsize(1000 ,1000)

label1 = Label(text = "hello student how are you!")
label1.pack()
root.mainloop()