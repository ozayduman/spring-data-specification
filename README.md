This project shows how to use specification queries in spring data jpa.
There are sample basic usages shown in  _`CustomerSpecificationRepositoryTest.java`_

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

# SPECIFICATION-BUILDER SAMPLE
This section shows how to use [Specification Builder](https://github.com/ozayduman/spring-data-specification-builder)
 library to write type-safe (client-oriented dynamic) queries for search screens in spring data jpa.
The sample usage is shown in  _`CustomerController.java`_

```
<dependency>
    <groupId>com.github.ozayduman</groupId>
    <artifactId>specification-builder</artifactId>
    <version>0.0.3</version>
</dependency>
```

```
@RestController
@RequestMapping("/customer")
@Transactional
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/query")
    public PageResultDTO query(@RequestBody PageRequestDTO pageRequestDTO){
        return PageResultDTO.from(customerService.query(pageRequestDTO), CustomerMapper.INSTANCE::toDTO);
    }
}
```
Then define as a Service class by injecting CustomerRepository class. In this class create a SpecificationBuilder and 
use bind method to allow whatever fields you want to be queryable. Also create a PageRequestBuilder and use bindSort method
to allow which fields to be sortable as shown below:
```
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Page<Customer> query(PageRequestDTO pageRequestDTO) {
        final Specification<Customer> specification = createSpecification(pageRequestDTO);
        final PageRequest pageRequest = createPageRequest(pageRequestDTO);
        return customerRepository.findAll(specification, pageRequest);
    }

    private Specification<Customer> createSpecification(PageRequestDTO pageRequestDTO) {
        return SpecificationBuilder.<Customer>of(pageRequestDTO)
                .bind("name", Customer_.name)
                .bind("lastName", Customer_.surname)
                .bind("email", Customer_.email)
                .bindJoin("phoneNumber", Customer_.phones, Phone_.number)
                .build();
    }

    private PageRequest createPageRequest(PageRequestDTO pageRequestDTO) {
        return PageRequestDTO.PageRequestBuilder.of(pageRequestDTO)
                .bindSort("name", Customer_.name)
                .bindSort("lastName", Customer_.surname)
                .bindSort("email", Customer_.email)
                .build();
    }
}
```
Finally, define a repository interface that extends PagingAndSortingReporistory and JpaSpecificationExecutor interfaces
as follows:
````
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>, JpaSpecificationExecutor<Customer> { }
````
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

http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/
