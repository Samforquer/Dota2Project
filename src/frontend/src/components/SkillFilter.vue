<template>
  <div class="form-container">
    <div class="form-box">
      <h3>Choose your skill bracket: </h3>
      <form class="bracket">
        <span id="herald">
          <img class="icon-img" src="../assets/herald.png" alt="herald-img">
        <input type="radio" id="html" name="bracket" v-model="bracket" value="1">
        <label for="herald">Herald</label><br>
        </span>
        <span id="guardian">
          <img class="icon-img" src="../assets/guardian.png" alt="guardian-img">
        <input type="radio" id="guardian" name="bracket" v-model="bracket" value="2">
        <label for="guardian"> Guardian</label><br>
        </span>
        <span id="crusader">
          <img class="icon-img" src="../assets/crusader.png" alt="crusader-img">
        <input type="radio" id="crusader" name="bracket" v-model="bracket" value="3">
        <label for="crusader"> Crusader</label><br>
           </span>
        <span id="archon">
          <img class="icon-img" src="../assets/archon.png" alt="archon-img">
        <input type="radio" id="archon" name="bracket" v-model="bracket" value="4">
        <label for="archon"> Archon</label><br>
          </span>
        <span id="legend">
          <img class="icon-img" src="../assets/legend.png" alt="legend-img">
        <input type="radio" id="legend" name="bracket" v-model="bracket" value="5">
        <label for="legend"> Legend</label><br>
          </span>
        <span id="ancient">
          <img class="icon-img" src="../assets/ancient.png" alt="ancient-img">
        <input type="radio" id="ancient" name="bracket" v-model="bracket" value="6">
        <label for="ancient"> Ancient</label><br>
          </span>
        <span id="divine">
          <img class="icon-img" src="../assets/divine.png" alt="divine-img">
        <input type="radio" id="divine" name="bracket" v-model="bracket" value="7">
        <label for="divine"> Divine</label><br>
          </span>
        <span id="immortal">
          <img class="icon-img" src="../assets/immortal.png" alt="immortal-img">
        <input type="radio" id="immortal" name="bracket" v-model="bracket" value="8">
        <label for="immortal"> Immortal</label><br>
          </span>
      </form>
    </div>
    <div class="form-box">
      <h3>Choose your desired hero complexity: <br>
        (Select up to 3 options)</h3>
      <form class="complexity">
        <div>
          <input type="checkbox" id="easy" v-model="heroComplexity" value="1">
          <label for="easy"> Easy</label>
        </div>
        <div>
          <input type="checkbox" id="moderate" v-model="heroComplexity" value="2">
          <label for="moderate"> Moderate</label>
        </div>
        <div>
          <input type="checkbox" id="complex" v-model="heroComplexity" value="3">
          <label for="complex"> Complex</label>
        </div>
      </form>
    </div>
    <div class="form-box">
      <h3>Choose your desired Role:</h3>
      <form class="role">
        <div>
          <input type="checkbox" id="carry" v-model="heroPosition" value="1">
          <label for="carry">Carry</label>
        </div>
        <div>
          <input type="checkbox" id="mid-lane" v-model="heroPosition" value="2">
          <label for="mid-lane">Mid Lane</label>
        </div>
        <div>
          <input type="checkbox" id="offlane" v-model="heroPosition" value="3">
          <label for="offlane">Offlane</label>
        </div>
        <div>
          <input type="checkbox" id="soft-support" v-model="heroPosition" value="4">
          <label for="soft-support">Soft Support</label>
        </div>
        <div>
          <input type="checkbox" id="hard-support" v-model="heroPosition" value="5">
          <label for="hard-support">Hard Support</label>
        </div>
      </form>
    </div>
  </div>
  <div class="center-button">
    <button class="glow-on-hover" :class="{ 'glow-on-click': isClicked }" @click="filterHeroes">Filter Heroes</button>
  </div>
  <div class=filtered-heroes v-if="filteredHeroes.length > 0">
    <h2>Filtered Heroes for Bracket {{ bracket }}:</h2>
    <div v-for="hero in filteredHeroes" :key="hero.id">
      <p>Name: {{ hero.localized_name }}</p>
      <p>Positions: {{ hero.heroPosition.join(", ") }}</p>
      <!-- Display the win rate directly from the filteredHeroes array -->
      <p>Win Rate: {{ hero.winRate }}%</p>
    </div>
  </div>
  <div v-else>
    <p>No heroes found for Bracket {{ bracket }}.</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "SkillFilter",
  data() {
    return {
      isClicked: false,
      bracket: 1,
      heroPosition: [1, 2],
      heroComplexity: [1], // Initialize with default complexity (Easy)
      filteredHeroes: [],
    };
  },
  methods: {
    async filterHeroes() {
      const backendURL = "http://localhost:8082/api";
      const bracket = this.bracket;
      const position = this.heroPosition.join(","); // Serialize the array to a comma-separated string
      const complexity = this.heroComplexity.join(","); // Serialize the array to a comma-separated string

      try {
        const url = `${backendURL}/heroes/filter?bracket=${encodeURIComponent(
            bracket
        )}&position=${encodeURIComponent(
            position
        )}&complexity=${encodeURIComponent(complexity)}`;
        const response = await axios.get(url);
        this.filteredHeroes = response.data;
      } catch (error) {
        console.error("Error while filtering heroes:", error);
      }
    },
    onButtonClick() {
      this.isClicked = true;
      setTimeout(() => {
        this.isClicked = false; // Reset the isClicked state after the animation duration
      }, 1000); // Replace 500 with your animation duration in milliseconds
    },
  },
};
</script>


<style scoped>
.icon-img {
  height: auto;
  width: 40px;
}

label:hover {
  background-color: rgba(255, 255, 255, 0.2);
}

label {
  display: flex;
  align-items: center;
  gap: 10px;
  cursor: pointer;
  padding: 5px;
  border: 1px solid black;
  border-radius: 5px;
  flex-grow: 1;
  color: antiquewhite;
}

.bracket div,
.complexity div,
.role div {
  display: flex;
  align-items: center;
  gap: 5px;
  padding: 10px;
}

.form-item label {
  flex-grow: 1;
}

label:hover {
  background-color: rgba(255, 255, 255, 0.2);
}

#herald, #guardian, #crusader, #archon, #legend, #ancient, #divine, #immortal {
  display: flex;
  padding: 10px;
}

.filtered-heroes {
  margin-top: 20px;
  padding: 20px;
  border: 1px solid black;
  border-radius: 5px;
  background-color: rgba(40, 41, 37, 0.93);
}

.filtered-heroes h2 {
  margin-top: 0;
  background-color: #4d1300;
  padding: 8px;
  color: #fff;
  font-size: 18px;
  border-radius: 5px;
}

input {
  accent-color: #4d0f00;
}

.form-container {
  display: flex; /* Use flexbox to arrange the forms side by side */
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 10px;
}

button {
  margin: -30px;
  background-color: #f15c41;
  box-shadow: 0 5px 0 #4d0f00;
}

.form-box {
  flex: 1;
  border: 1px solid black;
  border-radius: 5px;
  background-color: rgba(40, 41, 37, 0.93);
}

.form-box h3 {
  margin-top: 0;
  background-color: #4d1300;
  padding: 8px;
  color: #fff;
  font-size: 18px;
  border-radius: 5px
}

.glow-on-hover:active {
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

.center-button {
  display: flex;
  justify-content: center;
  margin-top: 50px;
}
</style>