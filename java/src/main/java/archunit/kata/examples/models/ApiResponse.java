package archunit.kata.examples.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiResponse<TData> {
    private final TData data;
    private final ApiError[] apiError;
}