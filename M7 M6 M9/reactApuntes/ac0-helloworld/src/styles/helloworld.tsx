import { StyleSheet } from 'react-native';
import { commons, divs } from './commons';

export const helloWorld = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: commons.MainColor.backgroundColor,
      alignItems: 'center',
      justifyContent: 'center',
    },
  });

export const flex = StyleSheet.create({
    container1: {
      flex: 1,
      backgroundColor: divs.div1.backgroundColor,
      alignItems: 'center',
      justifyContent: 'center',
    },
    container2: {
      flex: 1,
      backgroundColor: divs.div2.backgroundColor,
      alignItems: 'center',
      justifyContent: 'center',
    },
    container3: {
      flex: 1,
      backgroundColor: divs.div3.backgroundColor,
      alignItems: 'center',
      justifyContent: 'center',
    },
    mainContainer: {
      flex: 1,
      backgroundColor: divs.div1.backgroundColor,
      alignItems: 'center',
      justifyContent: 'center',
      flexDirection: "column",
    }
  });