package code.up.exercise;

import code.up.http.UriToAbsoluteServiceUriResolver;
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
    private final UriToAbsoluteServiceUriResolver uriResolver;
    private final ExerciseRepository exerciseRepository;

    @Inject
    public ExerciseController(
        final UriToAbsoluteServiceUriResolver uriToAbsoluteServiceUriResolver,
        final ExerciseRepository exerciseRepository
    ) {
        this.uriResolver = uriToAbsoluteServiceUriResolver;
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
    HttpResponse<?> save(final HttpRequest<ExerciseDto> exercise) {
        return exercise.getBody()
            .map(Exercise::fromDto)
            .map(Exercise.Builder::build)
            .map(exerciseRepository::save)
            .map(Exercise::asDto)
            .map(saved -> HttpResponse.created(saved, uriResolver.derive(exercise.getUri())))
            .orElseGet(HttpResponse::badRequest);
    }
}
