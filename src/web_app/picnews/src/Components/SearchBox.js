import React from "react";
import InputLabel from '@material-ui/core/InputLabel';
import Input from '@material-ui/core/Input';
import FormControl from '@material-ui/core/FormControl';
import { FormHelperText, Button } from '@material-ui/core';
import DialogSelect from './CategoryDD';
import axios from 'axios';
import firebase from 'firebase';
const NewsAPI = require("newsapi");
const newsapi = new NewsAPI("b6fa249939424bcc8997f87ae1b61bc7");


export default class SearchBox extends React.Component{
  constructor(props){
    super()
    this.state = {
      query : '',
      country:"all",
      category:"all",
      language:"all",
      date_upper:"all",
      date_lower:"all",
    }
  }

  dsc=(type,final_value)=>{
    if(type=="category"){
      this.setState({
        category:final_value
      })
    }
    else if(type=="language"){
      this.setState({
        language:final_value
      })
    }
  }
  render(){
  const sendRequest= ()=>{
    axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
    axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
    axios.get('https://newsapi.org/v2/everything?q='+this.state.query+'&sortBy=publishedAt&apiKey=b6fa249939424bcc8997f87ae1b61bc7')
    .then(response=>{
      console.log(response.data.articles);
      this.props.setBlogs(response.data.articles);
    })
    .catch(err=>{
      console.log("Why?? :: ",err);
    })
    
    // var callFunc = firebase.functions().httpsCallable('searchQuery');
    // callFunc(this.state)
    // .then((result)=>{
    //   console.log('RESULT IS :: ',JSON.stringify(result));
    // })
    // .catch(err=>{
    //   console.log('Error :: ',err);
    // });
    axios.get()
  }

  return (
    <div>
        
        <FormControl>
            <InputLabel htmlFor="my-input">Search</InputLabel>
            <Input id="my-input" value={this.state.query} onChange={(event)=>{this.setState({query:event.target.value})}} aria-describedby="my-helper-text" />
            <FormHelperText id="my-helper-text">Search for news</FormHelperText>
        </FormControl>
        <DialogSelect changeState={this.dsc}/>
        <Button onClick={(event)=>{
          event.preventDefault();
          sendRequest();
        }}variant="contained">Search</Button>
    </div>
  );
}
};