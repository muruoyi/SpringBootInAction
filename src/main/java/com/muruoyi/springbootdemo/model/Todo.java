package com.muruoyi.springbootdemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@ApiModel(description = "All details about the Todo.")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "唯一编码，有系统自动生成")
    private Integer id;

    @NotNull
    @ApiModelProperty(notes = "title is required.")
    private String title;

    @NotNull
    private String desc;

    @NotNull
    private Boolean completed;

    @NotNull
    private Integer accountId;
}
