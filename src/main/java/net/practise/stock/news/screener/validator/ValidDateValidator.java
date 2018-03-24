package net.practise.stock.news.screener.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author sameer
 */
public class ValidDateValidator implements ConstraintValidator<ValidDate, String> {

  private String format;

  @Override
  public void initialize(ValidDate validDate) {
    this.format = validDate.format();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    return isValidFormat(format, value);
  }

  private static boolean isValidFormat(String format, String value) {
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    try {
      sdf.parse(value);
      return true;
    } catch (ParseException e) {
      return false;
    }
  }
}




