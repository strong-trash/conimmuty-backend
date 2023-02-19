package com.conimmuty;

import com.conimmuty.support.Utility;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class ConimmutyApplicationTests {

    @Test
    @DisplayName(value = "한글 포함 테스트")
    void findKorean() {
        String str = "(<><어디서부터 한글일까요????)))";
        int length = str.length();
        int start = 0;
        int end = 0;
        int startIx = '가';
        int endIx = '힣';
        for (int i = 0; i < length; i++) {
            int ix = str.charAt(i);
            if (startIx <= ix && ix <= endIx) {
                start = i;
                break;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            int ix = str.charAt(i);
            if (startIx <= ix && ix <= endIx) {
                end = i;
                break;
            }
        }
        assertThat(start).isEqualTo(4);
        assertThat(end).isEqualTo(14);
        log.info("{}", str.substring(start, end + 1));
        String shuffled = Utility.shuffle(str);
        log.info("shuffled: {}", shuffled);
    }

    @Test
    @DisplayName(value = "긴 문장 테스트")
    void longSentence() {
        String sentence = "외국인은 원어민보다 잘 파악한다. 바꿔 말하면, 이런 트릭에 잘 안 낚일수록 그 언어를 못 한다는 뜻이다. 글을 휘리릭 넘겨읽지 않고 꼼꼼히 살피면서 교열·윤문하는 일을 많이 해본 사람들이나, 의미 단위로 끊어 읽는 것이 애초에 잘 안 되는 난독증 환자들도 이런 오타를 잘 식별한다.";
        String shuffled = Utility.shuffle(sentence);
        log.info("shuffled: {}", shuffled);
    }

}
