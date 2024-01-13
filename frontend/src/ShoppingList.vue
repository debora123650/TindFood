<template>
    <div>
        <h1>Your ShoppingList</h1>
        <div v-for="item in cartItems" :key = "item.id">
            {{item.name}} - {{item.price}}
        </div>
    </div>
</template>

<script>



export default {
    computed : {
        cartItems(){
            return this.$store.state.cartItems;
        }
    }

    }

</script>

<style scoped>
h1 {
    background-color: #19283F;
    color: #A8B9C0;
    padding-top: 100px; /* Adjust as needed */
    padding-bottom: 100px; /* Adjust as needed */
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0;
}

h2 {
    width: 1170px;
    margin: auto;
}

</style>