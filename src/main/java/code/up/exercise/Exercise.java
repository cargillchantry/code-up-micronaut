package code.up.exercise;

import java.time.Duration;

class Exercise {
    private String id;
    private Duration duration;
    private ExerciseType exerciseType;

    Exercise(final ExerciseDto exerciseDto) {
        this.id = null;
        this.exerciseType = exerciseDto.getExerciseType();
        this.duration = exerciseDto.getDuration() == null ? Duration.ZERO : exerciseDto.getDuration();
    }

    Exercise(){}

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

    Exercise setId(final String id) {
        this.id = id;
        return this;
    }

    Exercise setDuration(final Duration duration) {
        this.duration = duration;
        return this;
    }

    Exercise setExerciseType(final ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
        return this;
    }

    Exercise cloned() {
        return new Exercise()
            .setDuration(duration)
            .setExerciseType(exerciseType)
            .setId(id);
    }
}
