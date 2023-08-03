<script setup>
import {RouterLink, RouterView} from 'vue-router'

import TheHeader from "@/components/TheHeader.vue";
</script>

<template>
  <the-header/>
  <div class="wrapper">
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/about">About</RouterLink>
    </nav>
    <RouterView/>


  </div>
</template>

<style scoped>

</style>
