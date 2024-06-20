package goormcoder.webide.dto.response;

import goormcoder.webide.domain.Question;
import java.util.List;

public record QuestionSummaryDto(
        Long id,
        Integer level,
        String title
) {
    public static QuestionSummaryDto of(Question question) {
        if (question == null) {
            return null;
        }
        return new QuestionSummaryDto(
                question.getId(),
                question.getLevel(),
                question.getTitle()
        );
    }
    public static List<QuestionSummaryDto> listOf(List<Question> questions) {
        return questions.stream()
                .map(QuestionSummaryDto::of)
                .toList();
    }
}
