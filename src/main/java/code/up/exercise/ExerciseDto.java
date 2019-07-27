package code.up.exercise;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;

@JsonIgnoreProperties(ignoreUnknown = true)
class ExerciseDto {
    private final ExerciseType exerciseType;
    private final Duration duration;

    @JsonCreator
    ExerciseDto(
        @JsonProperty("exerciseType") final ExerciseType exerciseType,
        @JsonProperty("duration") final Duration duration
    ) {
        this.exerciseType = exerciseType;
        this.duration = duration;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public Duration getDuration() {
        return duration;
    }
}
