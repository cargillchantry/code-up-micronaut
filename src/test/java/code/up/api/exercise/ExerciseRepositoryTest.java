package code.up.api.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static code.up.api.exercise.ExerciseType.RUN;
import static org.assertj.core.api.Assertions.assertThat;

class ExerciseRepositoryTest {
    private ExerciseRepository exerciseRepository;

    @BeforeEach
    void setup() {
        exerciseRepository = new ExerciseRepository();
    }

    @Test
    void shouldSaveANewExercise() {
        // assemble
        final Exercise exercise = Exercise.builder().setDuration(Duration.ofMillis(123)).setExerciseType(RUN).build();
        // act
        exerciseRepository.save(exercise);
        // assert
        final List<Exercise> exercises = exerciseRepository.findAll();
        assertThat(exercises).hasSize(1);
        final Exercise saved = exercises.get(0);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getDuration()).isEqualTo(Duration.ofMillis(123));
        assertThat(saved.getExerciseType()).isEqualTo(RUN);
    }

    @Test
    void shouldFindExercseById() {
        // assemble
        exerciseRepository.save(Exercise.builder().setId("1234").build());
        exerciseRepository.save(Exercise.builder().setId("1235").build());
        exerciseRepository.save(Exercise.builder().setId("1236").build());
        // act
        final Optional<Exercise> byId = exerciseRepository.findById("1235");
        // assert
        assertThat(byId).isNotEmpty();
        assertThat(byId.get().getId()).isEqualTo("1235");
    }

    @Test
    void shouldReturnAllResultsWithFindAll() {
        // assemble (maybe populate the repository here?)

        // act
        final List<Exercise> exerciseList = exerciseRepository.findAll();
        // assert
        assertThat(exerciseList).hasSize(3);
        // what else can we test?
    }

    @Test
    void shouldDeleteAllEntriesFromTheRepository() {
        // assemble
        exerciseRepository.save(Exercise.builder().setId("test").build());
        // act
        exerciseRepository.deleteAll();
        // assert
        assertThat(exerciseRepository.findAll()).isEmpty();
    }

}