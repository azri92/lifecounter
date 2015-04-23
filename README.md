# LifeCounter

INFO 498 Android Development | Homework 5

My family enjoys playing Magic:The Gathering over dinner while we are out to eat in restaurants. We need an app to help track each player's "life total" during the game. It needs to run on Froyo.

(Package it as "edu.washington.<yourNetID>.lifecounter")

## Stories:

* As a user, when I launch the application, it should show me four “players”. Each “player” should have a label for their life total, and four pushbuttons (“+”, “-“,”+5”,”-5”).
* As a user, when I push the “+” pushbutton for player 1, it should increment player 1’s life total by 1. “-“ should reduce the life total by 1, “+5” should increment by 5, and “-5” should decrement by 5.
* As a user, when a player's life total drops to 0 or less, it should display a label at the bottom of the app saying "Player X LOSES!"
* As a user, when I rotate the device (landscape to portrait mode or vice versa), it should resize itself evenly.
* As a user, when I run the app on different devices, it should seem "equally balanced" on each device, regardless of orientation. Players' life total labels should be proportional, buttons proportional, and so on.
 
## Grading:

* All your code should be in a GitHub repo under your account

    * repo should be called 'lifecounter'
    * repo should contain all necessary build artifacts
* include a directory called "screenshots", including:
    * screenshot of app running on emulator
    * pic or screenshot or movie of app running on a device

* We will clone and build it from the GH repo

* 5 points, one for each satisfied story

* BONUS: 1 pt each, for each of the following:

    * As a user, when the application starts, it should allow for a flexible number of players, from 2 to 8. It should have an "add player" button near the top, and when pressed, it adds a new player to the game (with a starting life total of 20).
    * As a developer, when I look at the code, it should only have one event-listener block of code for all of the life-modifying buttons in the app. (This will require you to use the View passed in to the listener to determine which button did the click.)
