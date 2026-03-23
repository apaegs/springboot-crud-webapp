package org.noob.springbootcrudwebapp;

import org.noob.springbootcrudwebapp.entity.Movie;
import org.noob.springbootcrudwebapp.repository.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataSeeder implements ApplicationRunner {

    private final MovieRepository repository;

    public DataSeeder(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (repository.count() > 0) return;

        repository.saveAll(List.of(
                movie("Inception", "A thief who steals corporate secrets through dream-sharing technology is given the inverse task of planting an idea.", "Christopher Nolan", LocalDate.of(2010, 7, 16), 148),
                movie("The Dark Knight", "When the menace known as the Joker wreaks havoc on Gotham, Batman must accept one of the greatest psychological tests of his ability to fight injustice.", "Christopher Nolan", LocalDate.of(2008, 7, 18), 152),
                movie("Interstellar", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity survival.", "Christopher Nolan", LocalDate.of(2014, 11, 7), 169),
                movie("The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", "Frank Darabont", LocalDate.of(1994, 9, 23), 142),
                movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his empire to his reluctant son.", "Francis Ford Coppola", LocalDate.of(1972, 3, 24), 175),
                movie("Pulp Fiction", "The lives of two mob hitmen, a boxer, a gangster and his wife intertwine in four tales of violence and redemption.", "Quentin Tarantino", LocalDate.of(1994, 10, 14), 154),
                movie("Schindlers List", "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce.", "Steven Spielberg", LocalDate.of(1993, 12, 15), 195),
                movie("The Lord of the Rings: The Fellowship of the Ring", "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring.", "Peter Jackson", LocalDate.of(2001, 12, 19), 178),
                movie("Forrest Gump", "The presidencies of Kennedy and Johnson, the Vietnam War, and other historical events unfold from the perspective of an Alabama man.", "Robert Zemeckis", LocalDate.of(1994, 7, 6), 142),
                movie("Fight Club", "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.", "David Fincher", LocalDate.of(1999, 10, 15), 139),
                movie("Goodfellas", "The story of Henry Hill and his life in the mob, covering his marriage and his life of crime.", "Martin Scorsese", LocalDate.of(1990, 9, 19), 146),
                movie("The Matrix", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", "Lana Wachowski", LocalDate.of(1999, 3, 31), 136),
                movie("Se7en", "Two detectives hunt a serial killer who uses the seven deadly sins as his modus operandi.", "David Fincher", LocalDate.of(1995, 9, 22), 127),
                movie("The Silence of the Lambs", "A young FBI cadet must receive the help of an incarcerated and manipulative cannibal killer to catch another serial killer.", "Jonathan Demme", LocalDate.of(1991, 2, 14), 118),
                movie("Saving Private Ryan", "Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.", "Steven Spielberg", LocalDate.of(1998, 7, 24), 169),
                movie("Gladiator", "A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.", "Ridley Scott", LocalDate.of(2000, 5, 5), 155),
                movie("The Departed", "An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston.", "Martin Scorsese", LocalDate.of(2006, 10, 6), 151),
                movie("Whiplash", "A promising young drummer enrolls at a cut-throat music conservatory where his dreams of greatness are mentored by an instructor who will stop at nothing.", "Damien Chazelle", LocalDate.of(2014, 10, 10), 107),
                movie("Parasite", "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.", "Bong Joon-ho", LocalDate.of(2019, 5, 30), 132),
                movie("The Grand Budapest Hotel", "The adventures of Gustave H, a legendary concierge at a famous European hotel between the wars, and Zero Moustafa, the lobby boy who becomes his most trusted friend.", "Wes Anderson", LocalDate.of(2014, 3, 28), 99),
                movie("No Country for Old Men", "Violence and mayhem ensue after a hunter stumbles upon a drug deal gone wrong and takes the money while being pursued by a relentless killer.", "Joel Coen", LocalDate.of(2007, 11, 9), 122),
                movie("There Will Be Blood", "A story of family, religion, hatred, oil and madness, focusing on a turn-of-the-century prospector in the early days of the business.", "Paul Thomas Anderson", LocalDate.of(2007, 12, 26), 158),
                movie("Mad Max: Fury Road", "In a post-apocalyptic wasteland, a woman rebels against a tyrannical ruler in search for her homeland with the aid of a group of female prisoners.", "George Miller", LocalDate.of(2015, 5, 15), 120),
                movie("La La Land", "While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.", "Damien Chazelle", LocalDate.of(2016, 12, 9), 128),
                movie("The Revenant", "A frontiersman on a fur trading expedition in the 1820s fights for survival after being mauled by a bear and left for dead by members of his own hunting team.", "Alejandro G. Inarritu", LocalDate.of(2015, 12, 25), 156)
        ));
    }

    private Movie movie(String title, String description, String director,
                        LocalDate releaseDate, int duration) {
        Movie m = new Movie();
        m.setTitle(title);
        m.setDescription(description);
        m.setDirector(director);
        m.setReleaseDate(releaseDate);
        m.setDuration(duration);
        return m;
    }
}
