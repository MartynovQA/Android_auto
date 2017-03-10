package core.asserts;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by zaborovsky on 26.12.2016.
 */
public class LightAssert {

    private StringBuffer bufferErrors;

    public LightAssert() {
        this.bufferErrors = new StringBuffer();
    }

    public void assertTrue(boolean condition, String error, String whatCheck) {
        try {
            Assert.assertTrue(condition, error, whatCheck);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
        }
    }

    public void assertEquals(Object actual, Object expected, String error, String whatCheck) {
        try {
            Assert.assertEquals(actual, expected, error, whatCheck);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
        }
    }

    public void assertFalse(boolean condition, String error, String whatCheck) {
        try {
            Assert.assertFalse(condition, error, whatCheck);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
        }
    }


    public void assertContains(String actual, String expected, String error, String whatCheck) {
        try {
            Assert.assertTrue(actual.contains(expected), error, whatCheck);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
            bufferErrors.append(String.format("Ожидалось что\n'%s'\nдолжен содержаться в\n'%s'", expected, actual));
        }
    }

    public <T> void assertInArray(T expected, Collection<? super T> actual, String error, String whatCheck) {
        try {
            Assert.assertInArray(expected, actual, error, whatCheck);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
            bufferErrors.append(String.format("Ожидалось что\n'%s'\nдолжен содержаться в\n'%s'", expected, actual));
        }
    }

    public void assertTrue(boolean condition, String error) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
        }
    }


    public void assertEquals(Object actual, Object expected, String error) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
        }
    }


    public void assertFalse(boolean condition, String error) {
        try {
            Assert.assertFalse(condition);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
        }
    }


    public void assertContains(String actual, String expected, String error) {
        try {
            Assert.assertTrue(actual.contains(expected), error);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
            bufferErrors.append(String.format("Ожидалось что\n'%s'\nдолжен содержаться в\n'%s'", expected, actual));
        }
    }

    public void assertStringContainsSubstring(String actual, List<String> expected, String error) {
        List<String> errors = new ArrayList<>();
        for (String text : expected) {
            try {
                Assert.assertTrue(StringUtils.containsIgnoreCase(actual, text), error);
            } catch (AssertionError exc) {
                errors.add(text);
            }
        }
        if (errors.size() > 0) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(String.format("Ожидалось что\n'%s'\nдолжен содержаться в\n'%s'", Arrays.toString(
                    errors.toArray()), actual));
        }
    }

    public void assertStringContainsSubstring(String actual, List<String> expected, String error, String whatCheck) {
        List<String> errors = new ArrayList<>();
        for (String text : expected) {
            try {
                Assert.assertTrue(StringUtils.containsIgnoreCase(actual, text), error, whatCheck);
            } catch (AssertionError exc) {
                errors.add(text);
            }
        }
        if (errors.size() > 0) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(String.format("Ожидалось что\n'%s'\nдолжен содержаться в\n'%s'", Arrays.toString(
                    errors.toArray()), actual));
        }
    }

    public String getBufferErrors() {
        return bufferErrors.toString();
    }

    public void clearBufferErrors() {
        bufferErrors = new StringBuffer();
    }

}
