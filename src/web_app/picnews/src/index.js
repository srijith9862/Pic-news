import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {Provider} from 'react-redux';
import store from './store/index'
import firebase from 'firebase/app';
  // Your web app's Firebase configuration
  // For Firebase JS SDK v7.20.0 and later, measurementId is optional
var firebaseConfig = {
    apiKey: "AIzaSyCN802pFoIFF1ePKiBSwobjM-9GSwmyWZs",
    authDomain: "picnews-96ced.firebaseapp.com",
    databaseURL: "https://picnews-96ced-default-rtdb.europe-west1.firebasedatabase.app",
    projectId: "picnews-96ced",
    storageBucket: "picnews-96ced.appspot.com",
    messagingSenderId: "147491934085",
    appId: "1:147491934085:web:9544ca83c182e738d37eec",
    measurementId: "G-63CRC7ST8L"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
// firebase.analytics();

window.store = store
localStorage.setItem('category_selected','all')
ReactDOM.render(

  <Provider store={store}>
    <App />
  </Provider>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
