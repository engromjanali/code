import tkinter as tk
import qrcode
from PIL import Image, ImageTk

qr = qrcode.QRCode(
    version = 1,
    error_correction = qrcode.constants.ERROR_CORRECT_H,
    box_size = 8,
    border = 1,
)

qr.add_data("https://www.facebook.com/profile.php?id=100037207939401")
qr.make (fit = True)
img = qr.make_image(fill_color="black", back_color = "white")
img.save('C:qrImage.png')

root = tk.Tk()
root.title("Genarate QR")
root.geometry("500x500")
qry="xyz"
l1 = tk.Label(root, text="Text : "+qry)
l1.pack()

photo = tk.PhotoImage(file="qrImage.png")
l2 = tk.Label(image=photo)
l2.pack()

b1 =tk.Button(root, text="Save", command="")
b1.pack(pady=10)

b2 =tk.Button(root, text="close", command="")
b2.pack(pady=10)

root.mainloop()

