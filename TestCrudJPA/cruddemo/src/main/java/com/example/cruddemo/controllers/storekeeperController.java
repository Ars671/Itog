package com.example.cruddemo.controllers;

import com.example.cruddemo.models.*;
import com.example.cruddemo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@PreAuthorize("hasAnyAuthority('STOREKEEPER')")
public class storekeeperController {


    private final PostRepository postRepository;
    private final CotegoryRepository cotegoryRepository;
    private final SupplierRepository supplierRepository;
    private final WarehouseRepository warehouseRepository;
    private final ElectronicsRepository electronicsRepository;
    private final CantractRepository cantractRepository;
    private final SupplyRepository supplyRepository;
    private final EmployeeRepository employeeRepository;

    private String searchstring = "";

    @Autowired
    public storekeeperController(PostRepository postRepository, CotegoryRepository cotegoryRepository, SupplierRepository supplierRepository, WarehouseRepository warehouseRepository, ElectronicsRepository electronicsRepository, CantractRepository cantractRepository, SupplyRepository supplyRepository, EmployeeRepository employeeRepository) {
        this.postRepository = postRepository;
        this.cotegoryRepository = cotegoryRepository;
        this.supplierRepository = supplierRepository;
        this.warehouseRepository = warehouseRepository;
        this.electronicsRepository = electronicsRepository;
        this.cantractRepository = cantractRepository;
        this.supplyRepository = supplyRepository;
        this.employeeRepository = employeeRepository;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newpost")
    public String showSignUpForm(Model model) {
        model.addAttribute("post",new Post());
        return "add-post";
    }

    @GetMapping("/editpost/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        return "update-post";
    }

    @GetMapping("/deletepost/{id}")
    public String deletepost(@PathVariable("id") int id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        postRepository.delete(post);
        model.addAttribute("posts", postRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addpost")
    public String addPost(@Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-post";
        }

        postRepository.save(post);
        model.addAttribute("posts", postRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatepost/{id}")
    public String updatePost(@PathVariable("id") int id, @Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            post.setId(id);
            return "update-post";
        }

        postRepository.save(post);
        model.addAttribute("posts", postRepository.findAll());
        return "redirect:/";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newcotegory")
    public String showSignUpFormCotegory(Model model) {
        model.addAttribute("cotegory",new Cotegory());
        return "add-cotegory";
    }


    @GetMapping("/editcotegory/{id}")
    public String showUpdateFormCotegory(@PathVariable("id") int id, Model model) {
        Cotegory cotegory = cotegoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cotegory Id:" + id));
        model.addAttribute("cotegory", cotegory);
        return "update-cotegory";
    }

    @GetMapping("/deletecotegory/{id}")
    public String deleteCotegory(@PathVariable("id") int id, Model model) {
        Cotegory cotegory = cotegoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cotegory Id:" + id));
        cotegoryRepository.delete(cotegory);
        model.addAttribute("cotegorys", cotegoryRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addcotegory")
    public String addCotegory(@Valid Cotegory cotegory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-cotegory";
        }

        cotegoryRepository.save(cotegory);
        model.addAttribute("cotegorys", cotegoryRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatecotegory/{id}")
    public String updateCotegory(@PathVariable("id") int id, @Valid Cotegory cotegory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            cotegory.setId(id);
            return "update-cotegory";
        }

        cotegoryRepository.save(cotegory);
        model.addAttribute("cotegorys", cotegoryRepository.findAll());
        return "redirect:/";
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newwarehouse")
    public String showSignUpFormWarehouse(Model model) {
        model.addAttribute("warehouse",new Warehouse());
        return "add-warehouse";
    }


    @GetMapping("/editwarehouse/{id}")
    public String showUpdateFormWarehouse(@PathVariable("id") int id, Model model) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid warehouse Id:" + id));
        model.addAttribute("warehouse", warehouse);
        return "update-warehouse";
    }

    @GetMapping("/deletewarehouse/{id}")
    public String deleteWarehouse(@PathVariable("id") int id, Model model) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid warehouse Id:" + id));
        warehouseRepository.delete(warehouse);
        model.addAttribute("warehouses", warehouseRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addwarehouse")
    public String addWarehouse(@Valid Warehouse warehouse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-warehouse";
        }

        warehouseRepository.save(warehouse);
        model.addAttribute("warehouses", warehouseRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatewarehouse/{id}")
    public String updateWarehouse(@PathVariable("id") int id, @Valid Warehouse warehouse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            warehouse.setId(id);
            return "update-warehouse";
        }

        warehouseRepository.save(warehouse);
        model.addAttribute("warehouses", warehouseRepository.findAll());
        return "redirect:/";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newelectronics")
    public String showSignUpFormElectronics(Model model) {
        model.addAttribute("electronics",new Electronics());
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("cotegorys", cotegoryRepository.findAll());
        return "add-electronics";
    }


    @GetMapping("/editelectronics/{id}")
    public String showUpdateElectronics(@PathVariable("id") int id, Model model) {
        Electronics electronics = electronicsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid electronics Id:" + id));
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("cotegorys", cotegoryRepository.findAll());
        model.addAttribute("electronics", electronics);
        return "update-electronics";
    }

    @GetMapping("/deleteelectronics/{id}")
    public String deleteElectronics(@PathVariable("id") int id, Model model) {
        Electronics electronics = electronicsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid electronics Id:" + id));
        electronicsRepository.delete(electronics);
        model.addAttribute("electronicss", electronicsRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addelectronics")
    public String addElectronics(@ModelAttribute("warehouseid") int warehouseid, @ModelAttribute("cotegoryid") int cotegoryid, @Valid Electronics electronics, BindingResult result, Model model) {
        Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:"));
        Cotegory cotegory = cotegoryRepository.findById(cotegoryid).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:"));
        electronics.setWarehouse(warehouse);
        electronics.setCotegory(cotegory);

        electronicsRepository.save(electronics);
        model.addAttribute("electronicss", electronicsRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updateelectronics/{id}")
    public String updateElectronics(@PathVariable("id") int id, @ModelAttribute("warehouseid") int warehouseid, @ModelAttribute("cotegoryid") int cotegoryid, @Valid Electronics electronics, BindingResult result, Model model) {
        Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" + id));
        Cotegory cotegory = cotegoryRepository.findById(cotegoryid).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        electronics.setWarehouse(warehouse);
        electronics.setCotegory(cotegory);
        electronicsRepository.save(electronics);
        model.addAttribute("electronicss", electronicsRepository.findAll());
        return "redirect:/";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newemployee")
    public String showSignUpFormEmployee(Model model) {
        model.addAttribute("employee",new Employee());
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("posts", postRepository.findAll());
        return "add-employee";
    }


    @GetMapping("/editemployee/{id}")
    public String showUpdateEmployee(@PathVariable("id") int id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @GetMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employeeRepository.delete(employee);
        model.addAttribute("Employees", employeeRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addemployee")
    public String addEmployee(@ModelAttribute("warehouseid") int warehouseid, @ModelAttribute("postid") int postid, @Valid Employee employee, BindingResult result, Model model) {
        Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:"));
        Post post = postRepository.findById(postid).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:"));
        employee.setWarehouse(warehouse);
        employee.setPost(post);

        employeeRepository.save(employee);
        model.addAttribute("employees", employeeRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updateemployee/{id}")
    public String updateEmployee(@PathVariable("id") int id, @ModelAttribute("warehouseid") int warehouseid, @ModelAttribute("postid") int postid, @Valid Employee employee, BindingResult result, Model model) {
        Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" + id));
        Post post = postRepository.findById(postid).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        employee.setWarehouse(warehouse);
        employee.setPost(post);
        employeeRepository.save(employee);
        model.addAttribute("employees", employeeRepository.findAll());
        return "redirect:/";
    }

}
