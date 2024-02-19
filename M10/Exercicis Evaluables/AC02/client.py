
import re

class Client:
    
    contador = 0
    
    def __init__(self, id, nom, cognom, telefon, correu, ciutat):
        
        #Add id if not exists
        if not id in self.idList:            
            self.__id = id
            self.contador = self.contador + 1
            
        if nom.isalpha() & cognom.isalpha():
            self.__nom = nom
            self.__cognom = cognom
        
        if re.match("\+00[0-9]{2}-[0-9]{6,10}", telefon) | re.match("[0-9]{6,10}", telefon):
            self.__telefon = telefon
        
        if re.match("^[A-Za-z0-9]+@[A-Z-a-z]+\.[A-Za-z]+", correu):
            self.__correu = correu
        
        if ciutat.isalpha():
            self.__ciutat = ciutat
    
    def __str__(self):
        client = 'Client(ID=' + str(self.id) + ', Nom=' + self.nom + ', Cognom=' + self.cognom + ', Telefon=' + str(self.telefon) + ', Correu=' + self.correu + ', Ciutat=' + self.correu +')'
        return client