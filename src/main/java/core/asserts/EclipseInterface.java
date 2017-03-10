package core.asserts;

/**
 * Created by zaborovsky on 26.12.2016.
 */
public class EclipseInterface {

    public static final Character OPENING_CHARACTER = '[';
    public static final Character CLOSING_CHARACTER = ']';

    public static final String ASSERT_LEFT = "\r\nожидалось  " + OPENING_CHARACTER;
    public static final String ASSERT_LEFT_CONTAINS = "\r\nожидалось, что  " + OPENING_CHARACTER;
    public static final String ASSERT_LEFT2 = "expected not same " + OPENING_CHARACTER;
    public static final String ASSERT_MIDDLE = CLOSING_CHARACTER + "'\r\nно найдено " + OPENING_CHARACTER;
    public static final String ASSERT_MIDDLE_CONTAINS = CLOSING_CHARACTER + "'\r\nбудет содержаться " + OPENING_CHARACTER;
    public static final String ASSERT_RIGHT = Character.toString(CLOSING_CHARACTER);
}

