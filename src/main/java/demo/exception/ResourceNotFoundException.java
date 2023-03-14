package demo.exception;

import static java.lang.String.format;

public class ResourceNotFoundException extends RuntimeException {

    public <T> ResourceNotFoundException(Class<T> resource, Long id) {
        super(format("%s %s not found", resource.getSimpleName(), id));
    }

}
