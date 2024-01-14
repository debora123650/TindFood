
<template>
    <div>
        <div class="header-section1">
            <h1>Welcome to TindFood!</h1>
            <h2 class="subtitle">Login</h2>
        </div>

        <div class="login-container">
            <form class="login-form" @submit.prevent="login">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" id="username" v-model="username" required>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" v-model="password" required>
                </div>

                <button type="submit">Login</button>
            </form>
        </div>
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

<style>

.header-section1 {
    background-color: #19283F;
    color: #A8B9C0;
    padding: 15px 0;
    text-align: center;
    display: flex;
    flex-direction: column;
    align-items: center;

}

.header-section1 h2.subtitle {
    color: #FF3150;
    font-size: 30px;
    margin-top: 10px;
}


.login-container {
    background-color: lightblue;
    padding: 20px;
    text-align: center;
    color: #19283F;
    min-height: 100vh;
    box-sizing: border-box;
    font-size: 30px;
}

.login-form {
    display: flex;
    flex-direction: column;
    align-items: center;
}
.form-group {
    margin-bottom: 30px;
    margin-top: 10px;
}


.label-text {
    font-size: 30px;
}

form input {
    width: 300px;
    padding: 5px;
    font-size: 30px;
}

button {
    font-size: 30px;
    color: #FFC501;
    background-color: #FF3150;
    border: none;
    padding: 13px 40px;
    border-radius: 15px;
    outline: none;
}

.login-form button:hover {
    background-color: white;
    color: #19283F;
    cursor: pointer;
}

.header-section1 h1,
.header-section1 h2.subtitle {
    font-weight: normal;
}

.login-form label,
.login-form input,
.login-form button {
    font-weight: normal;
}



</style>