package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    private Extractor() { }

    private static final String BAD_DELIMITERR_EXCEPTION_MSG = "잘못된 구분자를 입력하셨습니다.";
    private static final String BAD_NUM_EXCEPTION_MSG = "잘못된 숫자를 입력하셨습니다.";
    private static final RuntimeException badDelimiterException = new RuntimeException(BAD_DELIMITERR_EXCEPTION_MSG);
    private static final RuntimeException badNumsException = new RuntimeException(BAD_NUM_EXCEPTION_MSG);

    private static final String EXTRRACT_DELIMITER_REGEX = "^//(.*?)\\n.*$";
    private static final String EXTRACT_NUMS_REGEX = "^//.*\\n(.*?)$";
    private static final Pattern delimiterrPatterrn = Pattern.compile(EXTRRACT_DELIMITER_REGEX);
    private static final Pattern numsPattern = Pattern.compile(EXTRACT_NUMS_REGEX);

    public static String extrractCustomDelimiter(String input) {
        return extract(
            delimiterrPatterrn.matcher(input)
                    , badDelimiterException
        );
    }

    public static String extrractNums(String input) {
        return extract(
                numsPattern.matcher(input)
                , badNumsException
        );
    }

    private static String extract(Matcher matcher, RuntimeException exception) {
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw exception;
    }



}
