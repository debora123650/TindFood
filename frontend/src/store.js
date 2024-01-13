import {createStore} from 'vuex'
export default createStore({state : {cartItems:[],}, mutations: {addToCart(state, food){state.cartItems.push(food)}}  })


