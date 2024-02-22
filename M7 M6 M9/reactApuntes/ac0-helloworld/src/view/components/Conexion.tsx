import { useEffect, useState } from "react"
import { View, Text } from "react-native"
import { GetUsers } from "../../dao/GetUsers";

export default function Conexion({navigation}) {

    const [showModal, setShowModal] = useState({
        username: "1",
        email: "2",
        password: "3"
    });

    async function checkData() {
        setShowModal(await GetUsers());                
    }

    useEffect(() => {
        checkData();
      }, []);

    return (
        
        <View>            
            <Text>{showModal?.username}</Text>
            <Text>{showModal?.email}</Text>
            <Text>{showModal?.password}</Text>
        </View>

    )

}