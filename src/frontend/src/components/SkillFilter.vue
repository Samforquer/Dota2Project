<template>
  <div class="form-container">
    <div class="form-box">
      <h3>Choose your skill bracket (choose one): </h3>
      <form class="bracket">
        <span id="herald">
          <img class="icon-img" src="../assets/herald.png" alt="herald-img">
        <input type="radio" id="herald" name="bracket" v-model="selectedBracket" value="1">
        <label for="herald">Herald</label><br>
        </span>
        <span id="guardian">
          <img class="icon-img" src="../assets/guardian.png" alt="guardian-img">
        <input type="radio" id="guardian" name="bracket" v-model="selectedBracket" value="2">
        <label for="guardian"> Guardian</label><br>
        </span>
        <span id="crusader">
          <img class="icon-img" src="../assets/crusader.png" alt="crusader-img">
        <input type="radio" id="crusader" name="bracket" v-model="selectedBracket" value="3">
        <label for="crusader"> Crusader</label><br>
           </span>
        <span id="archon">
          <img class="icon-img" src="../assets/archon.png" alt="archon-img">
        <input type="radio" id="archon" name="bracket" v-model="selectedBracket" value="4">
        <label for="archon"> Archon</label><br>
          </span>
        <span id="legend">
          <img class="icon-img" src="../assets/legend.png" alt="legend-img">
        <input type="radio" id="legend" name="bracket" v-model="selectedBracket" value="5">
        <label for="legend"> Legend</label><br>
          </span>
        <span id="ancient">
          <img class="icon-img" src="../assets/ancient.png" alt="ancient-img">
        <input type="radio" id="ancient" name="bracket" v-model="selectedBracket" value="6">
        <label for="ancient"> Ancient</label><br>
          </span>
        <span id="divine">
          <img class="icon-img" src="../assets/divine.png" alt="divine-img">
        <input type="radio" id="divine" name="bracket" v-model="selectedBracket" value="7">
        <label for="divine"> Divine</label><br>
          </span>
        <span id="immortal">
          <img class="icon-img" src="../assets/immortal.png" alt="immortal-img">
        <input type="radio" id="immortal" name="bracket" v-model="selectedBracket" value="8">
        <label for="immortal"> Immortal</label><br>
          </span>
      </form>
    </div>
    <!-- > Todo : Separate different filter boxes into different components?<-->
    <div class="form-box">
      <h3>Choose your desired hero complexity (choose up to 3): <br>
        </h3>
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
      <h3>Choose your desired Role(s) (choose up to 5):</h3>
      <form class="role">
        <div>
          <input type="checkbox" id="carry" v-model="heroPosition" value="1">
          <label for="carry">1. Carry</label>
        </div>
        <div>
          <input type="checkbox" id="mid-lane" v-model="heroPosition" value="2">
          <label for="mid-lane">2. Mid Lane</label>
        </div>
        <div>
          <input type="checkbox" id="offlane" v-model="heroPosition" value="3">
          <label for="offlane">3. Offlane</label>
        </div>
        <div>
          <input type="checkbox" id="soft-support" v-model="heroPosition" value="4">
          <label for="soft-support">4. Soft Support</label>
        </div>
        <div>
          <input type="checkbox" id="hard-support" v-model="heroPosition" value="5">
          <label for="hard-support">5. Hard Support</label>
        </div>
      </form>
    </div>
  </div>
  <div class="center-button">
    <button class="glow-on-hover" :class="{ 'glow-on-click': isClicked }" @click="filterHeroes">Filter Heroes</button>
  </div>
  <div class="filtered-heroes" v-if="filteredHeroes.length > 0">
    <h2>Filtered Heroes for Bracket {{ selectedBracket }} for your selected role(s) :</h2>
    <div v-for="hero in sortedHeroes" :key="hero.id">
      <div class="results">
      <p>Hero: {{ hero.localized_name }}</p>
      <p>Complexity: {{hero.heroComplexity.join(", ")}}</p>
      <img class="hero-img" :src="`${BASE_API_URL}${hero.img}`" :alt="hero.localized_name" />
      <p>Position(s): {{ hero.heroPosition.join(", ") }}</p>
        <p v-if="selectedBracket === '1'">Herald Win Rate: {{ hero.heraldWinRate.toFixed(2) }}%</p>
      <p v-else-if="selectedBracket === '2'">Guardian Win Rate: {{ hero.guardianWinRate.toFixed(2) }}%</p>
      <p v-else-if="selectedBracket === '3'">Crusader Win Rate: {{ hero.crusaderWinRate.toFixed(2) }}%</p>
      <p v-else-if="selectedBracket === '4'">Archon Win Rate: {{ hero.archonWinRate.toFixed(2) }}%</p>
      <p v-else-if="selectedBracket === '5'">Legend Win Rate: {{ hero.legendWinRate.toFixed(2) }}%</p>
      <p v-else-if="selectedBracket === '6'">Ancient Win Rate: {{ hero.ancientWinRate.toFixed(2) }}%</p>
      <p v-else-if="selectedBracket === '7'">Divine Win Rate: {{ hero.divineWinRate.toFixed(2) }}%</p>
      <p v-else-if="selectedBracket === '8'">Immortal Win Rate: {{ hero.immortalWinRate.toFixed(2) }}%</p>
        <!-- Added .toFixed(2) to display in 50.00% format. -->
      </div>
    </div>
  </div>
  <div v-else>
    <p>No heroes found for Bracket {{ selectedBracket }}.</p>
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
      selectedBracket:'',
      heroPosition: [1],
      heroComplexity: [1],
      filteredHeroes: [],
      img:''
    };
  },
  computed: {
    BASE_API_URL() {
      return "https://api.opendota.com";
    },
    winRateThreshold(){
      const bracketWinRate = `${this.selectedBracket}WinRate`;
      return this.sortedHeroes.filter(hero => {
        return hero[bracketWinRate] >= 50;
      });
    },
    sortedHeroes() {
      // Added for sorting win rates in descending order.
      return this.filteredHeroes.slice().sort((a, b) => {
        return this.getWinRateForBracket(b) - this.getWinRateForBracket(a);
      });
    }
  },
  methods: {
    async filterHeroes() {
      const backendURL = "http://localhost:8082/api";
      const bracket = this.bracket;
      const position = this.heroPosition.join(",");
      const complexity = this.heroComplexity.join(",");

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
        this.isClicked = false;
      }, 1000);
    },
    getWinRateForBracket(hero) {
      // Added for sorting win rates in descending order.
      switch (this.selectedBracket) {
        case '1': return hero.heraldWinRate;
        case '2': return hero.guardianWinRate;
        case '3': return hero.crusaderWinRate;
        case '4': return hero.archonWinRate;
        case '5': return hero.legendWinRate;
        case '6': return hero.ancientWinRate;
        case '7': return hero.divineWinRate;
        case '8': return hero.immortalWinRate;
        default: return 0;
      }
    },
  },
};
</script>


<style scoped>
.icon-img {
  height: auto;
  width: 40px;
}
.hero-img{
  width: 100px;
  height: auto;
}
.results{
  margin: 5px;
  background-color: dimgray;
  border: 1px solid black;
  border-radius: 5px;
  padding-left: 20px;
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
  background-color: #4f4d4b;
}

.bracket div,
.complexity div,
.role div {
  display: flex;
  align-items: center;
  gap: 5px;
  padding: 6px;
}

.form-item label {
  flex-grow: 1;
}

label:hover {
  background-color: rgba(255, 255, 255, 0.2);
}

#herald, #guardian, #crusader, #archon, #legend, #ancient, #divine, #immortal {
  display: flex;
  padding: 6px;
}

.filtered-heroes {
  margin-top: 40px;
  padding: 10px;
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
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 10px;
}

button {
  margin: -20px;
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