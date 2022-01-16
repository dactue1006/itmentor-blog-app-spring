package com.example.itmentor.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostRequestDTO {
    @NotBlank
    private String title;

    @NotBlank
    @Size(max = 1000)
    private String content;

    public PostRequestDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
