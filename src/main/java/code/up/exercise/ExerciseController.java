package code.up.exercise;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import javax.inject.Inject;
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
    HttpResponse<ExerciseDto> save(final HttpRequest<ExerciseDto> exercise) {
        final Exercise savedExercise = exerciseRepository.save(new Exercise(exercise.getBody().get()));
        return HttpResponse.created(savedExercise.asDto(), exercise.getUri());
    }
}
