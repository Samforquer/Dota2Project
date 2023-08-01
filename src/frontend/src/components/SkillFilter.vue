<template>
  <h1>Make your selections here: </h1>
  <p>Choose your skill bracket: </p>
  <form>
    <input type="radio" id="html" name="skill_bracket" value="herald">
    <label for="herald"> Herald</label><br>
    <input type="radio" id="guardian" name="skill_bracket" value="JavaScript">
    <label for="guardian"> Guardian</label><br>
    <input type="radio" id="crusader" name="skill_bracket" value="CSS">
    <label for="crusader"> Crusader</label><br>
    <input type="radio" id="archon" name="skill_bracket" value="JavaScript">
    <label for="archon"> Archon</label><br>
    <input type="radio" id="legend" name="skill_bracket" value="JavaScript">
    <label for="legend"> Legend</label><br>
    <input type="radio" id="ancient" name="skill_bracket" value="JavaScript">
    <label for="ancient"> Ancient</label><br>
    <input type="radio" id="divine" name="skill_bracket" value="JavaScript">
    <label for="divine"> Divine</label><br>
    <input type="radio" id="immortal" name="skill_bracket" value="JavaScript">
    <label for="immortal"> Immortal</label><br>
  </form>
</template>

<script>
export default{
  name: "SkillFilter"
}

</script>

<style scoped>

</style>