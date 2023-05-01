package com.example._20202330_gtics_lab5.controllers;

import com.example._20202330_gtics_lab5.entitys.Employee;
import com.example._20202330_gtics_lab5.repositorys.DepartmentRepository;
import com.example._20202330_gtics_lab5.repositorys.EmployeeRepository;
import com.example._20202330_gtics_lab5.repositorys.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    final EmployeeRepository employeeRepository;
    final JobRepository jobRepository;
    final DepartmentRepository departmentRepository;

    public EmployeeController(EmployeeRepository employeeRepository, JobRepository jobRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/")
    public String listarEmpleados(Model model){
        model.addAttribute("listaEmpleados",employeeRepository.listarEnables());
        return "employee/listarEmpleados";
    }

    @GetMapping("/crearEmployee")
    public String crearEmpleado(Model model){
        model.addAttribute("listaPuestos",jobRepository.findAll());
        model.addAttribute("listaEmpleados",employeeRepository.findAll());
        model.addAttribute("listaDepartamentos",departmentRepository.findAll());
        return "employee/crearEmpleado";
    }

    @GetMapping("/borrar")
    public String borrarEmpleado(@RequestParam("id") int id, RedirectAttributes attr,Model model) {
        Optional<Employee> optional = employeeRepository.findById(id);

        if (optional.isPresent()) {
            employeeRepository.borrarEmpleado(id);
            attr.addFlashAttribute("msg", "Usuario borrado exitosamente");
        }
        return "redirect:/employee/";
    }

    @GetMapping("/editar")
    public String editarEmpleado(@RequestParam("id") int id, RedirectAttributes attr,Model model) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "employee/editarEmpleado";
        } else {
            return "redirect:/employee/";
        }
    }

    @PostMapping("/guardarNew")
    public String guardarNuevoEmpleado(@RequestParam("firstname")String firstname,
                                       @RequestParam("lastname")String lastname,
                                       @RequestParam("email")String email,
                                       @RequestParam("password")String password,
                                       @RequestParam("puesto")String puesto_id,
                                       @RequestParam("sueldo") double sueldo,
                                       @RequestParam("manager")Integer manager_id,
                                       @RequestParam("departamento")Integer department_id,
                                       Model model, RedirectAttributes attr){

        /*Employee e = new Employee();
        e.setFirstName(firstname);
        e.setLastName(email);
        e.setPassword(password);
        e.setSalary(sueldo);

        List<Employee> employeeList = employeeRepository.findAll();
        int i=0;
        for(Employee employee : employeeList){
            i++;
        }

        Job puesto = jobRepository.findById(puesto_id).get();
        e.setJob(puesto);

        Employee manager = employeeRepository.findById(manager_id).get();
        e.setManager(manager);

        Department department = departmentRepository.findById(department_id).get();
        e.setDepartment(department);
        e.setId(i);
        employeeRepository.save(e);*/
        attr.addFlashAttribute("msg", "Empleado creado exitosamente");
        employeeRepository.guardarEmpleado(firstname,lastname,email,password,puesto_id,sueldo,manager_id,department_id);
        return "redirect:/employee/";
    }


    @PostMapping("/buscarEmployee")
    public String buscarEmpleado(@RequestParam("search") String search,
                                 Model model) {

        List<Employee> listaEmpleados = employeeRepository.buscadorDeListaEmployees(search);
        model.addAttribute("empleadoList", listaEmpleados);
        model.addAttribute("textoBuscado", search);

        return "employee/listarEmpleados";
    }


}
