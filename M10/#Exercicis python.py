#Exercicis python

""" 1
n1 = float(input("Dame numero 1: "))

n2 = float(input("Dame numero 2: "))

x = (n1 + n2)/2

print(x)
"""


""" 2

n1 = float(input("Dame distancia en pies: "))

print("La distancia es ", n1*12*2.54, "cm")

n1 = float(input("Dame distancia en pulgadas: "))

print("La distancia es ", n1*2.54, "cm")
"""

"""3
import math
secs = int(input("Segundos: "))

print("Son ", str(math.trunc(secs/60)), " minuts i ", secs%60, " segons")
"""

""" 4 collections
vocales = ["a", "e", "i", "o", "u"]
pos = int(input("Posicion: "))
val = input("Valor a cambiar: ")

vocales[pos] = val
print(vocales)
"""

"""8 elements in both lists
list1 = ["hola", "que", "tal", 2, 3, 5]
list2 = ["hola", "no", "pasa", 2, 3, 8]
list3 = []
for i in list1:
    for j in list2:
        if i == j:
            list3.append(i)
            break

print(list3)

elements in first list but not in second
list1 = ["hola", "que", "tal", 2, 3, 5]
list2 = ["hola", "no", "pasa", 2, 3, 8]
list3 = []
for i in list1:
    if not i in list2:
        list3.append(i)      
print(list3)

elements in second list but not in first
list1 = ["hola", "que", "tal", 2, 3, 5]
list2 = ["hola", "no", "pasa", 2, 3, 8]
list3 = []
for i in list2:
    if not i in list1:
        list3.append(i)      
print(list3)

elements in second list but not in first V2 WITHOUT in keyword
list1 = ["hola", "que", "tal", 2, 3, 5]
list2 = ["hola", "no", "pasa", 2, 3, 8]
list3 = []
for i in list2:
    count = 1
    for j in list1:
        if j != i:
            if len(list1) == count:
                list3.append(i)
                count = 0
        else:
            break
        count += 1            
            
print(list3)
   

all elements 
list1 = ["hola", "que", "tal", 2, 3, 5]
list2 = ["hola", "no", "pasa", 2, 3, 8]
list3 = []

pos = 0
while pos < (len(list1) + len(list2)):
    
    if pos < len(list1):
        list3.append(list1[pos])          
    if pos < len(list1):
        list3.append(list2[pos])
    pos += 1
    
print(list3)"""
