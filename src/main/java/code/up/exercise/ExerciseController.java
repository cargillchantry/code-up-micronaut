package code.up.exercise;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import javax.inject.Inject;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ExerciseController {
    private final ExerciseRepository exerciseRepository;

    @Inject
    public ExerciseController(final ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Get("/exercises")
    List<ExerciseDto> findAll() {
        return exerciseRepository
            .findAll()
            .stream()
            .map(Exercise::asDto)
            .collect(Collectors.toUnmodifiableList());
    }

    @Post("/exercises")
    HttpResponse<ExerciseDto> create(final ExerciseDto exercise) {
        final Exercise savedExercise = exerciseRepository.save(Exercise.fromDto(exercise).build());
        return HttpResponse.created(savedExercise.asDto(), exerciseSelfUri(savedExercise));
    }

    @Put("/exercises/{uuid}")
    ExerciseDto update(final ExerciseDto exerciseDto, final String uuid) {
        // can someone help ?
        return null;
    }

    private static URI exerciseSelfUri(final Exercise exercise) {
        return URI.create("/exercises/" + exercise.getId());
    }
}
