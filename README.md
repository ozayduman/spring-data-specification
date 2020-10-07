This project shows how to use specification queries in spring data jpa.
Simple usage is shown in  _`CustomerSpecificationRepositoryTest.java`_

Sample Specification Usage:
```
 @Test
    void shouldExecuteSpecification() {
        final Optional<Customer> customer = customerRepository.findOne(Specification
            .where(notBornToday()
                .and(byEmail("od@gmail.com"))
                .and(byPhoneNumber("5555")))
         );

        Assertions.assertTrue(customer.isPresent());
  }
```
Sample Specification:
```
    public Specification<Customer> notBornToday() {
      return (root, criteriaQuery, criteriaBuilder) -> {
          return criteriaBuilder.lessThan(root.get(Customer_.birdDate), LocalDate.now());
      };
    }
```
### H2 Console:
~~~~
url:http://localhost:8080/h2-console/
username:ozay
password:ooo
~~~~

### Controller Health Url:
~~~~
http://localhost:8080/customer/ping
username:ozay
password:ooo
~~~~
