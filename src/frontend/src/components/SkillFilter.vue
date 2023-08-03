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
  <button class="glow-on-hover" :class="{ 'glow-on-click': isClicked }" @click="onButtonClick">
    Submit
  </button>
</template>

  <script>
    export default {
      name: "SkillFilter",
      data() {
        return {
          isClicked: false
        };
      },
      methods: {
        onButtonClick() {
          // Your logic or action when the button is clicked goes here
          // For example, you can show a message or perform some other action
          // And toggle the isClicked state to trigger the CSS animation
          this.isClicked = true;
          setTimeout(() => {
            this.isClicked = false; // Reset the isClicked state after the animation duration
          }, 1000); // Replace 500 with your animation duration in milliseconds
        }
      }
    }
  </script>

<style scoped>
button{
  margin: 10px;
  background-color: #f15c41;
  box-shadow: 0 5px 0 #4d0f00;
}
.glow-on-hover:active{
  box-shadow: none;
  transform: translateY(5px);
}
.glow-on-hover {
  display: inline-block;
  outline: 0;
  border: 0;
  font-size: 20px;
  font-weight: 500;
  color: #fff;
  cursor: pointer;
  background-image: linear-gradient(to right, #4d0f00, #f15c41) !important;
  border-radius: 3px;
  padding: 16px 18px 15px;
  white-space: nowrap;
}

.glow-on-hover:hover {
  background-color: #691000;
  background-image: none !important;
}


</style>