<template>
  <h1>Make your selections here: </h1>
  <h3>Choose your skill bracket: </h3>
  <form id="bracket">
    <input type="radio" id="html">
    <label for="herald"> Herald</label><br>
    <input type="radio" id="guardian">
    <label for="guardian"> Guardian</label><br>
    <input type="radio" id="crusader">
    <label for="crusader"> Crusader</label><br>
    <input type="radio" id="archon">
    <label for="archon"> Archon</label><br>
    <input type="radio" id="legend">
    <label for="legend"> Legend</label><br>
    <input type="radio" id="ancient">
    <label for="ancient"> Ancient</label><br>
    <input type="radio" id="divine">
    <label for="divine"> Divine</label><br>
    <input type="radio" id="immortal">
    <label for="immortal"> Immortal</label><br>
  </form>
  <br>
  <h3>Choose your desired Hero complexity (Select up to 3 options):</h3>
  <form id="complexity">
    <input type="checkbox" id="easy">
    <label for="easy"> Easy</label><br>
    <input type="checkbox" id="moderate">
    <label for="moderate"> Moderate</label><br>
    <input type="checkbox" id="complex">
    <label for="complex"> Complex</label><br>
  </form>
  <br>
  <h3>Choose your desired Role:</h3>
  <form id="role">
    <input type="radio" id="carry">
    <label for="carry">Carry</label><br>
    <input type="radio" id="mid-lane">
    <label for="mid-lane">Mid Lane</label><br>
    <input type="radio" id="offlane">
    <label for="offlane">Offlane</label><br>
    <input type="radio" id="soft-support">
    <label for="soft-support">Soft Support</label><br>
    <input type="radio" id="hard-support">
    <label for="hard-support">Hard Support</label><br>
  </form><br>


</template>

<script>
export default {
  name: "SkillFilter"
}

</script>

<style scoped>

</style>