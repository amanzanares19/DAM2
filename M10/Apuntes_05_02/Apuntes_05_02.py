"""
IMPORTS i DECORATORS
import prova

prova.helloworld()


def my_decorator(f):
    
    def wrapper(x,y):
        print("Abans d'executar la funcio...")
        print(f(x,y))
        print("Després d'executar la funcio...")
    return wrapper

@my_decorator
def suma(x,y):
    return x+y

suma(3,5)"""


class Gos:
    
    def __init__(self, name, edat, race):
        self.name = name
        self.edat = edat
        self.race = race
    
    def __str__(self) -> str:
        return str(self.name) + " " + str(self.edat) + " " + str(self.race)
    
gos1 = Gos("Lucas", 20, "Galgo")

print(gos1.__str__())