
"""
29. Escriu un programa que donat un fitxer de text d'entrada, el llegeix i mostra la llista de paraules
ordenades alfabèticament. Les paraules no poden estar repetides, i no han de ser keysensitive. És a
dir, a la llista només hauria d’aparèixer un cop la paraula “hola” si en el fitxer posés “Hola, hola,
hoLA ...”
"""
sortedLine = []
with open("./example.txt", "r") as file:
    for line in file:
    #Eliminar carácteres especiales
        line = line.strip(",.:¿¡!?\n-_").split(" ")
        
        #Comprovar si la palabra está en la lista
        exists = 0
        for word in line:
            for comparable in sortedLine:
                if word.upper() == comparable.upper():
                    exists = 1
                    break
            if exists == 0:
                sortedLine.append(word)        

sortedLine.sort()
for x in sortedLine:
    print(x)

    