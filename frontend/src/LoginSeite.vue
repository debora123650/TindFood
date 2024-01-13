import { useRouter } from 'vue-router';
const router = useRouter();

<template>

    <div class="login-container">
        <form class="login-form" @submit.prevent="login">
            <h2>Login</h2>
            <label for="username">Username:</label>
            <input type="text" id="username" v-model="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" v-model="password" required>

            <button type="submit">Login</button>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            username: '',
            password: '',
        };
    },
    methods: {
        async login() {
            try {
                const response = await fetch('http://localhost:8081/login', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        username: this.username,
                        password: this.password,
                    }),
                });

                if (response.ok) {
                    console.log('Login successful');
                } else {
                    console.error('Login failed:', response.statusText);
                }
            } catch (error) {
                console.error('Error during login:', error);
            }
        },
    },
};
</script>

