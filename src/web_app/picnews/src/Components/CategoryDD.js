import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import InputLabel from '@material-ui/core/InputLabel';
import Input from '@material-ui/core/Input';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';

const useStyles = makeStyles((theme) => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  formControl: {
    margin: theme.spacing(1),
    minWidth: 120,
  },
}));

export default function DialogSelect(props) {
  const classes = useStyles();
  const [open, setOpen] = React.useState(false);
  const [category, setAge] = React.useState('');
  const [language,sassy] = React.useState('');

  const handleChange = (event) => {
    props.changeState("category",event.target.value);
    setAge(event.target.value);
  };
  
  const handleChange2 = (event) => {
    props.changeState("language",event.target.value);
    sassy(event.target.value);
  };
  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      <Button onClick={handleClickOpen}>Add Filters</Button>
      <Dialog disableBackdropClick disableEscapeKeyDown open={open} onClose={handleClose}>
        <DialogTitle>Fill the form</DialogTitle>
        <DialogContent>
          <form className={classes.container}>
            <FormControl className={classes.formControl}>
              <InputLabel htmlFor="demo-dialog-native">Category</InputLabel>
              <Select
                native
                value={category}
                onChange={handleChange}
                input={<Input id="demo-dialog-native" />}
              >
                <option aria-label="None" value="None" />
                <option value={"sports"}>Sports</option>
                <option value={"politics"}>Politics</option>
                <option value={"entertainment"}>Entertainment</option>
                <option value={"economics"}>Business and Economics</option>
              </Select>
            </FormControl>
            
            <FormControl className={classes.formControl}>
              <InputLabel id="demo-dialog-select-label">Language</InputLabel>
              <Select
                labelId="demo-dialog-select-label"
                id="demo-dialog-select"
                value={language}
                onChange={handleChange2}
                input={<Input />}
              >
                <MenuItem value="">
                  <em>None</em>
                </MenuItem>
                <MenuItem value={"English"}>English</MenuItem>
                <MenuItem value={"Hindi"}>Hindi</MenuItem>
                <MenuItem value={"Mandarin"}>Mandarin</MenuItem>
                <MenuItem value={"Arabic"}>Arabic</MenuItem>
                <MenuItem value={"Hebrew"}>Hebrew</MenuItem>
                <MenuItem value={"Dutch"}>Dutch</MenuItem>
              </Select>
            </FormControl>
          </form>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Cancel
          </Button>
          <Button onClick={handleClose} color="primary">
            Ok
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
