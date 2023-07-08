import { act } from 'react-dom/test-utils';
import { createStore } from 'redux'

const initialState = {
    news_data : [],
    selected_category : 'All',
}
/**
 * 
 * @param {state that is to be changed / or the initial state by default} state 
 * @param {contains js object to show details of what and how is it to be changed} action 
 */
const reducer = (state = initialState, action) => { 
    if (action.type === 'CHANGE_CATEGORY') {
        return Object.assign({},state,{
            selected_category : action.category_value
        });
    }
    else if(action.type == 'INSERT_DATA'){
        return Object.assign({},state,{
            news_data : state.news_data.concat(action.data_list)
        })
    }
  return state
}

const store = createStore(reducer)

export default store