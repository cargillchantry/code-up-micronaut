package code.up.api.exercise;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Singleton
class ExerciseRepository {
    private final Map<String, Exercise> exercises = new HashMap<>();

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

    void deleteAll() {
        // unimplemented -- for code up
    }
}
