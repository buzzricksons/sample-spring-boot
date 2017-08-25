package com.example.demo;

import lombok.*;

@Getter
@ToString
@RequiredArgsConstructor
public class City {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String state;
    @NonNull
    private String country;
}