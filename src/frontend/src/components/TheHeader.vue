<template>
  <header>
    <div class="header-content">
      <div id="img">
        <img class="header-img" src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/444903e3-91cb-4e2c-a001-aef2e9d99790/daj7nti-d6776829-738d-49ab-bf2d-ec3aa51d45c8.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzQ0NDkwM2UzLTkxY2ItNGUyYy1hMDAxLWFlZjJlOWQ5OTc5MFwvZGFqN250aS1kNjc3NjgyOS03MzhkLTQ5YWItYmYyZC1lYzNhYTUxZDQ1YzgucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.05SBxWgsDERmmCdLOAetZQ_HV70DqMbc6uQ_13vicrI" alt="header-img"/>
      </div>
      <h1>Dota 2 Hero Picker</h1>
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
