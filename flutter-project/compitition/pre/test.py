import customtkinter as ctk
import re
import math

buttons=[
    ("AC", "(", ")", "/",),
    ("1", "2", "3", "/",),
    ("4", "5", "6", "*",),
    ("7", "8", "9", "-",),
    ("AC", "0", "=", "+",),
]

def on_click(button_text):
    print(button_text)

def getColor(button_text):
    if(button_text=="AC"):
        return "red"
    
root =ctk.CTk()
root.geometry("300x480")
root.title("romjan ali")
root.configure(fg_color="black")


Entery = ctk.CTkEntry(
    root,
    width=280,
    height=50,
)
Entery.pack(fill= "both", padx=10, pady=10)

button_frame= ctk.CTkFrame(root)
button_frame.pack(fill="both",expand=True, padx=10, pady=10,)
for row in buttons:
    row_frame= ctk.CTkFrame(button_frame)
    row_frame.pack(expand=True, fill="both")
    for button_text in row:
        btn = ctk.CTkButton(
            row_frame,
            text=button_text,
            command=lambda text = button_text:on_click(text),
            fg_color="red",
            hover_color="blue",
            width=60,
            height=50,
            
        )
        btn.pack(fill="both",side="left", padx=5, pady=5, expand=True)
        

root.mainloop()