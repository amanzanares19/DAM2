
import re

class Client:
    
    
    def __init__(self, id, nom, cognom, telefon, correu, ciutat):
    
        #Add id if not exists            
        self.id = id          
            
        if re.match("^[A-Z][a-z]*$", nom) and re.match("^[A-Z][a-z]*$", cognom):
            self.nom = nom
            self.cognom = cognom  
        else:
            raise Exception("Nombre o apellido incorrecto")      
        
        if re.match("\+00[0-9]{2}-[0-9]{6,10}", telefon) or re.match("[0-9]{6,10}", telefon):
            self.telefon = telefon                     
        else:
            raise Exception("Telefono no sigue el formato")      
        
        if re.match("^[A-Za-z0-9]+@[A-Z-a-z]+\.[A-Za-z]+", correu):
            self.correu = correu
        else:
            raise Exception("Correo no sigue el formato")      
        
        if ciutat.isalpha():
            self.ciutat = ciutat
        else:
            raise Exception("Ciudad incorrecto")      
    
    def __str__(self):
        client = 'Client(ID=', str(self.__getattribute__("id")), ', Nom=' + self.__getattribute__("nom"), ', Cognom=', self.__getattribute__("cognom") , ', Telefon=' + str(self.__getattribute__("telefon")), ', Correu=', self.__getattribute__("correu"), ', Ciutat=', self.__getattribute__("ciutat"),')'
        return client
