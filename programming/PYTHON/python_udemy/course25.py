# Write a Python function to create the HTML string with tags around the word(s).
# Sample function and result : 
# add_tags('i', 'Python') -> '<i>Python</i>'
# add_tags('b', 'Python Tutorial') -> '<b>Python Tutorial </b>'

def add_tag(romjan, ali ):
    return "<%s>%s</%s>" % (romjan, ali , romjan )
print( add_tag("i " , "python"))
print( add_tag("b ", "python tutorial"))
