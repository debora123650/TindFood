<template>
    <div>
        <div class="header-section">
            <h1>My Shopping List</h1>
        </div>
        <div class="main-content">
            <div v-for="item in cartItems" :key="item.id" class="cart-item">
                {{ item.name }} - {{ item.price }}
            </div>
        </div>
    </div>
</template>

<script>
export default {
    computed: {
        cartItems() {
            return this.$store.state.cartItems;
        },
    },
};
</script>

<style>

body {
    margin: 0;
    padding: 0;
}


.header-section {
    background-color: #19283F;
    color: #A8B9C0;
    padding: 15px 0;
    text-align: center;
    display: flex;
    align-items: center;
    justify-content: center;

}

.header-section h1 {
    margin: 0;
    font-weight: 300;
    font-size: 28px;
}

.main-content {
    background-color: lightblue;
    padding: 20px;
    text-align: center;
    color: #19283F;
    min-height: 100vh;
    box-sizing: border-box;
    font-size: 30px;
}


</style>
