"""
#Parametros variables
def parametres_variables(param1, *params, **kwords):
    print(param1)
    for x in params:
        print(x)
# Els paràmetres kwords es recorren com diccionaris
    for clau in kwords:
        print("El valor de", clau, "es", kwords[clau])
parametres_variables("A", "b", "b", "d", clau1="1", clau2="2")"""


"""
#Ficheros
objFile = open("./file.txt", "r")

#Read
objFitxer.read(): llegeix tot el fitxer
objFitxer.read(n): llegeix tot els n primers caràcters
objFitxer.readline(): llegeix una línia
objFitxer.readlines(): llegeix totes les línies a una llista

#Remove file
objFitxer.remove("file.txt")

f = open("demofile.txt" , "r")
for x in f: #llegeix línia a línia
    print(x)
#Required to close file if "with" keyword not used
f.close()
"""

"""EXCEPTIONS"""

"""try:
    print("Hola", 2)
except FileNotFoundError:
    print("Fitxer no trobat")
except Exception as e: #Podem accedir a “e”
    print("Excepció inesperada")
    print(e, type(e))
except:
    print("Error inesperat") #qualsevol altre tipus d’error
else:
    print("No hi ha hagut error") #no s’ha produït cap excepció
finally:
    print("Final") #s’executa sempre, tant si hi ha error com si no
    
x = -1
if x < 0:
    raise Exception("Sorry, no numbers below zero")"""
    
#POO
class Person:
    contador = 0
    
    def __init__(self, name, age):
        self.name = name
        self.age = age
        Person.contador = Person.contador + 1
    
    def myfunc(self):
        print(self.name)
        
una_persona = Person("John", 36)
print(una_persona.name)
una_persona.myfunc()
una_persona.name = "Alex"
una_persona.myfunc()
print(Person.contador)
dos_persona = Person("Oscar", 30)
print(dos_persona.contador)
#del dos_persona.age
print(dos_persona.age)

"""Herencia"""

class Student(Person): #HEREDA DE Person i Objecte2
#Pot heredar de + objectes
    def __init__(self, name, age, cicle):
        #Constructor   
        super().__init__(name, age)
        #afegim un atribut
        self.cicle = cicle
        
    def myfunc(self):
        print("My name is " + self.name + "i estudio " + self.cicle)

un_estudiant = Student("John", 36, "DAM")
un_estudiant.myfunc()