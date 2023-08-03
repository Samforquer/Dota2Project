<template>
  <header>
    <div class="header-content">
      <div id="img">
        <img class="header-img" src="https://pbs.twimg.com/profile_images/1478893871199186945/1mA6tezL_400x400.jpg" alt="header-img"/>
      </div>
      <h1>Dota Minus</h1>
    </div>
  </header>
</template>

<script>
export default {
  name: "TheHeader"
}
</script>

<style scoped>
header {
  border: 2px solid black;
  border-radius: 3px;
  display: flex;
}
.header-content {
  display: flex; /* Nested flexbox to arrange image and h1 horizontally */
  align-items: center; /* Vertically center align the image and h1 */
  margin: 10px;

}
.header-img {
  border-radius: 5px;
  height: 100px;
  margin: 10px;
}
h1 {
  font-weight: 700;
  color: #4d1300;
  margin: 10px;
}
</style>
