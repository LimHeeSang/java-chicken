package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableRepositoryTest {

    @Test
    void 테이블번호로_테이블찾기() {
        Table table = TableRepository.findByNumber(1);
        assertThat(table).isEqualTo(new Table(1));
    }
}