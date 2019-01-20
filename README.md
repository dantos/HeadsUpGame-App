# Heads Up game Android's app

Android implementation of the classic Heads Up game.

**How it works**

1. When opening the application, a loading screen will be displayed.
2. The main activity (Screen) loads the available categories of the game (Topics like politics, riddles, sports, actions).
3. When a category is selected, the preparation time of 5 seconds (for the user to put the device in the front), and then a word that the user must guess and start using the timer of 1 minute.
4. The player can guess as many questions as possible (when the user guesses a question turns the mobile device forward and if you want to pass the question rotates the device back, as long as the timer does not reach the time limit).
5. When the time runs out, ignore the current riddle, show a message that runs out and show the statistics of all the riddles that the user guessed and those that were unsuccessful.
6. In the end the user can decide if to return to play that same category or change category.

The topics structure is the same as showed in this [API](https://heads-up-api.herokuapp.com/)

**Technical Implementation**

- Accelerometer sensor
- Koral android-gif-drawable
- Android Asynchronous Http Client

