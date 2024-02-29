import empresa

class Menu:
    
    
    def getOption():
        option = int(input("Escull una opció:"))
        return option
    
    def selectClientOption(self, opt, empresa):
        
        if opt == 1:
                       
            name = input("Nombre: ")
            surname = input("Cognom: ")
            tel = input("Telefon: ")
            email = input("Correu: ")
            city = input("Ciutat: ")        
            
            #Creamos cliente
            empresa.afegir_client(name, surname, tel, email, city)
            print("Cliente " + name + " añadido correctamente")                                    
        
        if opt == 2:
            
            id_client = int(input("Id del client a eliminar: "))
            if empresa.eliminar_client(id_client):
                print("Cliente eliminado correctamente")
            else:
                print("No existe ningún cliente con el id proporcionado")
                
        if opt == 3:
            self.mostra_menu_consulta(empresa)
        
        if opt == 4:
            
            id_client = int(input("Id del client a modificar: "))
            name = input("Nombre: ")
            
            #Modify fields
            empresa.modificar_client(id_client, name, cognom = input("Cognom: "), telefon = input("Telefon: "), correu = input("Correu: "), ciutat = input("Ciutat: ") )
        
    def selectConsultaOption(self, opt, empresa):
        if opt == 1:
            cliente = empresa.cercar_per_id(int(input("ID del cliente: ")))
            print(cliente.__str__())
        if opt == 2:
            cliente = empresa.cercar_per_nom(input("Nombre del cliente: "))
            print(cliente.__str__())
        if opt == 3:
            cliente = empresa.cercar_per_cognom(input("Apellido del cliente: "))
            print(cliente.__str__())
        if opt == 4:
            empresa.get_llista_clients()      
        
    
    def mostra_menu_principal(self, empresa):
        print("\n\nMENU PRINCIPAL \n==============================")
        print("Seleccioni una opció i premi Intro\n==============================")
        print("\t1. Afegir client" + "\n\t2. Eliminar client")
        print("\t3. Consultar client" + "\n\t4. Modificar un camp d'un client" + "\n\t5. Sortir")
        
        option = Menu.getOption()
        
        if option == 5:
            return option
        
        return self.selectClientOption(option, empresa)
        
        
    def mostra_menu_consulta(self, empresa):
        print("\nMENU CONSULTA \n============================== \nSeleccioni una opció i premi Intro\n==============================")
        print("\t1. Cercar client per identificador" + 
              "\n\t2. Cercar client per nom" + "\n\t3. Cercar client per cognom" + 
              "\n\t4. Llistar tots els clients" + "\n\t5. Enrere")
    
        option = Menu.getOption()        
        if option == 5:
            self.mostra_menu_principal()
        else:            
            self.selectConsultaOption(option, empresa)
        
        
    
    
    def run(self):
        selectedOption = 0
        e = empresa.Empresa()        
        while selectedOption != 5:
            
            selectedOption = Menu.mostra_menu_principal(self, e)
            
            
            
            

if __name__ == '__main__':
    menu = Menu()
    menu.run()
        
