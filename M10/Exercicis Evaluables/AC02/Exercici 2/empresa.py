
import client, postgres

class Empresa:    
    
    def __init__(self):
        
        self.llista_clients = []
        self.id_client = 0
    
    def get_llista_clients(self):

        self.llista_clients = postgres.get_clients()

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

        cliente = postgres.search_by_id(client_id)
        print(cliente.__str__())
        return cliente
                
    def cercar_per_nom(self, nom):
                        
        cliente = postgres.search_by_name(nom)
        print(cliente.__str__())
        return cliente
    
    def cercar_per_cognom(self, cognom):
                        
        cliente = postgres.search_by_surename(cognom)
        print(cliente.__str__())
        return cliente

                
    def modificar_client(self, id, **params):
                
        if postgres.update_client(id, params) > 0:
            print("Cliente modificado")
        else:
            print("Error al modificar cliente")
        
        
        
        
            
        
        
        

    