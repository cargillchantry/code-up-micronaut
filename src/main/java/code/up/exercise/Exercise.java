package code.up.exercise;

import java.time.Duration;

class Exercise {
    private final String id;
    private final Duration duration;
    private final ExerciseType exerciseType;

    Exercise(final ExerciseDto exerciseDto) {
        this.id = null;
        this.exerciseType = exerciseDto.getExerciseType();
        this.duration = exerciseDto.getDuration() == null ? Duration.ZERO : exerciseDto.getDuration();
    }

    private Exercise(final ExerciseBuilder exerciseBuilder) {
        this.id = exerciseBuilder.id;
        this.exerciseType = exerciseBuilder.exerciseType;
        this.duration = exerciseBuilder.duration;
    }

    ExerciseDto asDto() {
        return new ExerciseDto(exerciseType, duration);
    }

    ExerciseBuilder cloned() {
        return new ExerciseBuilder(this);
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

    static ExerciseBuilder builder() {
        return new ExerciseBuilder(null);
    }

    static class ExerciseBuilder {
        private String id;
        private Duration duration;
        private ExerciseType exerciseType;

        private ExerciseBuilder(final Exercise previous) {
            if(previous != null) {
                this.id = previous.id;
                this.duration = previous.duration;
                this.exerciseType = previous.exerciseType;
            }
        }

        public ExerciseBuilder setDuration(final Duration duration) {
            this.duration = duration;
            return this;
        }

        public ExerciseBuilder setExerciseType(final ExerciseType exerciseType) {
            this.exerciseType = exerciseType;
            return this;
        }

        ExerciseBuilder setId(final String id) {
            this.id = id;
            return this;
        }

        Exercise build() {
            return new Exercise(this);
        }
    }
}
