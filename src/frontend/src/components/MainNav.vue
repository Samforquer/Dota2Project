<template>
  <nav class="nav-list">
    <div class="nav-link" id="home-link">
      <router-link :to="{name:'home'}">Home</router-link>
    </div>
    <div class="nav-link" id="heroes-link">
      <router-link :to="{name:'heroes'}">Heroes</router-link>
    </div>
  </nav>
</template>
<script setup>
import HomeView from "@/views/HomeView.vue";
</script>