<b>ChangeLog</b>

[ no playable release finished yet just building the main blocks for the game ]

<p>
- building an EnemyFactory to randomly generate enemies<br />
- EnemyBlock added to match CodeBlocks<br />
- EnemyMold interface added since we want to switch between different enemies easier...<br />
- EnemyType enum created currently FLYING exists ... will add WALKING soon<br />
- added EnemyUtil - currently added random grab for EnemyType for use in BlockGenerator<br />
-----<br />
- added 8bit AudioControl for music!!<br />
- escape key will take user to Menu<br />
- added SharedGameState for all shared functionality between extended BasicGameStates [ each game state will now re-initialize upon entering state so that level and tests will fully restart ]<br />
- added basic functionality for type checking and CodeBlock completion<br />
- makes more sense to have one basic flying enemy class and use our SpriteSheets singleton to grab the spritesheet<br />
-----<br />
- added VSync and MaximumLogicUpdateInterval to appgc for smoother flying text [ had trouble reading it choppy ]<br />
- created CodeBlock and CodeLine for code to fly from right to left of screen<br />
- same concept as entity but these will be able to type to destroy<br />
- @Todo add type functionality<br />
- @Todo refactor current code base before spaghetti attacks<br />
- @Todo add some binding from CodeBlock / CodeLine to flying entities so that each entity represents a line of code<br />
- @Todo when line of code is completed successfully, entity gets killed somehow<br />
-----<br />
- added royalty free <a href='http://opengameart.org/content/flappy-dragon-sprite-sheets'>animated 8 bit dragon</a><br />
- added development test for above entity SpriteSheet animation and movement from right to left<br />
- dragon will fly until X_BOUNDS location reaches 200 : this is for future addition of a 'base' of 200 width with a health bar that the entity will attack<br />
-----<br />
- created initial project <br />
- setup basic functionality for displaying text and jumping into game states<br />
</p>