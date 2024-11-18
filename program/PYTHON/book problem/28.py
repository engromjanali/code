def string_reverse(str1):

    index = len(str1)
    while index > 0:
        str1 += str1 [index-1]
        index = index-1
    return str1
print(string_reverse("123456 "))


open("29.py", 'x')