import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import {createNativeStackNavigator} from "@react-navigation/native-stack";

export const Login = ({ navigation }) => {
  return (
      <View>
          <Text>Login</Text>
          <Button
              title="Accedir-hi"
              onPress={() => navigation.navigate('UserData')}
          />
      </View>
  );
}

export const UserData = ({ navigation }) => {
  return (
      <View>
          <Text>UserData</Text>
          <Button
              title="Sortir"
              onPress={() => navigation.navigate('Login')}
          />
      </View>
  );
}



export default function App() {
  const Stack = createNativeStackNavigator();
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Login">
        <Stack.Screen name="Login" component={LoginScreen} />
        <Stack.Screen name="UserData" component={UserScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}



/* import {View} from 'react-native';
import React from 'react';
import TableShow from './src/view/components/Tableshow'; */

/* Version 1
export default function App() {

  const [usuari, setUsuari] = useState(defaultUser);

  useEffect(() => {
    setUsuari(defaultUser);
  }, []);

  return (
    <React.Fragment>
        <View style={flex.container1}>
            <Text>Hello World</Text>            
        </View>
        <View style={flex.container2}>
            <Text>{usuari.username}</Text>          
        </View>
        <View style={flex.container3}>
            <Text>{usuari.edat}</Text>          
        </View>
    </React.Fragment>
  );
}
*/

/*Version 2
export default function App() {

  const [holamundo, setHolaMundo] =
   useState();

  useEffect(() => {
    setHolaMundo(new HelloWorldModel("Hola", "Mundo", "Alex"));
    setHolaMundo(new HelloWorldModel()); //Por defecto
  }, []);

  return (
    <React.Fragment>
        <View style={flex.container1}>
            <Text>{holamundo?.hola}</Text>            
        </View>
        <View style={flex.container2}>
            <Text>{holamundo?.mundo}</Text>          
        </View>
        <View style={flex.container3}>
            <Text>{holamundo?.nombre}</Text>          
        </View>
    </React.Fragment>
  );
}
*/

/*Version 3 JSON
export default function App() {

  const [holamundo, setHolaMundo] =
   useState();
  
  const [json, setJson] = useState(
    {
      "hola": "hola",
      "mundo": "mundo",
      "nombre": "JSON",
    }    
  );

  useEffect(() => {
    setHolaMundo(json);
  }, []);

  return (
    <React.Fragment>
        <View style={flex.container1}>
            <Text>{holamundo?.hola}</Text>            
        </View>
        <View style={flex.container2}>
            <Text>{holamundo?.mundo}</Text>          
        </View>
        { "JSON" === holamundo?.nombre &&
          <View style={flex.container3}>
              <Text>{holamundo?.nombre}</Text>          
          </View>
        }
    </React.Fragment>
  );
}*/

/* export default function App() {

  const [text, onChangeText] = React.useState('');
  const [text2, onChangeText2] = React.useState('');

  return (
    <View style={flex.mainContainer}>
      <Image
        style={imageStyle.tinyLogo}
        source={require('./src/images/pato.jpg')}
      />
      <TextInput
          style={loginStyles.input}
          onChangeText={onChangeText}
          value={text}
          placeholder="Username"
        />  
      <TextInput
          style={loginStyles.input}
          onChangeText={onChangeText2}
          value={text2}
          placeholder="Password"
        />  
      <Button title="Press me"
        onPress={() => Alert.alert('Simple Button pressed')}
        />
    </View>
  );
} */

/* Listas
export default function App() {

  return (

    <View>

      <TableShow />

    </View>

  );
} */