
import client

class Empresa:    
    
    def __init__(self):
        
        self.llista_clients = []
        self.id_client = 0
    
    def get_llista_clients(self):

        if not self.llista_clients:
            print("No hay clientes")
        else:        
            for client in self.llista_clients:
                print(client.__str__())
    
    def afegir_client(self, *params):
                
        self.id_client = self.id_client + 1
        new_client  = client.Client(self.id_client, params[0], params[1], params[2], params[3], params[4])
        self.llista_clients.append(new_client)
    
    def eliminar_client(self, client_id):
                        
        for c in self.llista_clients:
            if c.id == client_id:
                self.llista_clients.remove(c)
                return True
        return False
    
    def cercar_per_id(self, client_id):

        for c in self.llista_clients:
            if c.id == client_id:
                return c
                
    def cercar_per_nom(self, nom):
                        
        for c in self.llista_clients:
            if c.nom == nom:
                return c
    
    def cercar_per_cognom(self, cognom):
                        
        for c in self.llista_clients:
            if c.cognom == cognom:
                return c
                
    def modificar_client(self, id, nom, **params):
        
        client = self.cercar_per_id(id)
        client.__setattr__("nom", nom)
        print("Nom modificat\n")
        if "cognom" in params:
            client.__setattr__("cognom", params["cognom"])
            print("Cognom modificat\n")
        if "telefon" in params:
            client.__setattr__("telefon", params["telefon"])
            print("telefon modificat\n")
        if "correu" in params:
            client.__setattr__("correu", params["correu"])
            print("Correu modificat\n")
        if "ciutat" in params:
            client.__setattr__("ciutat", params["ciutat"])
            print("Ciutat modificada")
        
        
        
            
        
        
        

    