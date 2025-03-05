package com.umrproj.firstjobapp.company;

import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
     public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
     }


     @PostMapping
     public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully", HttpStatus.CREATED);
     }

     @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        boolean updatedCompany = companyService.updateCompany(company, id);
        if(updatedCompany){
            return new ResponseEntity<>("Company updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not Updated",
                HttpStatus.NOT_FOUND);
     }

     @DeleteMapping("{id}")
     public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean deletedCompany = companyService.deleteCompany(id);
        if(deletedCompany){
            return new ResponseEntity<>("Company Deleted Successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
        }

     }

     @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

     }


}
