from tkinter import *
root = Tk()
root.geometry("444x333")
root.title("xyz")
#  importent label options
# text - adds the text
# bs = beckground
# fg = foreground
# font - set the font
# padx = x padding
# pady = Y padding
# relief - (border styling) -> SUNKEN, RAISED, GROOVE, RIDGE

label = Label(text="""dsjfkj skldjfla;sf adf kasdfjs skd lj lljsdj fsdkjfsdkj 
\nkdsjhfks dfkhsdk skdjhfkjsd fkhsd fakjdf \n
ksdhf sd hhiii romjan.""", bg = "green", fg = "red",
font = "cosmeticians 20 bold", padx=100, pady=50, borderwidth=5, relief=SUNKEN)


label.pack(side=LEFT,padx=10, fill=Y )
root .mainloop()