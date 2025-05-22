from tkinter import *
from PIL import Image, ImageTk
root = Tk()
root. geometry("1000x1000")
photo = PhotoImage(file="romjan.png")

label = Label(image=photo)
label.pack()

root.mainloop()

# label dose not support JPG formate. take onlu PNG
# we can use pillow for any extention.

from tkinter import *
from PIL import Image, ImageTk
root = Tk()
root. geometry("1000x1000")
image = Image.open("romjan_ali.jpg")
photo = ImageTk.PhotoImage(image)

label = Label(image=photo)
label.pack()

root.mainloop()
