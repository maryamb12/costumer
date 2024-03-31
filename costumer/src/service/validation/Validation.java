package service.validation;

import service.Exception.ValidationException;

@FunctionalInterface
public interface Validation<T> {
    void validate(T t) throws ValidationException;
}
