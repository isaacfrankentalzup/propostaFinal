package br.com.zupedu.proposta.proposta.validators;

import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.hibernate.validator.constraints.CompositionType.OR;

@Documented
@Target(FIELD)
@ConstraintComposition(OR)
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@CPF
@CNPJ
public @interface ValidaDocumento {
    String message() default "Documento inválido";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
}
