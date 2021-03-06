package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertEquals(List.of("Torres"), new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertEquals(List.of(2, 4, 0, 1, 1), new Searches().findFractionNumeratorByUserFamilyName("Torres")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertEquals(List.of("López", "Torres"), new Searches().findUserFamilyNameByFractionDenominator(2)
                .collect(Collectors.toList()));
    }
    @Test
    void testFindUserIdBySomeProperFraction(){
        assertEquals(List.of(true),new Searches().findUserIdBySomeProperFraction(true)
        .collect(Collectors.toList()));
    }
    @Test
    void testFindFractionAdditionByUserId(){
        assertEquals(List.of(),new Searches().findFractionAdditionByUserId("1")
                .toString());
    }
    @Test
    void testFindFirstFractionSubtractionByUserName(){
        assertEquals(List.of(),new Searches().findFirstFractionSubtractionByUserName("Ana"));
    }
    @Test
    void testFindDecimalFractionByNegativeSignFraction(){
        assertEquals(List.of(1),new Searches().findDecimalFractionByNegativeSignFraction(1)
                .collect(Collectors.toList()));
    }
}
