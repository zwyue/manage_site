package com.zr.gansu.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {
    private Long id;

    private String role;

    private String name;

    private String description;
}