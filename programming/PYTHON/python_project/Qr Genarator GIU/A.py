import qrcode as qr
import tkinter as tk
import B


root = tk.Tk()
root.title("Qr Genarate")
root.geometry("500x500")

l1 = tk.Label(root, text="Enter Text : ")
l1.pack()
t1 = tk.Text(root, width=60, height=25, font="Helvetica 10")
t1.pack()

b1 = tk.Button(root, text="Genarate", command=B.run(t1.get()))
b1.pack(pady=10)

root.mainloop()

