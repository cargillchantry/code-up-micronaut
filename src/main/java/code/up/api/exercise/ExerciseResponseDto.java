package code.up.api.exercise;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.micronaut.core.value.OptionalMultiValues;
import io.micronaut.http.hateoas.Link;
import io.micronaut.http.hateoas.Resource;
import java.util.List;
import java.util.Map;

class ExerciseResponseDto extends ExerciseDto implements Resource {
    private final String id;

    ExerciseResponseDto(final Exercise exercise) {
        super(exercise.getExerciseType(), exercise.getDuration());
        id = exercise.getId();
    }

    public String getId() {
        return id;
    }

    @JsonGetter(Resource.LINKS)
    public OptionalMultiValues<? extends Link> getLinks() {
        return OptionalMultiValues.of(Map.of(Link.SELF, List.of(Link.of("/exercises/" + id))));
    }
}
