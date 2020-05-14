package it.learn.cucumber.examples.shopping;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {

    private Long id;

    private Date createTime;

    private Date updateTime;

}
