package com.springbootacademy.batch8.pos.controller;

import com.springbootacademy.batch8.pos.dto.CustomerDTO;
import com.springbootacademy.batch8.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch8.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String msg = customerService.updateCustomer(customerUpdateDTO);
        return msg;
    }

    @GetMapping(
            path = "get-by-Id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(path = "get-all-customers")
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(
            path="/delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value="id") int customerId) {
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

    @GetMapping(path = "get-all-customers-by-active-state/{status}")
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState) {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }



}
