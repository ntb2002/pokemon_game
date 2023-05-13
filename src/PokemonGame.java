// PSEUDOCODE

// 1. introduction text that teaches player rules
// 2. include place to take players name and how many pokemon they want to capture
// 3. have the option to input l, r, or s to go left right or straight and q to break loop and quit
// 4. each move use random number to pick either  random encounter or pokemon encounter
// 5. if pokemon encounter use random number to pick pokemon
// 6. display ascii art and message and add 1 to amount of pokemon caught
// 7. if random encounter use random number to pick encounter
// 8. some encounters peaceful/just descriptions of environment
// 9. other encounters give player choice to interact or not and use random numbers to select consequences
// 10. also some encounters that only positively impact or only negatively impact character
// 11. have if statement that is checking if the number of pokemon caught is equal to the number the player wants to catch
// 12. when it is equal break the main loop and go the the end game message
// 13. also have if statement checking if HP is at or below zero
// 14. when the HP is at or below zero break loop and go to end game message
// 15. have if statement is the end game message to display different ending depending on why the game ended

// PLEASE READ THE COMMENTS AT THE BOTTOM TOO, I HAVE REFLECTION/ANALYSIS AS WELL AS LIST OF EXTRA FEATURES


import java.util.*;
public class PokemonGame {

	public static final Scanner scanner = new Scanner(System.in);
	public static final Scanner number = new Scanner(System.in);     // set up a second scanner for int because i think it was being confused using the same one for everything
	public static void main(String[] args) {						 // when i did this it fixed the problems i was having  
		
		
		int hitPoints;
		int pokemonFound = 0;
		

		System.out.println("Welcome to the world of Pokemon, Trainer.");  // first section welcomes player and sets up rules
		System.out.println("You will soon embark on a dangerous jounrey.");
		System.out.println("But first let's get you prepared");
		System.out.println("What would you like to be called, Trainer?");
		String playerName = scanner.nextLine();
		System.out.println("Alright, " + playerName);
		System.out.println("How many Pokemon do you want to catch?");
		
		int pokemonToFind = number.nextInt();
		int originalHitPoints = (pokemonToFind * 75);  		// scales hitpoints based off amount of pokemon player wants to catch
		hitPoints = (pokemonToFind * 75);              		// stores the original hp so it can be used later to calculate damage and healing
		
		System.out.println("Alright, once you catch " + pokemonToFind + " Pokemon your jounrey will end.");
		System.out.println("You also can quit at any time by typing q");
		System.out.println("Your jounrey also will end if you run out of HP");
		System.out.println("You are ready to go now " + playerName + " stay strong and remember your training");
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("You leave the Pokecenter and head to the edge of the town");
		System.out.println("It is finally time to begin your jounrey");
		System.out.println("Press l to go left, r to go right, or s to go straight");
		System.out.println("Type q if you want to quit");
		String direction = scanner.nextLine();				// player chooses direction to head and game starts
		
		while (!doQuit(direction)) {
			while((!direction.equalsIgnoreCase("l")) && (!direction.equalsIgnoreCase("s")) && (!direction.equalsIgnoreCase("r"))) {
				System.out.println("Not a valid input");
				System.out.println("Please type r, l, or s");	// this section sets rules for putting in directions and allows for upper or lower case
				direction = scanner.nextLine();					// also makes it repeat if wrong input is put in
			}
			if (direction.equalsIgnoreCase("s")) {
				System.out.println("You journey straight");
			}
			else if (direction.equalsIgnoreCase("l")) {
				System.out.println("You journey left");
			}
			else if (direction.equalsIgnoreCase("r")) {
				System.out.println("You journey right");
			}
			
					
			int chance = (int)(Math.random() * 10 + 1);			// calculates chance of your encounter type
																// 4/10 chance of pokemon encounter and 6/10 chance of random encounter
			if (chance <= 4) {
				pokemonEncounter();
				pokemonFound += 1;								// counts how many pokemon you've caught
				if (pokemonFound == pokemonToFind){				// makes it so if you find all the pokemon you want it breaks
					break;
				}
			}
			else {
				 hitPoints = randomEncounter(hitPoints, originalHitPoints);
				 if (hitPoints <= 0) {											// if you run out of HP it breaks
					 break;
				 }
			}
		
			System.out.println("");
			System.out.println("Current HP: " + hitPoints);		//tells you how many pokemon you have left to find and what your current HP is between turns
			System.out.println("Pokemon to catch: " + (pokemonToFind - pokemonFound));
			System.out.println();
			System.out.println("Where to next " + playerName + "?");
			direction = scanner.nextLine();
										
		}
		
		if (pokemonFound == pokemonToFind) {		// uses if statements to give different quit messages depending on how you ended the game
			System.out.println("");
			System.out.println("Congratulations! You found all the Pokemon");
			System.out.println("You are a true Pokemon Master");
		}
		else if (hitPoints <= 0) {
			System.out.println("");
			System.out.println("It appears that the journey was too perilous for you " + playerName);
			System.out.println("You ran out of HP");
			System.out.println("Rest up and try again soon");
			
		}
		else {
		System.out.println("");
		System.out.println("Thanks for playing");
		System.out.println("Come try again soon");
		}
	}
	
	
	public static boolean doQuit(String s) {
		
		if (s.equals("q") || s.equals("Q")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void pokemonEncounter() {
		
		System.out.println("A wild Pokemon approaches");	// starts pokemon encounter and uses random number to choose what pokemon you come across
		System.out.println("");								// calls the method that corresponds to that pokemon
		System.out.println("");
		
		int pokemonNumber = (int)(Math.random() * 7 + 1);
		
		
		if (pokemonNumber == 1) {
			pikachu();
		}
		else if (pokemonNumber == 2) {
			squirtle();
		}
		else if (pokemonNumber == 3) {
			charmander();
		}
		else if (pokemonNumber == 4) {
			bulbasaur();
		}
		else if (pokemonNumber == 5) {
			pidgey();
		}
		else if (pokemonNumber == 6) {
			weedle();
		}
		else {
			diglett();
		}
		
		System.out.println("You throw your Pokeball and catch the Pokemon");
	}
		
	
	public static void pikachu() {
		System.out.print("                                             ,-.\n");
	    System.out.print("                                          _.|  '\n");
	    System.out.print("                                        .'  | /\n");
	    System.out.print("                                      ,'    |'\n");
	    System.out.print("                                     /      /\n");
	    System.out.print("                       _..----\"\"---.'      /\n");
	    System.out.print(" _.....---------...,-\"\"                  ,'\n");
	    System.out.print(" `-._  \\                                /\n");
	    System.out.print("     `-.+_            __           ,--. .\n");
	    System.out.print("          `-.._     .:  ).        (`--\"| \\\n");
	    System.out.print("               7    | `\" |         `...'  \\\n");
	    System.out.print("               |     `--'     '+\"        ,\". ,\"\"-\n");
	    System.out.print("               |   _...        .____     | |/    '\n");
	    System.out.print("          _.   |  .    `.  '--\"   /      `./     j\n");
	    System.out.print("         \\' `-.|  '     |   `.   /        /     /\n");
	    System.out.print("         '     `-. `---\"      `-\"        /     /\n");
	    System.out.print("          \\       `.                  _,'     /\n");
	    System.out.print("           \\        `                        .\n");
	    System.out.print("            \\                                j\n");
	    System.out.print("             \\                              /\n");
	    System.out.print("              `.                           .\n");
	    System.out.print("                +                          \\\n");
	    System.out.print("                |                           L\n");
	    System.out.print("                |                           |\n");
	    System.out.print("                |  _ /,                     |\n");
	    System.out.print("                | | L)'..                   |\n");
	    System.out.print("                | .    | `                  |\n");
	    System.out.print("                '  \\'   L                   '\n");
	    System.out.print("                 \\  \\   |                  j\n");
	    System.out.print("                  `. `__'                 /\n");
	    System.out.print("                _,.--.---........__      /\n");
	    System.out.print("               ---.,'---`         |   -j\"\n");
	    System.out.print("                .-'  '....__      L    |\n");
	    System.out.print("              \"\"--..    _,-'       \\ l||\n");
	    System.out.print("                  ,-'  .....------. `||'\n");
	    System.out.print("               _,'                /\n");
	    System.out.print("             ,'                  /\n");
	    System.out.print("            '---------+-        /\n");
	    System.out.print("                     /         /\n");
	    System.out.print("                   .'         /\n");
	    System.out.print("                 .'          /\n");
	    System.out.print("               ,'           /\n");
	    System.out.print("             _'....----\"\"\"\"\" \n");
		System.out.println();
		System.out.println();
		System.out.println("It's a Pikachu!");
	}
	
	public static void squirtle() {
		System.out.print("               _,........__\n");
	    System.out.print("            ,-'            \"`-.\n");
	    System.out.print("          ,'                   `-.\n");
	    System.out.print("        ,'                        \\\n");
	    System.out.print("      ,'                           .\n");
	    System.out.print("      .'\\               ,\"\".       `\n");
	    System.out.print("     ._.'|             / |  `       \\\n");
	    System.out.print("     |   |            `-.'  ||       `.\n");
	    System.out.print("     |   |            '-._,'||       | \\\n");
	    System.out.print("     .`.,'             `..,'.'       , |`-.\n");
	    System.out.print("     l                       .'`.  _/  |   `.\n");
	    System.out.print("     `-.._'-   ,          _ _'   -\" \\  .     `\n");
	    System.out.print("`.\"\"\"\"\"'-.`-...,---------','         `. `....__.\n");
	    System.out.print(".'        `\"-..___      __,'\\          \\  \\     \\\n");
	    System.out.print("\\_ .          |   `\"\"\"\"'    `.           . \\     \\\n");
	    System.out.print("  `.          |              `.          |  .     L\n");
	    System.out.print("    `.        |`--...________.'.        j   |     |\n");
	    System.out.print("      `._    .'      |          `.     .|   ,     |\n");
	    System.out.print("         `--,\\       .            `7\"\"' |  ,      |\n");
	    System.out.print("            ` `      `            /     |  |      |    _,-'\"\"\"`-.\n");
	    System.out.print("             \\ `.     .          /      |  '      |  ,'          `.\n");
	    System.out.print("              \\  v.__  .        '       .   \\    /| /              \\\n");
	    System.out.print("               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |\n");
	    System.out.print("                `        .        `._ ___,j.  `/ .-       ,---.     |\n");
	    System.out.print("                ,`-.      \\         .\"     `.  |/        j     `    |\n");
	    System.out.print("               /    `.     \\       /         \\ /         |     /    j\n");
	    System.out.print("              |       `-.   7-.._ .          |\"          '         /\n");
	    System.out.print("              |          `./_    `|          |            .     _,'\n");
	    System.out.print("              `.           / `----|          |-............`---'\n");
	    System.out.print("                \\          \\      |          |\n");
	    System.out.print("               ,'           )     `.         |\n");
	    System.out.print("                7____,,..--'      /          |\n");
	    System.out.print("                                  `---.__,--.'\n");

		System.out.println();
		System.out.println();
		System.out.println("It's a Squirtle!");
	}
	
	public static void charmander() {
		System.out.print("              _.--\"\"`-..\n");
	    System.out.print("            ,'          `.\n");
	    System.out.print("          ,'          __  `.\n");
	    System.out.print("         /|          \" __   \\\n");
	    System.out.print("        , |           / |.   .\n");
	    System.out.print("        |,'          !_.'|   |\n");
	    System.out.print("      ,'             '   |   |\n");
	    System.out.print("     /              |`--'|   |\n");
	    System.out.print("    |                `---'   |\n");
	    System.out.print("     .   ,                   |                       ,\".\n");
	    System.out.print("      ._     '           _'  |                    , ' \\ `\n");
	    System.out.print("  `.. `.`-...___,...---\"\"    |       __,.        ,`\"   L,|\n");
	    System.out.print("  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\\n");
	    System.out.print("-:..     `. `-..--_.,.<       `\"      / `.        `-/ |   .\n");
	    System.out.print("  `,         \"\"\"\"'     `.              ,'         |   |  ',,\n");
	    System.out.print("    `.      '            '            /          '    |'. |/\n");
	    System.out.print("      `.   |              \\       _,-'           |       ''\n");
	    System.out.print("        `._'               \\   '\"\\                .      |\n");
	    System.out.print("           |                '     \\                `._  ,'\n");
	    System.out.print("           |                 '     \\                 .'|\n");
	    System.out.print("           |                 .      \\                | |\n");
	    System.out.print("           |                 |       L              ,' |\n");
	    System.out.print("           `                 |       |             /   '\n");
	    System.out.print("            \\                |       |           ,'   /\n");
	    System.out.print("          ,' \\               |  _.._ ,-..___,..-'    ,'\n");
	    System.out.print("         /     .             .      `!             ,j'\n");
	    System.out.print("        /       `.          /        .           .'/\n");
	    System.out.print("       .          `.       /         |        _.'.'\n");
	    System.out.print("        `.          7`'---'          |------\"'_.'\n");
	    System.out.print("       _,.`,_     _'                ,''-----\"'\n");
	    System.out.print("   _,-_    '       `.     .'      ,\\\n");
	    System.out.print("   -\" /`.         _,'     | _  _  _.|\n");
	    System.out.print("    \"\"--'---\"\"\"\"\"'        `' '! |! /\n");
	    System.out.print("                            `\" \" -' \n");
		System.out.println();
		System.out.println();
		System.out.println("It's a Charmander!");
	}
	
	public static void bulbasaur() {
		System.out.print("                                           /\n");
		System.out.print("                        _,.------....___,.' ',.-.\n");
		System.out.print("                     ,-'          _,.--\"        |\n");
		System.out.print("                   ,'         _.-'              .\n");
		System.out.print("                  /   ,     ,'                   `\n");
		System.out.print("                 .   /     /                     ``.\n");
		System.out.print("                 |  |     .                       \\.\\\n");
		System.out.print("       ____      |___._.  |       __               \\ `.\n");
	    System.out.print("     .'    `---\"\"       ``\"-.--\"'`  \\               .  \\\n");
	    System.out.print("    .  ,            __               `              |   .\n");
	    System.out.print("    `,'         ,-\"'  .               \\             |    L\n");
	    System.out.print("   ,'          '    _.'                -._          /    |\n");
	    System.out.print("  ,`-.    ,\".   `--'                      >.      ,'     |\n");
	    System.out.print(" . .'\\'   `-'       __    ,  ,-.         /  `.__.-      ,'\n");
	    System.out.print(" ||:, .           ,'  ;  /  / \\ `        `.    .      .'/\n");
	    System.out.print(" j|:D  \\          `--'  ' ,'_  . .         `.__, \\   , /\n");
	    System.out.print("/ L:_  |                 .  \"' :_;                `.'.'\n");
	    System.out.print(".    \"\"'                  \"\"\"\"\"'                    V\n");
	    System.out.print(" `.                                 .    `.   _,..  `\n");
	    System.out.print("   `,_   .    .                _,-'/    .. `,'   __  `\n");
	    System.out.print("    ) \\`._        ___....----\"'  ,'   .'  \\ |   '  \\  .\n");
	    System.out.print("   /   `. \"`-.--\"'         _,' ,'     `---' |    `./  |\n");
	    System.out.print("  .   _  `\"\"'--.._____..--\"   ,             '         |\n");
	    System.out.print("  | .\" `. `-.                /-.           /          ,\n");
	    System.out.print("  | `._.'    `,_            ;  /         ,'          .\n");
	    System.out.print(" .'          /| `-.        . ,'         ,           ,\n");
	    System.out.print(" '-.__ __ _,','    '`-..___;-...__   ,.'\\ ____.___.'\n");
	    System.out.print(" `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--' \n");
		System.out.println();
		System.out.println();
	    System.out.println("It's a Bulbasaur!");
		
	}
	
	public static void pidgey() {
		System.out.print("                   .,\n");
	    System.out.print("            , _.-','\n");
	    System.out.print("          \"\"|\"    `\"\"\"\".,\n");
	    System.out.print("         /'/       __.-'-\"/\n");
	    System.out.print("        ','  _,--\"\"      '-._\n");
	    System.out.print("    _...`...'.\"\"\"\"\"\".\\\"\"-----'\n");
	    System.out.print(" ,-'          `-.) /  `.  \\\n");
	    System.out.print("+---.\"-.    |     `.    .  \\\n");
	    System.out.print("     \\  `.  |       \\   |   L\n");
	    System.out.print("      `v  ,-j        , .'   |\n");
	    System.out.print("     .'\\,' /        /,'      -._\n");
	    System.out.print("    ,____.'        .            `-.\n");
	    System.out.print("        |         /                `-.\n");
	    System.out.print("       /          `.                  `-.\n");
	    System.out.print("      /             `. |                 `.                  _.\n");
	    System.out.print("     .                `|                 ,-.             _.-\" .\n");
	    System.out.print("    j                  |                 |  \\         _.'    /\n");
	    System.out.print("    .                  |               .'    \\     ,-'      /\n");
	    System.out.print("    |                  |            ,-.\\      \\  ,'      _.-\n");
	    System.out.print("    |                . '  `.       |   `      `v'  _,.-\"/\n");
	    System.out.print("    ||    \\          |  ` |(`'-`.,.j         \\ `.-'----+---.\n");
	    System.out.print("    |'|   |L    \\  | |   `|   \\'              L \\___      /\n");
	    System.out.print("    ' L   |`     L | |     `.                 | j   `\"\"\"-'\n");
	    System.out.print("       `-'||\\    | ||j       `.       ._    ` '.\n");
	    System.out.print("          `\\ '\"`^\"- '          `.       \\    |/|\n");
	    System.out.print("            `._                  `-.     \\   Y |\n");
	    System.out.print("    __,..-\"\"`..`._                  `-._  `\\ `.|\n");
	    System.out.print("   +.....>+----.' \"\"----.........,--\"\"\" `--.'.'\n");
	    System.out.print("       ,' _\\  ,..--.-\"' __>---'  |\n");
	    System.out.print("      --\"\"  \"'  _.\" }<\"\"          `---\"\"`._\n");
	    System.out.print("               /...\"  L__.+--   _,......'..'\n");
	    System.out.print("                 /.-\"\"'/   \\ ,-'\n");
	    System.out.print("                     .' ,-\"\"'\n");
	    System.out.print("                    /.-' \n");
		System.out.println();
		System.out.println();
		System.out.println("It's a Pidgey!");
	}
	
	public static void weedle() {
		System.out.print("               ,`.\n");
	    System.out.print("               L  \\\n");
	    System.out.print("              ,    \\\n");
	    System.out.print("             j      \\\n");
	    System.out.print("             ,       \\\n");
	    System.out.print("            j         `\n");
	    System.out.print("            ,          .__\n");
	    System.out.print("         ,-'Y          `  `-.\n");
	    System.out.print("      .-'    `..___..-'      `-.\n");
	    System.out.print("     /__           ,-.          \\\n");
	    System.out.print("    /(__)         `   '          `.\n");
	    System.out.print("   |               `\"'             L\n");
	    System.out.print("   `.------._                      |\n");
	    System.out.print(" ,'          `                     |\n");
	    System.out.print("F             |                    |\n");
	    System.out.print("|             |                    |\n");
	    System.out.print("`._         ,'                     j\n");
	    System.out.print("   `+------'                      /\n");
	    System.out.print("     \\                           /                         |`._\n");
	    System.out.print("      `.                       ,'                          |   \\\n");
	    System.out.print("        `._                _,-'                            |    \\\n");
	    System.out.print("           `-,.________,.-'   `.                           |     L\n");
	    System.out.print("            /                   '                          |     |\n");
	    System.out.print("           /             _,._   |                          ,`---,'\n");
	    System.out.print("         ,'|            /    .  j                        .'      `.\n");
	    System.out.print("         . L            '    | ,                      ,-'\"'`-..   |\n");
	    System.out.print("          .,\\            `--' / `.               ___./       ,.' ,'\n");
	    System.out.print("             \\              ,'    \\__         ,-'     \"-.    | |'\n");
	    System.out.print("              `-._______,.-'  __   | `'-._.,- ._        _`   `\"Y\n");
	    System.out.print("                |           .\"  \\  |     \\      `.    ,'  \\   ,'\n");
	    System.out.print("                |           '    | ;      .       .   `._./.-'\n");
	    System.out.print("                7.           `'\"' / `.--. |   _.. |      j\n");
	    System.out.print("                `.__       `   _-'   |   |j  /   ||     .'\n");
	    System.out.print("                    `-...,_..-'      `--'/   `._, ^----'\n");
	    System.out.print("                         .\\            _'       ,'\n");
	    System.out.print("               `         `._-.______,.'`.___,.-'\n");
		System.out.println();
		System.out.println();
		System.out.println("It's a Weedle!");
	}
	
	public static void diglett() {
		System.out.print("                     _,.---'\"\"'\"--.._\n");
	    System.out.print("                   ,\"                `-.\n");
	    System.out.print("                 ,'                     `.\n");
	    System.out.print("                /     _       ,.          `.\n");
	    System.out.print("               /     ||      |\"|            \\\n");
	    System.out.print("              /      ||      | |             \\\n");
	    System.out.print("             /       .'      `_'              L\n");
	    System.out.print("            j                                 |\n");
	    System.out.print("            |        __,...._                 |\n");
	    System.out.print("            |      .\"        `.               |\n");
	    System.out.print("            |      '           )              |\n");
	    System.out.print("            |       `-...__,.-'               |\n");
	    System.out.print("            |                                 |\n");
	    System.out.print("            |                                 |\n");
	    System.out.print("         ...|                                 |\n");
	    System.out.print("      _,'   |                                 |\n");
	    System.out.print("  _,-'  ___ |                                 |.-----_\n");
	    System.out.print("-' ,.--`.  \\|                                 |     . \\\n");
	    System.out.print(",-'     ,  |--,                               |  _,'   `- -----._\n");
	    System.out.print("      ,' ,'    - ----.            _,..       _|.',               \\\n");
	    System.out.print(" ,-\"\"' .-             \\  ____   `'  _-'`  ,-'     `.              `-\n");
	    System.out.print(" .--'\"`   ,--:`.       --    ,\"'. ,'  ,'`,_\n");
	    System.out.print("        _'__,' |  _,..'_    ,:______,-     --.         _.\n");
	    System.out.print("        -__..--' '      ` ..`L________,___ _,     _,.-'\n");
	    System.out.print("                                              '\" ' \n");
		System.out.println();
		System.out.println();
		System.out.println("It's a Diglett!");
	}


	public static int randomEncounter(int HP, int originalHP) {		// starts random encounter
		
		int encounterChance = (int)(Math.random() * 9 + 1);			// uses random number to choose encounter and calls method corresponding with that number
		
		
		if (encounterChance == 1) {
			bridge();
		}
		else if (encounterChance == 2) {
			valley();
		}
		else if (encounterChance == 3) {
			forest();
		}
		else if (encounterChance == 4) {
			stream();
		}
		else if (encounterChance == 5) {
			int number = traveler(HP, originalHP);		// for encounters that will effect HP, HP and original HP is passed in
			return number;
		}
		else if (encounterChance == 6) {
			int number = rocket(HP, originalHP);
			return number;
		}
		else if (encounterChance == 7) {
			int number = mushrooms(HP, originalHP);
			return number;
		}
		else if (encounterChance == 8) {
			int number = chickens(HP, originalHP);
			return number;
		}
		else {
			int number = pokecenter(HP, originalHP);
			return number;
		}
		return HP;
	}
	
	public static void bridge() {		//different random encounters, first four are passive meaning nothing happens besides descriptions
		System.out.println("You come to a bridge");
		System.out.println("The water below is clear and the air is crisp but there is nothing important to see");
		System.out.println("You should probably move on");
		
	}
	
	public static void valley() {
		System.out.println("You climb down into a wide valley");
		System.out.println("Other then butterflies and small critters there isn't much to see");
		System.out.println("You take the moment of peace as a chance to take a quick nap and then move on");
	}
	
	public static void forest() {
		System.out.println("You journey through a dark and thick forest");
		System.out.println("Despite the scary darkness you encoutner nothing but trees");
		System.out.println("Eventually you see light cracking through the branches");
		System.out.println("You emerge on the other side and continue on your journey");
	}
	
	public static void stream() {
		System.out.println("You come across a shallow stream");
		System.out.println("Bounding across some rocks you cross it safely");
		System.out.println("You refill your water canteen with the cold water before moving on");
	
	}
	
	public static int traveler(int health, int originalHealth) {		// brings in health for calculations
		System.out.println("You come across a mysterious old traveler pulling a cart");
		System.out.println("He offers you a sample from a bottle from in his cart");
		System.out.println("He says it is one of his home-brewed health potions");
		System.out.println("Press 1 to try his potion or 2 to turn him down");	// uses scanner to give player choice and interaction
		String selection = scanner.nextLine();
		
		while ((!selection.equals("1")) && (!selection.equals("2"))) {		// had to use string even though they are numbers instead of int so it could redo if it was a bad input
			System.out.println("Not a valid input");						// if it was an int it would crash if string was input
			System.out.println("Please press 1 to try his potion or 2 to turn him down");
			selection = scanner.nextLine();
		}
		
		if (selection.equals("1")) {		
			System.out.println("You decide he looks trustful enough and take the bottle from his hand");
			System.out.println("As you press the bottle to your lips you notice the pink liquid has a soft glow to it");
			System.out.println("You drink it anyway and feel a warm sensation as it goes down your throat");
			
			int chance = (int)(Math.random() * 3 + 1);		// uses chance to decide how potion will effect the player
			
			if (chance == 1) {
				System.out.println("As the liquid gets to your stomach though it begins to burn");
				System.out.println("You immediatley keel over and gag feeling as if it is going to burn through your body");
				System.out.println("Not being able to help it you throw up right in front of the old man the liquid now glowing much brighter than when you last saw it");
				System.out.println("He breaks down apologizing saying it was his first time making it");
				System.out.println("You wave him of with a grunt and continue down the road");
				int loss = (int)(originalHealth * 0.08 * (Math.random() * ((1.7 - 0.7) + 1)) + 0.7);	//uses random numbers to give range of HP that will be taken
				System.out.println("You lose " + loss + " HP");
				health = (health - loss);
			}			
			else if (chance == 2) {																// neutral option that neither positively or negatively impacts player
				System.out.println("You finish the whole bottle and thank the old man");
				System.out.println("Despite the odd color and glow it tastes just like warm milk");
				System.out.println("You thank him again and continue on the path");
				System.out.println("A few hours later you still feel no effect from the drink");
				System.out.println("Maybe it was just warm milk afterall");
			}
			else {
				System.out.println("As it gets to your stomach you feel your muscles relax and energy fill your body");
				System.out.println("You thank him profusley and tell him how well it worked");
				System.out.println("Feeling recharged and ready you continue on your journey");
				int gain = (int)(originalHealth * 0.1 * (Math.random() * 3 + 1));					// uses random like before for range of HP given
				System.out.println("You gain " + gain + " HP");
				health = (health + gain);								//calculates new health
			}			
		}
		
		else {
			System.out.println("You politely turn down his offer and continue on your journey");							// what happens if you turn down his offer
			System.out.println("As you walk away you wonder who in their right mind would give out free health potion");
		}
		
		return health;		// returns health so it can be displayed and used for other calculations
	}
	
	public static int rocket(int health, int originalHealth) {		// another encounter that effects HP, only negatively this time
		System.out.println("As you are walking along you hear a faint shaking in the brush");
		System.out.println("You go to investigate and suddenly feel the sharp kick of a boot in your back");
		System.out.println("As you hit the ground you see the bright red R logo of Team Rocket plastered on your attackers shirt");
		System.out.println("When you've finally come back to your senses they have already left, taking some of your supplies and leaving you pretty banged up");
		int loss = (int)(originalHealth * 0.20 * (Math.random() * ((1.5 - 1) + 1.0)) + 1.0);	// uses random number to get random amount of damage
		System.out.println("You lose " + loss + " HP");
		health = (health - loss);								// calculates new health
		
		return health;				// returns new health
	}
	
	public static int mushrooms(int health, int originalHealth) {		// gives player options again
		System.out.println("You walk through a grassy clearing");
		System.out.println("You look down and see some mushrooms");
		System.out.println("You think hard trying to remember the field guide you read back in town");
		System.out.println("You seem to recall that the mushrooms are safe and have healing properties, but you can't say for sure");
		System.out.println("Press 1 if you want to eat the mushrooms and 2 if you want to leave them be");
		String selection = scanner.nextLine();
		
		while ((!selection.equals("1")) && (!selection.equals("2"))) {		// uses does not equal to make sure that not valid inputs can be redone like before
			System.out.println("Not a valid input");
			System.out.println("Please press 1 to eat the mushrooms or 2 to leave them");
			selection = scanner.nextLine();
		}
		
		if (selection.equals("1")) {
			System.out.println("You pick the mushroom out of the soil giving it a quick sniff");
			System.out.println("Deciding it's safe you put the whole thing into your mouth and chew");
			
			int chance = (int)(Math.random() * 3 + 1);
			
			if (chance <= 2) {		// gives 2/3 chance player benefits and 1/3 chance they are hurt using random numbers and if statements
				System.out.println("You feel your head clear and energy come back to your body as you finish the mushroom");
				System.out.println("You pick and eat a few more and continue through the grass feeling rejuvenated");
				int gain = (int)(originalHealth * 0.07);
				System.out.println("You gain " + gain + " HP");
				health = (health + gain);
			}
			else {
				System.out.println("A few minutes after finishing it you began to sweat alot and notice a rash forming on your arm");
				System.out.println("After a few hours the rash is gone and you seem okay, but the incident has left you feeling drained");
				System.out.println("Maybe next time you should actually bring the field guide into the field");
				int loss = (int)(originalHealth * 0.07);
				System.out.println("You lose " + loss + " HP");
				health = (health - loss);
			}
		}
		
		else {
			System.out.println("You decide to stick to the safe side and leave them be");		// displayed if player decides to pass
			System.out.println("Probably for the better as they didn't look to tasty anyway");
			System.out.println("You take one last glance and continue on your way");
		}
		
		return health;		// returns new health
	}
	
	public static int chickens(int health, int originalHealth) {									// this is another one that is only negative
		System.out.println("As you walk down the trail you hear a distinct clucking noise");
		System.out.println("Your eyes widen in fear and you begin to run but it is already to late");
		System.out.println("A swarm of Cucco birds attack you mercilessly");
		System.out.println("You finally escape, scratched and bruised badly");
		System.out.println("What did you ever do to those birds you wonder in misery");
		int loss = (int)(originalHealth * 0.15);											// instead of having randomness this one just takes set percent of your original health
		System.out.println("You lose " + loss + " HP");
		health = (health - loss);
		
		return health;
	}
	
	public static int pokecenter(int health, int originalHealth) {  // this one is only positive and is meant to be opposite of the one above
		System.out.println("You walk along the path and are suddenly overcome with excitement with what you spot in the distance");
		System.out.println("The bright familiar glow of the Pokecenter out in front of you draws you in");
		System.out.println("Once inside you take the time to relax and browse around");
		System.out.println("Before leaving you check in with the doctor and to your delight they have extra healing potions");
		System.out.println("You gladly use them and head back out to continue your journey");
		int gain = (int)(originalHealth * 0.15);													// uses percent of original health to select HP given to you
		System.out.println("You gain " + gain + " HP");
		health = (health + gain);	// calculates health
		
		return health;		// returns new health
	}
}

// in this program i did all the basic things along with adding extra features
// extra features include:
// scalable health depending on how many pokemon the player wants to catch
// having branching paths in the random encounters and giving players options on how they want to interact with the world
// using random numbers to manipulate results of these player choices
// using random numbers and the original HP to create randomness in the amount of HP being lost and gained
// keeping player updated on HP and and how many pokemon they have left to catch
// used if statements to have different end game messages depending on why the game ended


// this program was definitely the coolest/most fun one i've done all year, I hope we get to do more like it
// i also feel like i learned a lot by having to use all the different things we have learned together
// i had been having trouble understanding how returns work but doing this forced me to learn it for sure and understand it
// i also now understand on a very small scale what game designers mean when they talk about feature creep
// i had so many ideas for extra features i wanted to add but had to choose the ones that i had time for and were most important for the game