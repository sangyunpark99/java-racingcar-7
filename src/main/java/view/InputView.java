package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String DELIMITER_ERROR_MESSAGE = "올바른 구분자를 입력해야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복되지 않은 이름을 입력해야 합니다.";
    private static final String EMPTY_ERROR_MESSAGE = "올바른 값을 입력해야 합니다.";

    private static final String DELIMITER = ",";
    private static final String OTHER_DELIMITER_REGEX = "[^,\\w\\s]";
    private static final Integer DUPLICATE_VALUE = 2;

    public static String[] getCarNames() {
        String input = Console.readLine();
        validateEmpty(input);
        validateDelimiter(input);
        String[] carNames = input.split(DELIMITER);
        validateDuplicate(carNames);
        return carNames;
    }

    private static void validateDelimiter(final String input) {
        Pattern pattern = Pattern.compile(OTHER_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException(DELIMITER_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicate(final String[] carNames) {
        Boolean result = Arrays.stream(carNames)
                .distinct()
                .count() >= DUPLICATE_VALUE;

        if(result) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void validateEmpty(final String input) {
        if(input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }
}
