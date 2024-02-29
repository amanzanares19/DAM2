
import client, postgres

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
        postgres.insert_client(self.id_client, params[0], params[1], params[2], params[3], params[4])
        postgres.add_client(self.id_client)
    
    def eliminar_client(self, client_id):
                        
        if postgres.del_client(client_id) == 0: 
            return False
        return True
    
    def cercar_per_id(self, client_id):

        row = postgres.search_by_id(client_id)        
        cliente = client.Client(row[0], row[1], row[2], row[3], row[4], row[5])
        print(cliente.__str__())
                
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
        
        
        
            
        
        
        

    