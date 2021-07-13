package com.lean.training.employee.test;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lean.training.LeanApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LeanApplication.class)
public class EmployeeTest {


    @Test
    public void shouldDoSomething() {
        System.out.println("algo");
    }
	
	/*@InjectMocks
	EmployeeService employeeService;
	@Mock
	EmployeeRepository repo;*/
	
	/*@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/
	/*
	@Test
    public void getAllEmployeesTest()
    {
		
		List<Employee> list= new ArrayList<Employee>();
		EmployeePositionPK id= new  EmployeePositionPK(6l, 1l, 1l);
		EmployeePositionPK id1= new  EmployeePositionPK(7l, 1l, 1l);
		EmployeePositionPK id2= new  EmployeePositionPK(8l, 1l, 1l);
		
		Employee empOne = new Employee(id, new BigDecimal(134.6));
		Employee empTwo = new Employee(id1, new BigDecimal(1344.6));
		Employee empThree = new Employee(id2, new BigDecimal(1324.6));
         
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
         
        when((List<Employee>) repo.findAll()).thenReturn(list);
         
        //test
        List<Employee> empList = employeeService.getAllEmployees();
         
        assertEquals(3, empList.size());
        verify(repo, times(1)).findAll();
        
    }
*/
}
