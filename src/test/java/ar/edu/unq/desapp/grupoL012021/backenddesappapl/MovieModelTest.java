package ar.edu.unq.desapp.grupoL012021.backenddesappapl;


import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieModelTest {

    private Movie testMovie = new Movie(1, "Die Hard", "Die Hard",
            1988, Mockito.mock(ArrayList.class), Mockito.mock(ArrayList.class),
            Mockito.mock(ArrayList.class));

    @Test
    @DisplayName("Can get data from Movie model")
    public void testNew() {
        assertEquals("Die Hard", testMovie.getTitle());
    }
}
