import { createRouter, createWebHistory } from 'vue-router';
import LoginSeite from '../LoginSeite.vue';
import ShoppingList from '../ShoppingList.vue';
import HomePage from '../HomePage.vue';
import FoodCards from "@/FoodCards.vue";
import Contact from '../ContactPage.vue';


const routes = [
    {
        path: '/',
        name: 'Home',
        component: HomePage,
    },
    {
        path: '/login',
        name: 'Login',
        component: LoginSeite,
    },
    {
        path: '/shoppinglist',
        name: 'ShoppingList',
        component: ShoppingList,
    },

    {
        path: '/foods',
        name: 'Food',
        component: FoodCards,
    },

    {
        path: '/contact',
        name: 'Contact',
        component: Contact,
    },

];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});

export default router;
