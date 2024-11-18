#--------- brack and continue in python-------------
animal = [ "tiger","cat","dog"]
for pet in animal:
    if pet == "cat":
        break#(cat ar agor gola print hoiba ar porar gola ar print hoiba na)
    print(pet)

animal = ["tiger","cat","dog"]
for pet in animal:
    if pet == "dog":
        continue#(cat print hoiba na kentu bake sob print hoiba)
    print(pet)