package code.up.api.exercise;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import javax.inject.Inject;
import java.net.URI;

@Controller
public class ExerciseController {
    private final ExerciseRepository exerciseRepository;

    @Inject
    public ExerciseController(final ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Get("/exercises")
    ExercisesResponseDto findAll() {
        return new ExercisesResponseDto(exerciseRepository.findAll());
    }

    @Post("/exercises")
    HttpResponse<ExerciseResponseDto> create(final ExerciseDto exercise) {
        final Exercise savedExercise = exerciseRepository.save(Exercise.fromDto(exercise).build());
        return HttpResponse.created(new ExerciseResponseDto(savedExercise), exerciseSelfUri(savedExercise));
    }

    @Put("/exercises/{uuid}")
    ExerciseResponseDto update(final ExerciseDto exerciseDto, final String uuid) {
        // can someone help ?
        return null;
    }

    private static URI exerciseSelfUri(final Exercise exercise) {
        return URI.create("/exercises/" + exercise.getId());
    }
}
