# Write a Python program to count the number of characters (character frequency) in a string.
# Sample String : google'
# Expected Result : {'g': 2, 'o': 2, 'l': 1, 'e': 1}

def chr_frequency(romjan):
    kaka = {}
    for i in romjan:
        #keys = kaka.keys()
        if i in kaka:
            kaka[i] += 1
        else:
            kaka[i] = 1
    return kaka
print(chr_frequency("romjan"))



