package mar.frias.movieapp3


data class Movie(
    val id: Int,
    val title: String,
    val year: Int,
    val duration: Int,

    val gender: String,
    val director: String,
    val summary: String,

    val image: Int
)

val movies = listOf(
    Movie(
        0,
        "Hamilton",
        2015,
        165,
        "Theater",
        "Lin Manuel Miranda",
        "I am no gonna throw away my shot",
        R.drawable.poster_hamilton
    ),
    Movie(
        1,
        "Sharknado",
        2030,
        300,
        "Documentary",
        "God",
        "It was real, I was shark #17",
        R.drawable.poster_sharknado
    ),
    Movie(
        2,
        "Superman",
        2025,
        129,
        "Superheroes",
        "James Gunn",
        "Being kind is good???",
        R.drawable.poster_superman
    ),
    Movie(
        3,
        "Your Name",
        2016,
        110,
        "Fantasy/Romance",
        "Makoto Shinkai",
        "Two people change bodies any now an then.",
        R.drawable.poster_yourname
    ),
    Movie(
        4,
        "EPIC The Musical",
        2025,
        144,
        "Musical",
        "Jorge Rivera-Herrans",
        "The war veteran Odyssey tries to return home after a 10-year-long war. " +
                "The ocean hates him",
        R.drawable.poster_epicmusical
    ),
    Movie(
        5,
        "Spiderman into the spiderverse",
        2018,
        114,
        "Superheroes",
        "Bob Persichetti",
        "Spider bits spiderman.",
        R.drawable.poster_spiderman
    ),
    Movie(
        6,
        "Karate Kid",
        1984,
        127,
        "Drama",
        "John G. Avildsen",
        "Kid learns karate.",
        R.drawable.poster_karate_kid
    ),
    Movie(
        7,
        "Bee Movie",
        2007,
        91,
        "Drama",
        "Steve Hickner",
        "According to all known laws of aviation, there is no way a bee should be able to fly. " +
                "Its wings are too small to get its fat little body off the ground. " +
                "The bee, of course, flies anyway because bees don't care what humans think is impossible. " +
                "Yellow, black. Yellow, black. Yellow, black. Yellow, black. " +
                "Ooh, black and yellow!",
        R.drawable.poster_bmovie
    ),
    Movie(
        8,
        "Coyote vs ACME",
        2026,
        103,
        "Comedy/Romance",
        "Dave Green",
        "Coyote x Roadrunner <3",
        R.drawable.poster_coyote
    ),
    Movie(
        9,
        "Project Hail Mary",
        2026,
        156,
        "Sci-fi",
        "Dave Green",
        "Science teacher, alone in a spaceship and with amnesia, " +
                "slowly remembers how he got abducted by the government to study microorganisms. " +
                "A los of scientific accuracy for being sci-fi.",
        R.drawable.poster_hailmarry
    ),
    Movie(
        10,
        "La Leyenda de la Llorona",
        2011,
        81,
        "Family/Horror",
        "Alberto Rodríguez",
        "Scary monster that cries spooks some kids",
        R.drawable.poster_llorona
    ),
    Movie(
        11,
        "Puss in Boots and the Last Wish",
        2022,
        102,
        "Adventure/Comedy",
        "Joel Crawford",
        "Good movie. 10/10 Villians.",
        R.drawable.poster_pussinboots
    )

)