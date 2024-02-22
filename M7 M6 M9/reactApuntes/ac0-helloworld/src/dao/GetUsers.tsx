

export const GetUsers = async () => {


  const apiUrl = "http://localhost:8080"

  try {
    const response = await fetch(`${apiUrl}/users/`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'            
        }
    });
    if (response.ok) {
        const jsonData = await response.json();
        return jsonData;
    } else {
        alert(await response.text());
    }

} catch (error) {
    console.log('Error al obtener los datos:', error);
}

    

}