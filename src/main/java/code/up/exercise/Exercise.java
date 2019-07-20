package code.up.exercise;

import java.time.Duration;

class Exercise {
    private final String id;
    private final Duration duration;
    private final ExerciseType exerciseType;

    private Exercise(final Builder builder) {
        this.id = builder.id;
        this.exerciseType = builder.exerciseType;
        this.duration = builder.duration;
    }

    ExerciseDto asDto() {
        return new ExerciseDto(exerciseType, duration);
    }

    String getId() {
        return id;
    }

    ExerciseType getExerciseType() {
        return exerciseType;
    }

    Duration getDuration() {
        return duration;
    }

    Builder cloned() {
        return new Builder(this);
    }

    static Builder fromDto(final ExerciseDto exerciseDto) {
        return new Builder(exerciseDto);
    }

    static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private Duration duration;
        private ExerciseType exerciseType;
        private String id;

        private Builder() {}

        private Builder(final Exercise exercise) {
            duration = exercise.duration;
            exerciseType = exercise.exerciseType;
            id = exercise.id;
        }

        private Builder(final ExerciseDto exerciseDto) {
            duration = exerciseDto.getDuration() == null ? Duration.ZERO : exerciseDto.getDuration();
            exerciseType = exerciseDto.getExerciseType();
            id = null;
        }

        Builder setDuration(final Duration duration) {
            this.duration = duration;
            return this;
        }

        Builder setExerciseType(final ExerciseType exerciseType) {
            this.exerciseType = exerciseType;
            return this;
        }

        Builder setId(final String id) {
            this.id = id;
            return this;
        }

        Exercise build() {
            return new Exercise(this);
        }
    }
}
