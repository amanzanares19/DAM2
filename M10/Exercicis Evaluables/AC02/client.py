
import re

class Client:
    
    idList = []
    
    def __init__(self, id, nom, cognom, telefon, correu, ciutat):
        
        #Add id if not exists
        if not id in self.idList:            
            self.id = id
            self.idList.append(id)
            
        if nom.isalpha() & cognom.isalpha():
            self.nom = nom
            self.cognom = cognom
        
        if re.match("[+00][0-9-]{2}?[0-9]{6}[0-9]{4}|[+00][0-9-]{2}[0-9]{6}?[0-9]{4}", telefon):
            self.telefon = telefon
        self.correu = correu
        self.ciutat = ciutat
    
    def __str__(self):
        client = 'Client(ID=' + str(self.id) + ', Nom=' + self.nom + ', Cognom=' + self.cognom + ', Telefon=' + str(self.telefon) + ', Correu=' + self.correu + ', Ciutat=' + self.correu +')'
        return client



"""
telefono = "+0034-123456"
if re.match("[\+00][0-9][0-9-]?[0-9]{6,10}", telefono):
    print("ok")
else:
    print("not o")
    """
   