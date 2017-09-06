package com.example.demo;

import lombok.*;

@Getter
@ToString
@RequiredArgsConstructor
@Builder
public class City {
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String state;
    @NonNull
    private String country;
}