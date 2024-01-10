<template>
    <div>

            <header class="header-section">
                <div class="container">
                    <nav>
                        <ul class="menu">
                            <li class="ui-menu-item"><a href="http://localhost:8080">Home</a></li>
                            <li class="ui-menu-item"><a href="http://localhost:8080">Menu</a></li>
                            <li class="ui-menu-item"><a href="http://localhost:8080">Favourites</a></li>
                            <li class="ui-menu-item"><a href="http://localhost:8080">List</a></li>
                            <li class="ui-menu-item"><a href="http://localhost:8080">Contact</a></li>
                        </ul>

                        <button class="search-button"><span class="search-icon"></span></button>
                        <button class="button">Login</button>

                    </nav>

                    <h1>Taste with TindFood</h1>
                    <h2>Enjoy eating</h2>

                    <button class="button">Get started</button>
                </div>
            </header>

        <main>
            <food-cards :foods="foods" @choose="handleFoodChoice"></food-cards>

            <table>
                <tr v-for="food in foods" :key="food.id">
                    <td><img :src="food.image" alt="Food Image" @click="changeFoodImage(food)" /></td>
                    <td>{{ food.name }}</td>
                    <td>{{ food.price }}</td>
                    <td><button @click="addToCart(food)">Add to Cart</button></td>
                    <td><button @click="likeFood(food)">Like</button></td>
                </tr>
            </table>

            <input type="text" v-model="inputValue" placeholder="Enter something..." />
            <input type="number" v-model.number="selectedNumber" min="1" max="10" />
            <button @click="sendData">Send</button>
        </main>

        <footer>
        </footer>
    </div>
</template>

<style>
@import './CSS.css';
</style>



<script>
import FoodCards from './FoodCards.vue';

export default {
    data() {
        return {
            inputValue: '',
            selectedNumber: 1,
            items: [],
            foods: [
                { id: 1, name: 'Food 1', image: 'path/to/image1.jpg', liked: false },
                { id: 2, name: 'Food 2', image: 'path/to/image2.jpg', liked: false },
            ],
            likedFoods: [],
            shoppingList: [],
        };
    },
    methods: {
        async sendData() {
            try {
                const response = await fetch('http://localhost:8081/foods', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        name: this.inputValue,
                        price: this.selectedNumber,
                    }),
                });
                if (response.ok) {
                    this.fetchData();
                } else {
                    console.error('Error:', response.statusText);
                }
            } catch (error) {
                console.error('Error:', error);
            }
        },
        async fetchData() {
            try {
                const response = await fetch('http://localhost:8081/foods');
                if (response.ok) {
                    const data = await response.json();
                    this.items = data;
                } else {
                    console.error('Error:', response.statusText);
                }
            } catch (error) {
                console.error('Error:', error);
            }
        },
        handleFoodChoice({ action, food }) {
            if (action === 'like') {
                this.likeFood(food);
            } else if (action === 'dislike') {
                this.dislikeFood(food);
            } else if (action === 'addToCart') {
                this.addToCart(food);
            }
        },
        addToCart(food) {
            food.inCart = true;
            this.shoppingList.push({ id: food.id, name: food.name, quantity: 1 });
        },
        likeFood(food) {
            food.liked = !food.liked;
            if (food.liked) {
                this.likedFoods.push(food);
            } else {
                const index = this.likedFoods.findIndex((likedFood) => likedFood.id === food.id);
                if (index !== -1) {
                    this.likedFoods.splice(index, 1);
                }
            }
        },
        dislikeFood(food) {
            food.liked = false;
            const index = this.likedFoods.findIndex((likedFood) => likedFood.id === food.id);
            if (index !== -1) {
                this.likedFoods.splice(index, 1);
            }
        },
    },
    mounted() {
        this.fetchData();
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





















