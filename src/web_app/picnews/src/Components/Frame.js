import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import clsx from 'clsx';
import Image from 'react-bootstrap/Image'
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardMedia from '@material-ui/core/CardMedia';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Collapse from '@material-ui/core/Collapse';
import Avatar from '@material-ui/core/Avatar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import { red } from '@material-ui/core/colors';
import ShareIcon from '@material-ui/icons/Share';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import MoreVertIcon from '@material-ui/icons/MoreVert';
import SaveIcon from '@material-ui/icons/Save';
import LinkIcon from '@material-ui/icons/Link';
import { Save } from '@material-ui/icons';
const useStyles = makeStyles((theme) => ({
  root: {
    marginLeft: '20%',
    marginRight: '20%',
    marginTop:'5%',
    marginBottom:'5%',
    maxWidth: '60%',
    backgroundColor:'#ededff'
  },
  media: {
    height: 0,
    paddingTop: '56.25%', // 16:9
  },
  expand: {
    transform: 'rotate(0deg)',
    marginLeft: 'auto',
    transition: theme.transitions.create('transform', {
      duration: theme.transitions.duration.shortest,
    }),
  },
  expandOpen: {
    transform: 'rotate(180deg)',
  },
  avatar: {
    backgroundColor: red[500],
  },
}));

export default function MediaCard(props) {
  const classes = useStyles();
  const [expanded, setExpanded] = React.useState(false);
  // alert(JSON.stringify(jsonS))
  const jsonObj = JSON.parse(props["jsonS"]);  // stringify JSON string
  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  return (
    <Card className={classes.root} style={{backgroundColor:'rgba(255,255,255,1)'}}>
      <CardHeader
        avatar={
          <Avatar aria-label={jsonObj["tag"]==null?jsonObj["category_tag"]:jsonObj["tag"]} className={classes.avatar}>
            {((jsonObj["tag"]==null?jsonObj["category_tag"]:jsonObj["tag"])+"").substring(0,1)}
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        title={((jsonObj["source"] == null || jsonObj["source"]["name"]==null)?"":jsonObj["source"]["name"])+(jsonObj["author"]==null?"":(" | "+jsonObj["author"]))}
        subheader={new Date(jsonObj["publishedAt"]).toUTCString()}
      />
      <Image src={jsonObj["urlToImage"]} style={{width:'70%',}} fluid />
      <CardContent>
        <Typography variant="body" color="textSecondary" component="h3">
          {jsonObj["title"]}
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="open article in source">
          <LinkIcon onClick={()=>{window.location.href=jsonObj["url"]}}/>
        </IconButton>
        <IconButton aria-label="share" onClick={() => {navigator.clipboard.writeText(jsonObj["url"])}}>
          <ShareIcon />
        </IconButton>
        <IconButton aria-label="save" onClick={()=>{
          console.log('Deb : ',seg,JSON.parse(localStorage.getItem('offline')))
          // var seg = []
          var seg = JSON.parse(localStorage.getItem('offline')) || [];
          if(seg==null || seg.length == 0){
            localStorage.setItem('offline',JSON.stringify([]));
            seg = [];
          }
          console.log('JSON Object : ',jsonObj)
          console.log(typeof(seg));
          seg.push(jsonObj);
          console.log('Segment : ',seg);
          localStorage.setItem('offline',JSON.stringify(seg));
        }}>
          <SaveIcon/>
        </IconButton>
        <IconButton
          className={clsx(classes.expand, {
            [classes.expandOpen]: expanded,
          })}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </IconButton>
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
          <Typography paragraph>
            
          </Typography>
          <Typography paragraph>
          {jsonObj["description"]}
          </Typography>
        </CardContent>
      </Collapse>
    </Card>
  );
}
//   return (
//     <Card className={classes.root}>
//       <CardActionArea>
//       <CardContent>
//           <Typography className={classes.secondarytext} variant="body2" color="textSecondary" component="p">
//             <p style={{float:'left'}}>ESPN-Sports | Martha Grey</p>
//             <p style={{float:'right'}}>London, UK</p>
//           </Typography>
//         </CardContent>
//         <CardMedia
//           component="img"
//           alt="Contemplative Reptile"
//           height="140"
//           image="./../assets/Smith.jpeg"
//           title="Contemplative Reptile"
//         />
//         <CardContent>
//           <Typography className={classes.headText} gutterBottom variant="h5" component="h2">
//             England Asks, "How to get Steve Smith out?"
//           </Typography>
//           <Typography className={classes.secondarytext} variant="body2" color="textSecondary" component="p">
//           Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
//           </Typography>
//         </CardContent>
//       </CardActionArea>
//       <CardActions>
//       <Button variant="contained">Share</Button>
//       <Button variant="contained">Read News</Button>
//       </CardActions>
//     </Card>


