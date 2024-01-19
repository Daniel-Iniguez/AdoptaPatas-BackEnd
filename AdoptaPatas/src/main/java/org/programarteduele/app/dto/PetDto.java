package org.programarteduele.app.dto;

import java.time.LocalDateTime;

import org.programarteduele.app.entity.PetType;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PetDto {
	
    private Long id;
    private String name;
    private String size;
    private String age;
    private String sex;
    private String breed;
    private String color;
    private String characteristics;
    private String description;
    private String petImage;
    private String healthCondition;
    private LocalDateTime dateAdded;
    private UserDto user;
    private PetType petType;
  
}

