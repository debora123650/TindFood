<template>
    <div>
        <div class="header-section">
            <h1>Contact with us:</h1>
        </div>
        <div class="main-content">
            <img :src="require('@/image/IMG_2924a.jpg')" alt="Contact Image" />
            <div class="text-content">
                <p>You can reach us via email, phone, or visit our office.</p>
                <p>Name: Debora Mincheva</p>
                <p>E-mail: Debora.Mincheva@Student.HTW-Berlin.de</p>
            </div>
        </div>
    </div>
</template>

<script>
export default {};
</script>

<style scoped>
.main-content {
    overflow: hidden;
}

.main-content img {
    float: right;
    max-width: 30%;
    margin-right: 20px;
    margin-bottom: 10px;
}

.text-content {
    overflow: hidden;
}

.text-content p {
    text-align: left;
    font-size: 22px;
}
</style>
