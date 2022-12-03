package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableRepositoryTest {

    @Test
    void 테이블번호로_테이블찾기() {
        Table table = TableRepository.findByNumber(1);
        assertThat(table).isEqualTo(new Table(1));
    }

    @Test
    void 테이블전호로_테이블찾을때_없으면_예외발생() {
        assertThatThrownBy(() -> TableRepository.findByNumber(200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 테이블 번호는 없습니다.");
    }
}