import React from 'react'
import './Sidebar.css'
import List from '@material-ui/core/List'
import ListItem from '@material-ui/core/ListItem'
import ListItemText from '@material-ui/core/ListItemText'
import {RadioGroup, FormControlLabel,Radio, FormLabel, FormControl } from '@material-ui/core';
import SearchBox from './SearchBox';
const ColoredLine = ({ color }) => ( <hr style={{ color: color, backgroundColor: color, height: 5 }} /> );

function Sidebar(props) {
    const [val,setter] = React.useState(localStorage.getItem('category_selected'));
    const handleChange = (event)=>{
        // redux call later on
        localStorage.setItem('category_selected',event.target.value)
        setter(event.target.value);
        props.reload()
    }
  return (
    <List disablePadding dense>
      <ListItem button>
        <ListItemText className="content-text">
          <a href="/">
            <p style={{fontFamily:'serif',fontSize:'large',color:'blue'}}>
                HOME
            </p>
          </a>
        </ListItemText>
      </ListItem>
      <ListItem button>
        <ListItemText className="content-text">
          <a href="/offline">
            <p style={{fontFamily:'serif',fontSize:'large',color:'blue'}}>
                MY STORIES
            </p>
          </a>
        </ListItemText>
      </ListItem>
      <ListItem button>
        <ListItemText className="content-text">
            <SearchBox setBlogs={props.setBlogs}/>
        </ListItemText>
      </ListItem>
        <ColoredLine color={'black'}/>
      <ListItem button>
        <ListItemText className="content-text">
        <FormControl component="fieldset">
  <FormLabel component="legend">See news by category</FormLabel>
  <RadioGroup aria-label="gender" name="gender1" value={val} onChange={handleChange}>
    <FormControlLabel value="sports" control={<Radio />} label="Sports" />
    <FormControlLabel value="technology" control={<Radio />} label="Technology" />
    <FormControlLabel value="entertainment" control={<Radio />} label="Entertainment" />
    <FormControlLabel value="politics" control={<Radio />} label="Politics" />
    <FormControlLabel value="business" control={<Radio />} label="Economics" />
    <FormControlLabel value="all" control={<Radio />} label="All" />

    {/* <FormControlLabel value="disabled" disabled control={<Radio />} label="(Disabled option)" /> */}
  </RadioGroup>
</FormControl>
        </ListItemText>
      </ListItem>
    </List>
  )
}

export default Sidebar
