import { useEffect, useState } from "react"
import { View, Text } from "react-native"
import { GetUsers } from "../../dao/GetUsers";

export default function Conexion({navigation}) {

    const [showUsers, setShowUser] = useState(false);

    async function checkData() {
        /* setShowModal(await GetUsers()); */
        await GetUsers();
                      
    }

    useEffect(() => {
        checkData();
      }, []);

    return (
        
        <View>            
            
        </View>

    )

}