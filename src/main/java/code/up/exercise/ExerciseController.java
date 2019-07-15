package code.up.exercise;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
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
    HttpResponse<ExerciseDto> save(@Body final ExerciseDto exercise) {
        return HttpResponse.created(
            exerciseRepository.save(new Exercise(exercise)).asDto()
        );
    }
}
