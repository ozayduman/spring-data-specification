package com.ozayduman.customer.entity;
import com.ozayduman.customer.entity.Customer;
import com.ozayduman.customer.entity.Customer_;
import com.ozayduman.customer.entity.Phone;
import com.ozayduman.customer.entity.Phone_;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
@UtilityClass
public class CustomerSpecifications {

   public Specification<Customer> notBornToday() {
      return (root, criteriaQuery, criteriaBuilder) -> {
          return criteriaBuilder.lessThan(root.get(Customer_.birthDate), LocalDate.now());
      };
    }

    public Specification<Customer> byEmail( String email) {
        return (root, criteriaQuery, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get(Customer_.email), email);
    }

    public Specification<Customer> byPhoneNumber(String number) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            final Join<Customer, Phone> phonesJoin = root.join(Customer_.phones, JoinType.INNER);
            return criteriaBuilder.equal(phonesJoin.get(Phone_.number), number);
        };
    }

    public Specification<Customer> byEmailAndPhoneNumber(String number, String email) {
        return byEmail(email).and(byPhoneNumber(number));
    }
}
