
import re, client

class Empresa:    
    
    def __init__(self, llista_clients, id_client):
        
        self.__llista_clients  = llista_clients
        self.__id_client = id_client
    
    def get_llista_clients(self):
        
        for client in self.llista_clients:
            print(client)
    
    def afegir_client(self, *params):
                
        id = client.Client.contador + 1
        new_client  = client.Client(id, params[0], params[1], params[2], params[3], params[4])
        self.llista_clients.append(new_client)
    
    def eliminar_client(self, client_id):
                        
        for c in self.llista_clients:
            if c.id == client_id:
                self.__llista_clients.remove(c)
                break
    
    def cercar_per_id(self, client_id):
                        
        for c in self.llista_clients:
            if c.id == client_id:
                print(c)
                return c
                
    def cercar_per_nom(self, nom):
                        
        for c in self.llista_clients:
            if c.nom == nom:
                print(c)
                return c
    
    def cercar_per_id(self, cognom):
                        
        for c in self.llista_clients:
            if c.cognom == cognom:
                print(c)
                return c
                
    def modificar_client(self, id, nom, **params):
        
        client = self.cercar_per_id(id)
        client.__setattr__("nom", nom)
        if "cognom" in params:
            client.__setattr__("cognom", params["cognom"])
            println("Cognom modificat")
        if "telefon" in params:
            client.__setattr__("telefon", params["telefon"])
            println("telefon modificat")
        if "correu" in params:
            client.__setattr__("correu", params["correu"])
            println("Correu modificat")
        if "ciutat" in params:
            client.__setattr__("ciutat", params["ciutat"])
            println("Ciutat modificada")
        
        
        
            
        
        
        

    