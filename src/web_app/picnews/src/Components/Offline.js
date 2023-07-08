import React from 'react';
import MediaCard from './Frame';
// const fs = require('fs');
import data1 from './../meta/json_database.json';


export default class Offline extends React.Component{
    constructor(props){
        super();
        this.state={
            data:[]
        }
        this.readF()
    }
    readF=()=>{
        this.setState({
            data: localStorage.getItem('offline')==null?[]:JSON.parse(localStorage.getItem('offline'))
        });
    }

    render(){
        return (
            <div id="offline">
                { localStorage.getItem('offline') && JSON.parse(localStorage.getItem('offline')).map((elt)=>
                    <MediaCard jsonS={JSON.stringify(elt)}/>
                )}
            </div>
        )
    }

}