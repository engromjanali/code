# Write a Python function that takes a list of words and returns the length of the longest one
def find_longest_word(words_list):
    word_len = []
    for n in words_list:
        word_len.append((len(n), n))
    word_len.sort()
    return word_len[-1]#[1]# -1 for arena web security and 1 for  2nd element of "(18, 'arena web security')" 
print(find_longest_word(["PHP", "Exercises", "Backend", "arena web security"]))

