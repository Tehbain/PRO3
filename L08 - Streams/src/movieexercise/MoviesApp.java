package movieexercise;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoviesApp {
    public static List<Movie> readMovies(String filename) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNextLine()) {
                String nameLine = in.nextLine();
                String yearLine = in.nextLine();
                String directorsLine = in.nextLine();
                String producersLine = in.nextLine();
                String actorsLine = in.nextLine();
                movies.add(new Movie(getString(nameLine),
                        Integer.parseInt(getString(yearLine)),
                        getList(directorsLine), getList(producersLine),
                        getList(actorsLine)));
            }
        }
        return movies;
    }

    private static String getString(String line) {
        int colon = line.indexOf(":");
        return line.substring(colon + 1).trim();
    }

    private static List<String> getList(String line) {
        return Stream.of(getString(line).split(", "))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        String BREAK = "\t\t";

        List<Movie> movieList = readMovies("movies.txt");
//        for (Movie m : movieList) {
//            System.out.println(m.getTitle());
//        }

        //movieList.stream().forEach(e -> System.out.println(e.getTitle()));
        //System.out.println("Number of movies: " + movieList.size());

        //  The numer of movies starting with "H"
        {
            long countH = movieList.stream()
                    .filter(movie -> movie.getTitle().startsWith("H"))
                    .count();
            System.out.println("The number of movies starting with \"H\": ");
            System.out.println(BREAK + countH);
            System.out.println();
        }

        // The title of the movies starting with "X"
        {
            movieList.stream()
                    .filter(movie -> movie.getTitle().startsWith("X"))
                    .forEach(movie -> {
                System.out.print(movie.getTitle() + ", ");
            });
            System.out.println("\n");
        }

        // The number of films where the director is also an actor
        {
            long directorIsActorCount = movieList.stream()
                    .filter(movie -> (movie.getActors().stream()
                            .anyMatch(actor -> movie.getDirectors().contains(actor)))).count();
            System.out.println("The number of films where the director is also an actor: ");
            System.out.println(BREAK + directorIsActorCount);
            System.out.println();
        }

        //The number of actors in the film with the most actors
        {
            long mostActedEUWcount = movieList.stream()
                    .max((movie1,movie2) -> movie1.getActors().size() - movie2.getActors().size())
                    .get().getActors().size();
            System.out.println("The number of actors in the film with the most actors: ");
            System.out.println(BREAK + mostActedEUWcount);
            System.out.println();
        }

        // The title of the film with the most actors
        {
            Movie mostActedEUWname = movieList.stream()
                    .max((movie1, movie2) -> movie1.getActors().size() - movie2.getActors().size())
                    .get();
            System.out.println("The title of the film with the most actors:");
            System.out.println(BREAK + mostActedEUWname.getTitle() + " (" + mostActedEUWname.getActors().size() + ")");
            System.out.println();
        }

        //Number of films divided by first letter in the film title
        {
            System.out.println("Number of films divided by first letter in the film title:");
            movieList.stream()
                    .collect(Collectors.groupingBy(e -> e.getTitle().charAt(0), TreeMap::new, Collectors.counting()))
                    .forEach((k,v) -> {
                        System.out.println(k + ": " + v);
                    });

        }

        // Number of movies whose title starts with "The "
        {
            long theCount = movieList.stream().filter(movie -> movie.getTitle().startsWith("The ")).count();
            System.out.println();
            System.out.println("Number of movies whose title starts with \"The \":");
            System.out.println(BREAK + theCount);
            System.out.println();
        }
    }
}

