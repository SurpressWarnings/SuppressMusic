insert into roles(role) values
("USER"),
("ADMIN");

insert into users (user_name, first_name, last_name, password) values
    ("user1", "John", "Smith", "pass"),
    ("admin1", "Jane", "Doe", "pass");

insert into user_role (role_id, user_id) values
    ( 1),
    (2, 2);

insert into albums (album) values
("Revenge of the Dreamers III"),
("Under Pressure"),
("Worlds"),
("Graduation"),
("Brave New World"),
("Reanimation");

insert into genres (genre, display_name) values
   ("POP", "Pop"),
   ("ROCK", "Rock"),
   ("LATIN", "Latin"),
   ("RNB_SOUL", "R&B / Soul"),
   ("RAP_HIPHOP", "Rap / Hip-Hop"),
   ("DANCE_ELECTRONIC", "Dance / Electronic"),
   ("COUNTRY", "Country"),
   ("HOLIDAY", "Holiday"),
   ("GOSPEL_CHRISTIAN", "Gospel / Christian"),
   ("JAZZ_BLUES", "Jazz / Blues"),
   ("CLASSICAL", "Classical"),
   ("INTERNATIONAL", "International"),
   ("WORLD", "World");















ALTER TABLE genres
ALTER COLUMN genre VARCHAR(255);

insert into songs (artist, format, genre, price, song) values
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Under the Sun"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Down Bad"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "LamboTruck"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Swivel"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Oh Wow...Swerve"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Don\'t Hit Me Right Now"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Wells Fargo"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Sleep Deprived"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Self Love"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Ladies, Ladies, Ladies"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Costa Rica"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "1993"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Rembrandt...Run It Back"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Sunset"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Got Me"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Middle Child"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "PTSD"),
    ("Dreamville", "DIGITAL", "RAP_HIPHOP", 0.99, "Sacrifices"),

    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Intro"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Soul Food"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "I\'m Gone"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Gang Related"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Buried Alive"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Bounce"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Growing Pains III"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Never Enough"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Metropolis"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Nikki"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Till the End"),
    ("Logic", "cassette", "RAP_HIPHOP", 1.99, "Now"),

    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Divinity"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Sad Machine"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Years of War"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Flicker"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Fresh Static Snow"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Polygon Dust"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Hear the Bells"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Natural Light"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Lionhearted"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Sea of Voices"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Fellow Feeling"),
    ("Porter Robinson", "DIGITAL", "DANCE_ELECTRONIC", 0.99, "Goodbye to a World"),

    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Good Morning"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Champion"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Stronger"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "I Wonder"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Good Life"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Can\'t Tell Me Nothing"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Barry Bonds"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Drunk and Hot Girls"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Flashing Lights"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Everything I Am"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "The Glory"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Homecoming"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Baby Dubb"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Big Brother"),
    ("Kanye West", "CD", "RAP_HIPHOP", 1.99, "Good Night"),

    ("Iron Maiden", "DIGITAL", "ROCK", 0.99, "The Wicker Man"),
    ("Iron Maiden", "DIGITAL", "ROCK", 0.99, "Ghost of the Navigator"),
    ("Iron Maiden", "DIGITAL", "ROCK", 0.99, "Brave New World"),
    ("Iron Maiden", "DIGITAL", "ROCK", 0.99, "Blood Brothers"),
    ("Iron Maiden", "DIGITAL", "ROCK", 0.99, "The Mercenary"),
    ("Iron Maiden", "DIGITAL", "ROCK", 0.99, "Dream of Mirrors"),
    ("Iron Maiden", "DIGITAL", "ROCK", 0.99, "The Fallen Angel"),
    ("Iron Maiden", "DIGITAL", "ROCK", 0.99, "The Nomad"),
    ("Iron Maiden", "DIGITAL", "ROCK", 0.99, "Out of the Silent Planet"),
    ("Iron Maiden", "DIGITAL", "ROCK", 0.99, "The Thin Line Between Love and Hate"),

    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "Opening"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "Points of Authority"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "In the End"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "[Chali]"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "Forgotten"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "Pushing Me Away"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "A Place for My Head"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "X-Ecutioner Style"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "High Voltage"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "[Riff Raff]"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "With You"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "Ntr\Mssion"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "Papercut"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "Runaway"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "My December"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "[Stef]"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "By Myself"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "Cure for the Itch"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "One Step Closer"),
    ("Linkin Park", "DIGITAL", "ROCK", 0.99, "Crawling");



