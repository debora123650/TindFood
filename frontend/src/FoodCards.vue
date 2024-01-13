<template>
    <div class="food-cards-container">
        <div v-for="food in foods" :key="food.id" class="food-card">
            <img :src= "food.image" alt="Food Image" />
            <div class="food-content">
                <p>{{ food.name }}</p>
                <p>{{ food.price }}</p>
            </div>
            <div class="food-buttons">
                <button class="add-to-cart-button" @click="addToCart(food)">Add to Cart</button>
            </div>
        </div>
    </div>
</template>


<script>

export default {
    data() {
        return {
            foods: [],
        };
    },
    methods: {
        async fetchData() {
            try {
                const response = await fetch('http://localhost:8081/foods');
                if (response.ok) {
                    const data = await response.json();
                    this.foods = data;
                    console.log('Server Response:', data);
                } else {
                    console.error('Error:', response.statusText);
                }
            } catch (error) {
                console.error('Error:', error);
            }
        },

        addToCart(food) {
            this.$store.commit('addToCart', food)
        },


    },
    mounted() {
        this.fetchData();
    }
}




</script>

<style>
@import './CSS.css';
</style>
