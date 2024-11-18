def check_vowel_or_consonant(alphabet):
    vowels = ['a', 'e', 'i', 'o', 'u']

    if alphabet.lower() in vowels:
        return f"{alphabet} is a vowel."
    else:
        return f"{alphabet} is a consonant."

# Test the function
input_alphabet = input("Enter an alphabet: ")
result = check_vowel_or_consonant(input_alphabet)
print(result)


x = "ali"
print("romjan",x, "mia")
print(f"romjan {x} mia ")