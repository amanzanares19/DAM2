import React from 'react';
import { Button, Text, View } from "react-native";

export const Home = ({ navigation }) => {


    return (
        <View
          style={{
            flexDirection: 'row',
            height: 100,
            padding: 20,
          }}>

          <Text>Home</Text>
            <Button
                title="Accedir-hi"
                onPress={() => navigation.navigate('Login')}
            />
            
        </View>
    );
};