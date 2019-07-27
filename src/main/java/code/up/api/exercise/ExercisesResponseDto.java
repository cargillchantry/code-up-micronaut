package code.up.api.exercise;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.micronaut.core.value.OptionalMultiValues;
import io.micronaut.http.hateoas.Link;
import io.micronaut.http.hateoas.Resource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ExercisesResponseDto implements Resource {
    private static final OptionalMultiValues<? extends Link> SELF_LINK = OptionalMultiValues
        .of(Map.of(Link.SELF, List.of(Link.of("/exercises"))));

    private final List<ExerciseResponseDto> exerciseResponseDtos;

    ExercisesResponseDto(final List<Exercise> exerciseList) {
        exerciseResponseDtos = exerciseList.stream().map(ExerciseResponseDto::new)
            .collect(Collectors.toUnmodifiableList());
    }

    @JsonGetter(Resource.EMBEDDED)
    public OptionalMultiValues<? extends Resource> getEmbedded() {
        return OptionalMultiValues.of(Map.of("exercises", exerciseResponseDtos));
    }

    @JsonGetter(Resource.LINKS)
    public OptionalMultiValues<? extends Link> getLinks() {
        return SELF_LINK;
    }
}
