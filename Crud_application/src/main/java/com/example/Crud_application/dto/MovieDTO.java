package com.example.Crud_application.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private int id;
    private String name;
    private String category;
    private String imgUrl;
}
