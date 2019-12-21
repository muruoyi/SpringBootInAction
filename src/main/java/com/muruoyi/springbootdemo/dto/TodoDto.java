package com.muruoyi.springbootdemo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TodoDto {

    private Integer id;

    private String title;

    private String desc;

    private Boolean completed;

    private Integer accountId;

}
