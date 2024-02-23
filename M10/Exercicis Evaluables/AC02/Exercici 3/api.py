import requests

#Obtén espécie
especie = input("Dime una espécie: ")

#Acceso a API
res = requests.get("https://rickandmortyapi.com/api/character/?species=" + especie)
json = res.json()

#Listar personajes
for element in json['results']:
    print('Nombre: ', element['name'], '| espécie: ', element['species'], '\n')