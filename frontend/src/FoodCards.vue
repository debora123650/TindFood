<template>
    <div>
        <div v-for="food in foods" :key="food.id" class="food-card">
            <img :src="food.image" alt="Food Image" />
            <button @click="likeFood(food)">Like</button>
            <button @click="dislikeFood(food)">Dislike</button>
            <button @click="addToCart(food)">Add to List</button>
        </div>
    </div>
</template>

<script>
export default {
    props: ['foods'],
    methods: {
        // eslint-disable-next-line no-unused-vars
        likeFood(food) {
            this.$emit('choose', { action: 'like', food });
        },
        dislikeFood(food) {
            this.$emit('choose', { action: 'dislike', food });
        },
        addToCart(food) {
            this.$emit('choose', { action: 'addToCart', food });
        },
    },
};
</script>

<style scoped>
.food-card {
    margin: 10px;
    padding: 10px;
    border: 1px solid #ccc;
    text-align: center;
}
</style>
