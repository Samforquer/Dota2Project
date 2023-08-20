<script setup>
import {RouterLink, RouterView} from 'vue-router'
import SkillFilter from "@/components/SkillFilter.vue";
import TheHeader from "@/components/TheHeader.vue";
</script>

<template>
  <main>
  <the-header/>
  <div class="wrapper">
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/about">About</RouterLink>
    </nav>
      <skill-filter/>
    <RouterView/>
  </div>
  </main>
</template>

<style scoped>

</style>
