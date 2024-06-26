package goormcoder.webide.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import goormcoder.webide.domain.enumeration.Language;
import goormcoder.webide.domain.enumeration.SolveResult;
import jakarta.persistence.*;
import lombok.AccessLevel;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@Table(name = "t_solve")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Solve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solve_id")
    private Long id;

    @Column(name = "solve_code")
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "solve_result")
    private SolveResult solveResult;

    @Enumerated(EnumType.STRING)
    @Column(name = "solve_language")
    private Language language;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "quest_id", nullable = false)
    private Question question;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public Solve(Question question, Member member, String code, Language language, SolveResult solveResult) {
        this.question = question;
        this.member = member;
        this.code = code;
        this.language = language;
        this.solveResult = solveResult;
    }
}
