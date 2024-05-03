import React, { useState } from 'react';
import { Button, Text, TextInput, View } from "react-native";
import { SafeAreaView } from 'react-native-safe-area-context';
import { createUserWithEmailAndPassword, getAuth, signInWithEmailAndPassword } from '@firebase/auth';

export const Login = ({ navigation }) => {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const auth = getAuth();


    function handleEmail(email:string) {
        
        setEmail(email);
    }

    function handlePassword(password:string) {
        
        setPassword(password);
    }

    const createUser = () => {
        createUserWithEmailAndPassword(auth, email, password)
            .then((userCredential) => {
                // Usuario creado exitosamente
                const user = userCredential.user;
                console.log("Login" + user);
                // Realizar acciones después de crear el usuario
            })
            .catch((error) => {
                const errorCode = error.code;
                const errorMessage = error.message;
                console.error(error);
                // Manejar errores aquí
            });
    }

    const signIn = () => {
        signInWithEmailAndPassword(auth, email, password)
            .then((userCredential) => {
                // Usuario ha iniciado sesión exitosamente
                const user = userCredential.user;
                console.log("Login" + user);
                // Realizar acciones después del inicio de sesión, como navegar a otra pantalla
            })
            .catch((error) => {
                const errorMessage = error.message;
                console.error(error);
                // Manejar errores aquí
            });
    }

    return (
        <View
          style={{
            flexDirection: 'row',
            height: 100,
            padding: 20,
          }}>

            <Text>Login</Text>

            <SafeAreaView>
                <Text>Email</Text>
                <TextInput
                    
                    onChangeText={handleEmail}
                    value={email}
                />
                
                <Text>Password</Text>
                <TextInput
                    
                    onChangeText={handlePassword}
                    value={password}
                    placeholder="useless placeholder"
                    keyboardType="numeric"
                    secureTextEntry={true}
                />
            </SafeAreaView>

            <Button
                title="Accedir-hi"
                onPress={() => 
                    navigation.navigate('Home')}
            />

            <Button
                title="Create"
                onPress={() => 
                    createUser()}
            />

            <Button
                title="Sign in"
                onPress={() => 
                    signIn()}
            />

        </View>
      );
};