package com.example.monthleradmin.modules.member.domain;

import com.example.monthleradmin.common.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    private VendorType vendor;  // 가입 방법 구분

    private LocalDateTime retiredDt; // 탈퇴 일자

//    @OneToMany(mappedBy = "member")
//    List<Review> reviews = new ArrayList<>();

}