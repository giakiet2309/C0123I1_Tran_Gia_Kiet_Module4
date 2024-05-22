package com.example.phone_number.dto;

import com.example.phone_number.model.Phone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto implements Validator {

    private String numberPhone;

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneDto phoneDto = (PhoneDto) target;
        String number = phoneDto.getNumberPhone();
        ValidationUtils.rejectIfEmpty(errors, "numberPhone", null ,"phoneNumber not empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("numberPhone", null ," length form 10 to 11");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("numberPhone", null ,"phoneNumber start with 0");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("numberPhone", null ,"phoneNumber only include number");
        }
    }
}
