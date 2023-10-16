package com.pda1.project.domain.UserInformation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pda1.project.domain.BaseTimeEntity;
import com.pda1.project.domain.Evaluation.Evaluation;
import com.pda1.project.domain.InterestItem.InterestItem;
import com.pda1.project.domain.survey.Survey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserInformation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String name;
    private String email;
    private String account;
    private String password;

//    @OneToOne
//    @JoinColumn(name = "survey_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Survey survey;

    @OneToMany(mappedBy = "userInformation", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<InterestItem> interestItems = new ArrayList<>();

    @OneToMany(mappedBy = "userInformation", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Evaluation> evaluations = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
