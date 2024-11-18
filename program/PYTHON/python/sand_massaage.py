# pyautogui are not support integer!

import pyautogui
import time
time.sleep(10)
i = 0
#n = int (inpaut("inter  a number :"))
while i< 10:
    pyautogui.typewrite("4 Betari") 
    pyautogui.press("enter")

    time.sleep(0)
    i+=1
print("success")

