package com.landsmann.trollcount2;

import org.junit.Test;

import static com.landsmann.trollcount2.TrollNumber.*;
import static org.junit.Assert.assertEquals;

public class TrollNumberTest {

    @Test
    public void constants_should_have_correct_value() {
        assertEquals(1, one.value);
        assertEquals(2, two.value);
        assertEquals(3, three.value);
        assertEquals(4, many.value);
        assertEquals(16, lots.value);
    }

    @Test
    public void constants_should_have_correct_toString() {
        assertEquals("one", one.toString());
        assertEquals("two", two.toString());
        assertEquals("three", three.toString());
        assertEquals("many", many.toString());
        assertEquals("lots", lots.toString());
    }

    @Test
    public void parse_should_give_correct_value() {
        assertEquals(1, parse("one").value);
        assertEquals(2, parse("two").value);
        assertEquals(3, parse("three").value);
        assertEquals(4, parse("many").value);
        assertEquals(16, parse("lots").value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_wrong_stuff_should_throw_exception() {
        parse("Foo");
    }

    @Test
    public void parse_complex_numbers_should_give_correct_toString() {
        assertEquals("many-one", parse("many-one").toString());
        assertEquals("many-many", parse("many-many").toString());
        assertEquals("many-many-three", parse("many-many-three").toString());
    }

    @Test
    public void parse_complex_number_should_result_in_a_correct_value() {
        assertEquals(6, parse("many-two").value);
        assertEquals(11, parse("many-many-three").value);
        assertEquals(many.value, parse("many").value);
        assertEquals(lots.value, parse("many-many-many-many").value);
        assertEquals(lots.value, parse("lots").value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_too_big_number_should_throw_exception() {
        parse("many-many-many-many-many-two");
    }


}
