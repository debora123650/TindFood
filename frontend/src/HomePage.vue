<template>
    <div>
        <header class="header-section">
            <div class="container">
                <nav>
                    <ul class="menu">
                        <li class="ui-menu-item"><router-link to="/">Home</router-link></li>
                        <li class="ui-menu-item"><router-link to="/shoppinglist">List</router-link></li>
                        <li class="ui-menu-item"><a href="http://localhost:8080">Contact</a></li>

                    </ul>
                    <router-link to="/login" class="header-button">Login</router-link>

                </nav>

                <h1>Taste with TindFood</h1>
                <h2>Enjoy eating</h2>

                <button class="button header-button">Get started</button>


            </div>
        </header>


        <main>
            <input type="text" v-model="searchQuery" placeholder="Search for products..." />
            <button @click="searchProducts">Search</button>

            <input type="text" v-model="inputValue" placeholder="Enter something..." />
            <input type="number" v-model.number="selectedNumber" min="1" max="10" />
            <button @click="sendData">Send</button>


        </main>
        <food-cards  @choose="handleFoodChoice"></food-cards>
        <footer>
        </footer>
    </div>
</template>

<style>
@import './CSS.css';
</style>



<script>
import { ref } from 'vue';
import FoodCards from './FoodCards.vue';

export default {
    setup() {
        const inputValue = ref('');
        const selectedNumber = ref(1);
        const foods = ref([])
        const items = ref([]);
        const likedFoods = ref([]);
        const shoppingList = ref([]);

        const searchQuery = ref('');

        const fetchData = async () => {

            try {
                const response = await fetch('http://localhost:8081/foods');
                if (response.ok) {
                    const data = await response.json();
                    foods.value = data; // Assign data to foods
                } else {
                    console.error('Error:', response.statusText);
                }
            } catch (error) {
                console.error('Error:', error);
            }
        };


        const sendData = async () => {
            try {
                await fetch('http://localhost:8081/foods', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        name: inputValue.value,
                        price: selectedNumber.value
                    }),
                });
            } catch (error) {
                console.error('Error:', error);
            }
        };


        const searchProducts = () => {
            fetchDataSearch()
        }




        const fetchDataSearch = async () => {

            try {
                const response = await fetch(`http://localhost:8081/foods?search=Tomatoes`);
                if (response.ok) {
                    const data = await response.json();
                    foods.value = data; // Assign data to foods
                } else {
                    console.error('Error:', response.statusText);
                }
            } catch (error) {
                console.error('Error:', error);
            }
        };






        return {
            searchQuery,
            fetchData,
            inputValue,
            selectedNumber,
            items,
            likedFoods,
            shoppingList,
            sendData,
            fetchDataSearch,
            searchProducts
        };
    },
    components: {
        FoodCards,
    },
};
</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>
