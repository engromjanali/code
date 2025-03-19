# pyautogui are not support integer!

import pyautogui
import time
time.sleep(10)
i = 0
#n = int (inpaut("inter  a number :"))
while i< 20:
    pyautogui.typewrite("kire siam tor bon tw phone dortace na rag korca naki? dekh tw ki somossa.")
    pyautogui.press("enter")

    time.sleep(0)
    i+=1
print("success")

