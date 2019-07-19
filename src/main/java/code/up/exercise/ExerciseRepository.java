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
            new Exercise().setDuration(Duration.ofHours(2)).setExerciseType(RUN).setId("test")
        );
    }

    Exercise save(final Exercise exercise) {
        final Exercise toSave;
        if(exercise.getId() == null) {
            toSave = exercise.cloned().setId(UUID.randomUUID().toString());
        }
        else {
            toSave = exercise.cloned();
        }
        exercises.put(toSave.getId(), toSave);
        return toSave.cloned();
    }

    List<Exercise> findAll() {
        return List.copyOf(exercises.values());
    }
}
