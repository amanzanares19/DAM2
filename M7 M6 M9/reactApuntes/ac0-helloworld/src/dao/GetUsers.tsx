

export const GetUsers = async () => {


  const apiUrl = "http://10.200.243.221:8080";

  try {
    const response = await fetch(`${apiUrl}/users`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'            
        },

    });
    if (response.ok) {
        const jsonData = await response.json();        
        console.log(jsonData);
        
    } else {
        alert(await response.text());
    }

} catch (error) {
    console.log('Error al obtener los datos:', error);
}

    

}