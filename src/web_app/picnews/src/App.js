import logo from './logo.svg';
import './App.css';
import Sidebar from './Components/Sidebar';
import Dash from './Components/Dashboard';
import MediaCard from './Components/Frame';
import newslist from './meta/sample_data.json';
import { React,Component } from 'react'
import { connect } from 'react-redux';
import {useState, useEffect} from 'react'; 
import Offline from './Components/Offline';
import {Route, BrowserRouter, Switch} from 'react-router-dom';
import firebase from 'firebase';
export default function App() {

  const [blogs,setBlogs]=useState([]);
  const [temp,setTemp]=useState('all');
  const fetchBlogs= async ()=>{
    const response = await firebase.firestore().collection('newsArticles').limit(50).get();
    console.log(response);
    response.forEach((elt)=>{
      setBlogs(prevblogs =>[...prevblogs,elt.data()]);
    })
  }
  useEffect(()=>{
    fetchBlogs(); // async function call 
  },[]);
  // const blogs = newslist;
  const reload = ()=>{
    // category based reload
    console.log('category is ',localStorage.getItem('category_selected'));
    setTemp(localStorage.getItem('category_selected'));
  }
  return (
    <div className="App" style={{backgroundColor:'#eeeeff'}}>
      <Dash/>
      {/* <code>
      <pre>{this.articles.length != 0 && this.articles}</pre>
      </code> */}
      <div className="column-sm" style={{position:'relative'}}>
        <Sidebar reload={reload} setBlogs={setBlogs}/>
      </div>
      <div className="column-lg" style={{position:'relative'}}>
        <BrowserRouter>
        <Route path="/" exact={true}>
        {blogs &&  blogs.map((blog) =>
            (localStorage.getItem('category_selected')=='all' || blog.category_tag == localStorage.getItem('category_selected'))?
            <MediaCard jsonS={JSON.stringify(blog)}/>:null)}
        </Route>
        <Route path="/offline" exact={true}>
          <Offline />
        </Route>
        </BrowserRouter>
        
      </div>
      {/* <code>
        {JSON.stringify(blogs)}
      </code> */}
    </div>
  );    
}


