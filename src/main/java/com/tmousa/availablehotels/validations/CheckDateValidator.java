package com.tmousa.availablehotels.validations;

import com.tmousa.availablehotels.annotations.CheckDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The CheckDateValidator class
 * Checks if a string of date is of correct format
 *
 * @author  tmousa
 */
public class CheckDateValidator implements ConstraintValidator<CheckDateFormat, String> {

    /**
     * The pattern of the date.
     */
    private String pattern;

    /**
     * initialize
     * @param constraintAnnotation constraint annotation for the date
     *
     * Initializes the pattern for the date format
     */
    @Override
    public void initialize(CheckDateFormat constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    /**
     * isValid
     * This method validates the date format
     *
     * @param dateString date in string format
     * @param constraintContext context of thw date validator
     *
     * @return true if the date is of correct format, else, returns false
     */
    @Override
    public boolean isValid(String dateString, ConstraintValidatorContext constraintContext) {
        if (dateString == null) {
            return true;
        }

        try {
            Date date = new SimpleDateFormat(pattern).parse(dateString);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
