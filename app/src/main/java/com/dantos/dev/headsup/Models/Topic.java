package com.dantos.dev.headsup.Models;

import org.json.JSONArray;
import org.json.JSONException;

public class Topic {

    public String name;
    public String[] subjects;

    public static JSONArray getTopics() throws JSONException {

        String topics        = "[{\"title\":\"Superstars\",\"subjects\":[\"Janet Jackson\",\"Leighton Meester\",\"Willow Smith\",\"Matt Lauer\",\"Josh Duhamel\",\"Sharon Osbourne\",\"Spencer Pratt\",\"Demi Moore\",\"Whitney Houston\",\"Nicole Kidman\",\"Miley Cyrus\",\"Victoria Beckham\",\"LeAnn Rimes\",\"Dakota Fanning\",\"Dr. Seuss\",\"Ryan Phillippe\",\"Steve Carell\",\"Chris Rock\",\"Collin Ferell\",\"Drake\",\"Rachel McAdams\",\"Maya Rudolph\",\"Nelly Furtado\",\"Barbara Walters\",\"Alyson Hannigan\",\"Ashley Olsen\",\"Joseph Gordon-Levitt\",\"Kate Middleton\",\"Tom Hanks\",\"Clay Aiken\",\"Channing Tatum\"]},{\"title\":\"That's so 90s\",\"subjects\":[\"El Niño\",\"Viagra\",\"Animaniacs\",\"League of their Own\",\"Happy Gilmore\",\"Nick Carter\",\"My Heart Will Go On\",\"I Know What You Did Last Summer\",\"Can You Feel The Love Tonight\",\"The Macarana\",\"Light-up Sneakers\",\"Boy Meets World\",\"Baby Got Back\",\"Smells Like Teen Spirit\",\"Super Soakers\",\"7th Heaven\",\"Garth Brooks\",\"Floppy Discs\",\"Kramer\",\"Blink 182\",\"Surge\",\"Mighty Ducks\",\"Lamb Chop\",\"The Baseball Strike\",\"Macaulay Culkin\",\"Chain wallets\",\"Martin Lawrence\",\"Heather Locklear\",\"90210\",\"Clueless\"]},{\"title\":\"Hey Mr. DJ\",\"subjects\":[\"'Girl On Fire' Alicia Keys\",\"'U Can't Touch This' MC Hammer\",\"'Hello' Lionel Richie\",\"'Dark Horse' Katy Perry\",\"'Somebody To Love' Queen\",\"'No Scrubs' TLC\",\"'Happy' Pharrell Williams\",\"'Piano Man' Billy Joel\",\"'Blurred Lines' Robin Thicke\",\"'Fantasy' Mariah Carey\",\"'I Will Survive' Gloria Gaynor\",\"'Come and Get it' Selena Gomez\",\"'Halo' Beyonce\",\"'I Believe I Can Fly' R.Kelly\",\"'The Sign' Ace of Base\",\"'Diamonds' Rihanna\",\"'A Thousand Miles' Vanessa Carlton\",\"'What a Wonderful World' Louis Armstrong\",\"'We Belong Together' Mariah Carey\",\"'(I Can't Get No) Satisfaction' The Rolling Stones\",\"'I'd Do Anything For Love' Meat Loaf\",\"'Brown Eyed Girl' Van Morrison\",\"'Beat It' Michael Jackson\",\"'What Makes You Beautiful' One Direction\",\"'PYT' Michael Jackson\",\"'Respect' Aretha Franklin\",\"'MMM Bop' Hanson\",\"'All About that Bass' Meghan Trainor\",\"'Royals' Lorde\",\"'Love You Like A Love Song' Selena Gomez \\u0026 the Scene\"]},{\"title\":\"Icons, Legends, \\u0026 Stars\",\"subjects\":[\"Colin Farrell\",\"Mozart\",\"Billy Joel\",\"Judy Garland\",\"Napoleon Bonaparte\",\"Queen Elizabeth II\",\"Fred Armisen\",\"Henry Ford\",\"Jon Lovitz\",\"Julia Child\",\"Catherine the Great\",\"Magic Johnson\",\"Uma Thurman\",\"Orson Welles\",\"Kathy Bates\",\"George Orwell\",\"Billy Crystal\",\"Farrah Fawcett\",\"Gary Busey\",\"Chris Farley\",\"Tom Selleck\",\"Alexander the Great\",\"Ricky Gervais\",\"Tracey Ullman\",\"Bette Davis\",\"Jeremy Irons\",\"Chaka Khan\",\"Oscar Wilde\",\"Dan Aykroyd\",\"Margaret Thatcher\",\"Carol Burnett\",\"Patrick Stewert\"]},{\"title\":\"Animals Gone Wild\",\"subjects\":[\"Chipmunk\",\"Dragon\",\"Wasp\",\"Snake\",\"Jellyfish\",\"Emu\",\"Boar\",\"Crocodile\",\"Shrimp\",\"Lemur\",\"Caterpillar\",\"Sea Urchain\",\"Dolphin \",\"Camel\",\"Viper\",\"Fox\",\"Tuna\",\"Baboon\",\"Chinchilla\",\"Human\",\"Crawfish\",\"Cricket\",\"Frog\",\"Tiger\",\"Guinea Pig\",\"Gnat\",\"Killer Whale\",\"Coral\",\"T-Rex\",\"Oyster\",\"Clam\",\"Cow\",\"Chicken\",\"Pig\",\"LLama\",\"Goose\",\"Sheep\",\"Rabbit\",\"Goat\",\"Donkey\",\"Horse\",\"Ducks\",\"Turkey\",\"Ox\",\"Rattlesnake\",\"Starfish\",\"Hippopotamus\",\"Moth\",\"Swordfish\",\"Hammerhead Shark\",\"Sea Lion\",\"Bull\",\"Lizard\",\"Squirrel\",\"Seahorse\"]},{\"title\":\"Blockbuster Movies\",\"subjects\":[\"Crocodile Dundee\",\"Star Wars: The Phantom Menace\",\"Beverly HIlls cop\",\"The Pursuit of Happyness\",\"Back to the Future\",\"Liar Liar\",\"Kindergarten Cop\",\"Gravity\",\"Indiana Jones and the Last Crusade\",\"Southbound\",\"Land Before Time\",\"Cinderella\",\"Journey to the West\",\"Galaxy Quest\",\"Spaceballs\",\"The Conjuring\",\"Sharknado\",\"The Dark Knight\",\"Schindler's List\",\"ET\",\"National Treasure\",\"Gone in 60 Seconds\",\"The Wicker Man\",\"Ghost Rider\",\"The Family Man\",\"The Incredibles\",\"Ferris Buellers Day Off\",\"Dirty Dancing\",\"Dances with Wolves\",\"Water World\",\"National Lampoons: Chrismas Vacation\",\"Air Bud\",\"Air Bud 2\"]},{\"title\":\"Access Code 2.2 Students\",\"subjects\":[\"Artur Lan\",\"Ayuna Vogel\",\"Bereket Ghebremedhin\",\"Brian Blanco\",\"Charles H Kang\",\"Chris David\",\"Christella Dolmo\",\"Christian Maldonado\",\"Daaaaaammmmmmnnnnn Daniel\",\"Derek Netto\",\"Diana Elezaj\",\"Elber Carneiro\",\"Eric Sanchez\",\"Eric Sze\",\"Felicia Weathers\",\"Henna Ahmed\",\"Jackie Meggesto\",\"Jamaal Sedayao\",\"Jason Wang\",\"Jovanny Espinal\",\"Justine Kay\",\"Kaira Villanueva\",\"Kaisha Jones\",\"Krishna Picart\",\"Lauren Caponong\",\"Mesfin Bekele Mekonnen\",\"Natalia Estrella\",\"Shena Yoshida\",\"Umar Mahmud\",\"Varindra Hart\",\"Xiulan Shi\",\"Zoufishan Mehdi\"]}]";

        return new JSONArray(topics);

    }

}
