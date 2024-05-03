import { initializeApp } from 'firebase/app';
import { initializeAuth, getReactNativePersistence } from 'firebase/auth';
import ReactNativeAsyncStorage from '@react-native-async-storage/async-storage';
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { Home } from './src/view/Home';
import { Login } from './src/view/Login';

const firebaseConfig = {
  apiKey: "AIzaSyBC0r9EnzOlB6XgVsbfKZzqoB07qmS45qw",

  authDomain: "fir-5c96d.firebaseapp.com",

  projectId: "fir-5c96d",

  storageBucket: "fir-5c96d.appspot.com",

  messagingSenderId: "746619181264",

  appId: "1:746619181264:web:06d0fd2860977725cb26d5"
  // AQUÍ VUESTRA INFO
};

const app = initializeApp(firebaseConfig);
const auth = initializeAuth(app, {
    persistence: getReactNativePersistence(ReactNativeAsyncStorage)
});


export default function App() {

  const Stack = createNativeStackNavigator();

  return (
    
    <NavigationContainer>

      <Stack.Navigator> 
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="Login" component={Login} />        
      </Stack.Navigator>

    </NavigationContainer>


  );
}
