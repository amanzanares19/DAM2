import { initializeApp } from 'firebase/app';

// Imports opcionales para otras opciones de firebase
// import {...} from "firebase/auth";
// import {...} from "firebase/database";
// import {...} from "firebase/firestore";
// import {...} from "firebase/functions";
// import {...} from "firebase/storage";

// Inicializar Firebase (REEMPLAZARLO CON EL CONTENIDO DE REGISTRAR TU APP)
const firebaseConfig = {
  apiKey: 'api-key',
  authDomain: 'project-id.firebaseapp.com',
  databaseURL: 'https://project-id.firebaseio.com',
  projectId: 'project-id',
  storageBucket: 'project-id.appspot.com',
  messagingSenderId: 'sender-id',
  appId: 'app-id',
  measurementId: 'G-measurement-id',
};

// Inicializar Firebase
const app = initializeApp(firebaseConfig);
// más info: https://firebase.google.com/docs/web/setup#access-firebase
