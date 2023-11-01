# Dota2 Hero Picker App
![ExampleImg](https://github.com/Samforquer/Dota2Project/assets/119086351/278b73ec-b5a8-4529-ba8e-82f0df2a429d)
![ExampleImg4](https://github.com/Samforquer/Dota2Project/assets/119086351/6aee3096-59cd-46de-8af8-7056699f0041)

The Dota2 Hero Picker App is a web-based tool designed to assist Dota 2 players in making optimal hero selections for their matches. By taking into account factors such as skill bracket, hero complexity, and preferred roles, the app provides personalized hero recommendations.

## Getting Started

To run the Dota 2 Hero Picker App locally, follow these steps:

1. **Clone the Repository**: Start by cloning the project repository to your local machine using the following command: git clone https://github.com/Samforquer/Dota2Project.git
2. **Backend Setup:**
- Open the project in your preferred IDE (e.g., IntelliJ IDEA).
- Run the Spring Boot application from your IDE to start the backend server.
3. **Frontend Setup**:
   - Open a terminal or command prompt.
   - Navigate to the `src/frontend` directory within the project:

     ```bash
     cd path/to/your/Dota2Project/src/frontend
     ```

   - Install the required Node.js dependencies:

     ```bash
     npm install
     ```

   - Start the Vue.js development server:

     ```bash
     npm run dev
     ```

   The development server will likely be running at `http://localhost:5173`. Follow this link or copy/paste into       your browser of choice and you should be able to demo the app from there!

## Features

- **Skill Bracket Selection:** Choose your skill bracket from Herald to Immortal using the radio buttons. This sets the context for hero recommendations.
- **Hero Complexity Filtering:** Select up to three hero complexities (Easy, Moderate, Complex) to refine your recommendations based on your comfort level.
- **Role Preference:** Indicate your preferred roles (Carry, Mid-Lane, Offlane, Soft Support, Hard Support) with checkboxes to ensure a balanced team composition.
- **Hero Filtering:** Upon clicking the "Filter Heroes" button, the app presents a list of heroes that match your selected criteria.
- **Hero Details:** For each filtered hero, the app displays its name, complexity, image, positions, and corresponding win rate in the selected skill bracket.

## How It Works

1. Choose your skill bracket, hero complexity, and preferred roles using the provided interface.
2. Click the "Filter Heroes" button to retrieve hero recommendations based on your selections.
3. The app queries the backend API to fetch the list of heroes that meet your criteria.
4. Filtered heroes are displayed, showing their details, complexity, positions, and win rate.
5. Use the provided information to make an informed decision about hero selection for your Dota 2 match.

## Technologies Used

- **Frontend:** The app's frontend is built using Vue.js. It interacts with the user and presents hero recommendations.
- **Backend:** The backend service utilizes Spring Boot, handling hero data, filtering, and API requests.
- **API:** OpenDota API is used to fetch detailed hero data, including win rates and other statistics.
- **Styling:** The app is styled using CSS to provide a visually appealing and user-friendly interface.
