# Write a python program to find the longest words in a file
# Using text.txt file in same folder
#def longest_word(filename):
#    with open(filename, 'r') as infile:
#              words = infile.read().split()
#    max_len = len(max(words, key=len))
#    return [word for word in words if len(word) == max_len]
#print(longest_word('test.txt'))

def longest_word(f_name):
    f = open(f_name, "r") 
    words = f.read().split() # "spilt()" এই ফানশন ব্যবহৃত হয় কোনো লাইন বা পারেগেরাপ লিস্টা এ কনভার্ট করার জন্য।
    max_len = len(max(words, key=len))
    return [ word for word in words if len(word) == max_len], max_len
print( longest_word("test.txt"))

