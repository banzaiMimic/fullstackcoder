<b>ChangeLog</b><br /><br />
[ no playable release finished yet just building the main blocks for the game ]

- building an EnemyFactory to randomly generate enemies
- EnemyBlock added to match CodeBlocks
- EnemyMold interface added since we want to switch between different enemies easier...
- EnemyType enum created currently FLYING exists ... will add WALKING soon
- added EnemyUtil - currently added random grab for EnemyType for use in BlockGenerator
-----
- added 8bit AudioControl for music!!
- escape key will take user to Menu
- added SharedGameState for all shared functionality between extended BasicGameStates [ each game state will now re-initialize upon entering state so that level and tests will fully restart ]
- added basic functionality for type checking and CodeBlock completion
- makes more sense to have one basic flying enemy class and use our SpriteSheets singleton to grab the spritesheet
-----
- added VSync and MaximumLogicUpdateInterval to appgc for smoother flying text [ had trouble reading it choppy ]
- created CodeBlock and CodeLine for code to fly from right to left of screen
- same concept as entity but these will be able to type to destroy
- @Todo add type functionality
- @Todo refactor current code base before spaghetti attacks
- @Todo add some binding from CodeBlock / CodeLine to flying entities so that each entity represents a line of code
- @Todo when line of code is completed successfully, entity gets killed somehow
-----
- added royalty free <a href='http://opengameart.org/content/flappy-dragon-sprite-sheets'>animated 8 bit dragon</a>
- added development test for above entity SpriteSheet animation and movement from right to left
- dragon will fly until X_BOUNDS location reaches 200 
	- this is for future addition of a 'base' of 200 width with a health bar that the entity will attack
-----
- created initial project 
- setup basic functionality for displaying text and jumping into game states