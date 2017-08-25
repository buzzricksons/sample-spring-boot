package com.example.demo;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class City {
    private Long id;
    private String name;
    private String state;
    private String country;

}