package code.up.exercise;

import javax.inject.Singleton;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static code.up.exercise.ExerciseType.RUN;

@Singleton
class ExerciseRepository {
    private final Map<String, Exercise> exercises = new HashMap<>();

    ExerciseRepository() {
        exercises.put(
            "test",
            Exercise.builder().setDuration(Duration.ofHours(2)).setExerciseType(RUN).setId("test").build()
        );
    }

    Exercise save(final Exercise exercise) {
        final Exercise toSave;
        if(exercise.getId() == null) {
            toSave = exercise.cloned().setId(UUID.randomUUID().toString()).build();
        }
        else {
            toSave = exercise;
        }
        exercises.put(toSave.getId(), toSave);
        return toSave;
    }

    List<Exercise> findAll() {
        return List.copyOf(exercises.values());
    }
}
