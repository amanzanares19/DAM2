class Menu:
    
    
    def getOption():
        option = int(input("Escull una opció:"))
        return option
        
    
    def mostra_menu_principal(self):
        print("\n\nMENU PRINCIPAL \n==============================")
        print("Seleccioni una opció i premi Intro\n==============================")
        print("\t1. Afegir client" + "\n\t2. Eliminar client")
        print("\t3. Consultar client" + "\n\t4. Modificar un camp d'un client" + "\n\t5. Sortir")
        
        option = Menu.getOption()
        if option == 3:
            self.mostra_menu_consulta()
        
    
    def mostra_menu_consulta(self):
        print("\nMENU CONSULTA \n============================== \nSeleccioni una opció i premi Intro\n==============================")
        print("\t1. Cercar client per identificador" + 
              "\n\t2. Cercar client per nom" + "\n\t3. Cercar client per cognom" + 
              "\n\t4. Llistar tots els clients" + "\n\t3. Enrere")
    
        option = Menu.getOption()
        if option == 3:
            self.mostra_menu_consulta()
        
        
    
    
    def run(self):
        selectedOption = 0
        while selectedOption != 5:
            
            selectedOption = Menu.mostra_menu_principal(self)
            
            
            
            

if __name__ == '__main__':
    menu = Menu()
    menu.run()
        
