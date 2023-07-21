package com.geekster.InstagramBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.geekster.InstagramBackend.model.enums.PostType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @NotBlank
    private String postContent;

    private String postCaption;

    private String postLocation;

//    @Enumerated(EnumType.STRING)
    private PostType postType;

//    @NotBlank
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hide this in json but not in database table column
    private LocalDateTime postCreatedTimeStamp;

//    @NotBlank
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hide this in json but not in database table column
    private LocalDateTime postUpdatedTimeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_post_user_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hide this in json but not in database table column
    private User postOwner;
}
