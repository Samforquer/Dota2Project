<script setup>
import {RouterLink, RouterView} from 'vue-router'
import SkillFilter from "@/components/SkillFilter.vue";
import TheHeader from "@/components/TheHeader.vue";
import MainNav from "@/components/MainNav.vue";
</script>

<template>
  <main>
  <the-header/>
  <div class="wrapper">
    <!-- <main-nav/> Add navbar when feature pages are added eg. All Heroes, etc. -->
      <skill-filter/>
    <RouterView/>
  </div>
  </main>
</template>

<style scoped>

</style>