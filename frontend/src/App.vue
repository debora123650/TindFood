<template>
    <div>
        <input type="text" v-model="inputValue" placeholder="Enter something..." />
        <input type="number" v-model.number="selectedNumber" min="1" max="10" />
        <button @click="sendData">Send</button>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
            </tr>
            <tr v-for="item in items" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.name }}</td>
                <td>{{ item.price }}</td>

            </tr>
        </table>
    </div>
</template>



<script>
    export default {
    data() {
    return {
    inputValue: '',
    selectedNumber: 1,
    items: []
};
},
    methods: {
    async sendData() {
    try {
    const response = await fetch('http://localhost:8081/foods', {
    method: 'POST',
    headers: {
    'Content-Type': 'application/json'
},
    body: JSON.stringify({
    name: this.inputValue,
    price: this.selectedNumber
})
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
}
},
    mounted() {
    this.fetchData();
}
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
