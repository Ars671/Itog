package com.example.cruddemo.controllers;

import com.example.cruddemo.models.*;
import com.example.cruddemo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.cruddemo.models.modelUser;
import com.example.cruddemo.models.roleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@PreAuthorize("hasAnyAuthority('BROKER')")
public class brokerController {




    private final SupplierRepository supplierRepository;
    private final WarehouseRepository warehouseRepository;
    private final CantractRepository cantractRepository;
    private final SupplyRepository supplyRepository;

    @Autowired
    public brokerController(PostRepository postRepository, CotegoryRepository cotegoryRepository, SupplierRepository supplierRepository, WarehouseRepository warehouseRepository, ElectronicsRepository electronicsRepository, CantractRepository cantractRepository, SupplyRepository supplyRepository) {
        this.supplierRepository = supplierRepository;
        this.warehouseRepository = warehouseRepository;
        this.cantractRepository = cantractRepository;
        this.supplyRepository = supplyRepository;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/newsupplier")
    public String showSignUpFormSupplier(Model model) {
        model.addAttribute("supplier",new Supplier());
        return "add-supplier";
    }


    @GetMapping("/editsupplier/{id}")
    public String showUpdateFormSupplier(@PathVariable("id") int id, Model model) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:" + id));
        model.addAttribute("supplier", supplier);
        return "update-supplier";
    }

    @GetMapping("/deletesupplier/{id}")
    public String deleteSupplier(@PathVariable("id") int id, Model model) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:" + id));
        supplierRepository.delete(supplier);
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addsupplier")
    public String addSupplier(@Valid Supplier supplier, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-supplier";
        }

        supplierRepository.save(supplier);
        model.addAttribute("suppliers", supplierRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatesupplier/{id}")
    public String updateSupplier(@PathVariable("id") int id, @Valid Supplier supplier, BindingResult result, Model model) {
        if (result.hasErrors()) {
            supplier.setId(id);
            return "update-supplier";
        }

        supplierRepository.save(supplier);
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "redirect:/";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newcantract")
    public String showSignUpFormCantract(Model model) {
        model.addAttribute("cantract",new Cantract());
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "add-cantract";
    }


    @GetMapping("/editcantract/{id}")
    public String showUpdateCantract(@PathVariable("id") int id, Model model) {
        Cantract cantract = cantractRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cantract Id:" + id));
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("cantracts", cantract);
        return "update-cantract";
    }

    @GetMapping("/deletecantract/{id}")
    public String deleteCantract(@PathVariable("id") int id, Model model) {
        Cantract cantract = cantractRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cantract Id:" + id));
        cantractRepository.delete(cantract);
        model.addAttribute("cantracts", cantractRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addcantract")
    public String addCantract(@ModelAttribute("warehouseid") int warehouseid, @ModelAttribute("supplierid") int supplierid, @Valid Cantract cantract, BindingResult result, Model model) {
        Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:"));
        Supplier supplier = supplierRepository.findById(supplierid).orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:"));
        cantract.setWarehouse(warehouse);
        cantract.setSupplier(supplier);

        cantractRepository.save(cantract);
        model.addAttribute("cantracts", cantractRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatecantract/{id}")
    public String updateCantract(@PathVariable("id") int id, @ModelAttribute("warehouseid") int warehouseid, @ModelAttribute("supplierid") int supplierid, @Valid Cantract cantract, BindingResult result, Model model) {
        Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" + id));
        Supplier supplier = supplierRepository.findById(supplierid).orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:" + id));
        cantract.setWarehouse(warehouse);
        cantract.setSupplier(supplier);
        cantractRepository.save(cantract);
        model.addAttribute("cantracts", cantractRepository.findAll());
        return "redirect:/";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newsupply")
    public String showSignUpFormSupply(Model model) {
        model.addAttribute("supply",new Supply());
        model.addAttribute("cantracts", cantractRepository.findAll());
        return "add-supply";
    }


    @GetMapping("/editsupply/{id}")
    public String showUpdateSupply(@PathVariable("id") int id, Model model) {
        Supply supply = supplyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid supply Id:" + id));
        model.addAttribute("cantracts", cantractRepository.findAll());
        model.addAttribute("supplys", supply);
        return "update-supply";
    }

    @GetMapping("/deletesupply/{id}")
    public String deleteSupply(@PathVariable("id") int id, Model model) {
        Supply supply = supplyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid supply Id:" + id));
        supply.setCantract(null);
        supplyRepository.delete(supply);
        model.addAttribute("supplys", supplyRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addsupply")
    public String addSupply(@ModelAttribute("cantractid") int cantractid, @Valid Supply supply, BindingResult result, Model model) {
        Cantract cantract = cantractRepository.findById(cantractid).orElseThrow(() -> new IllegalArgumentException("Invalid cantract Id:"));
        supply.setCantract(cantract);

        supplyRepository.save(supply);
        model.addAttribute("supplys", supplyRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatesupply/{id}")
    public String updateSupply(@PathVariable("id") int id, @ModelAttribute("cantractid") int cantractid, @Valid Supply supply, BindingResult result, Model model) {
        Cantract cantract = cantractRepository.findById(cantractid).orElseThrow(() -> new IllegalArgumentException("Invalid cantract Id:" + id));
        supply.setCantract(cantract);
        supplyRepository.save(supply);
        model.addAttribute("supplys", supplyRepository.findAll());
        return "redirect:/";
    }



}
