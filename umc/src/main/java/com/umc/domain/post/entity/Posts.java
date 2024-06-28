package com.umc.domain.post.entity;


import com.umc.common.entity.BaseTimeEntity;
import com.umc.domain.mapping.Post_Comment.Post_Comment;
import com.umc.domain.user.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Builder
@Setter
@NoArgsConstructor
@Entity
@Table(name = "member")
@AllArgsConstructor
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "Content", columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Post_Comment> Post_CommentList = new ArrayList<>();
}
