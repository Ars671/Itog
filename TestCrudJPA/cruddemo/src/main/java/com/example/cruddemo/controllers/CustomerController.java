package com.example.cruddemo.controllers;

import com.example.cruddemo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {


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
    public CustomerController(PostRepository postRepository, CotegoryRepository cotegoryRepository, SupplierRepository supplierRepository, WarehouseRepository warehouseRepository, ElectronicsRepository electronicsRepository, CantractRepository cantractRepository, SupplyRepository supplyRepository, EmployeeRepository employeeRepository) {
        this.postRepository = postRepository;
        this.cotegoryRepository = cotegoryRepository;
        this.supplierRepository = supplierRepository;
        this.warehouseRepository = warehouseRepository;
        this.electronicsRepository = electronicsRepository;
        this.cantractRepository = cantractRepository;
        this.supplyRepository = supplyRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping()
    public String dan(Model model){
        if(searchstring.equals(""))
        {
            model.addAttribute("posts", postRepository.findAll());
        }
        else
        {
            model.addAttribute("posts", postRepository.findByPostname(searchstring));
        }
        model.addAttribute("cotegorys", cotegoryRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("electronicss", electronicsRepository.findAll());
        model.addAttribute("cantracts", cantractRepository.findAll());
        model.addAttribute("supplys", supplyRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("searchstr") String searchstr) {
        searchstring = searchstr;
        return "redirect:/";
    }

}
