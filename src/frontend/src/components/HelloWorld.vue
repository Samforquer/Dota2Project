<script setup>
defineProps({
  msg: {
    type: String,
    required: true
  }
})
</script>

<template>
  <div class="greetings">
    <h1 class="green">{{ msg }}</h1>
    <h3>
      Welcome to the free Dota 2 Hero Picker App!
    </h3>
  </div>
</template>

<style scoped>

</style>
