import React from "react";
import { View ,Text} from "react-native";
import { useState } from "react";


function TableShow() {
    
  
  const [json, setJson] = useState(
      [
        {
      "id":0,
      "username": "Alex",
      "edat": 20,
      "password": "1234",
      "email": "example@edt.org"
      },
      {
      "id":1,
      "username": "Alex",
      "edat": 20,
      "password": "1234",
      "email": "example@edt.org"
      }
    ]      
  )

  return (
    <View>
        <Text>Table</Text>
      {
        json?.map((element) => (
            <View key={element.id}>
                <Text>Nombre</Text>
                <Text>id: {element.id}</Text>
                <Text>Username: {element.username}</Text>
                <Text>Edat: {element.edat}</Text>
                <Text>Email: {element.email}</Text>
            </View>
        ))
      }
    </View>
  );

};

export default TableShow;