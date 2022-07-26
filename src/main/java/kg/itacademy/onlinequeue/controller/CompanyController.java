package kg.itacademy.onlinequeue.controller;

import kg.itacademy.onlinequeue.entity.CompanyEntity;
import kg.itacademy.onlinequeue.model.CompanyModel;
import kg.itacademy.onlinequeue.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/company")
@Slf4j
//Disable politic CORS
@CrossOrigin(maxAge = 3600, origins = "*")
public class CompanyController {
        @Autowired
        CompanyService companyService;

    @PostMapping(path = "/create")
    public ResponseEntity<CompanyModel> createNewCompany( @RequestBody CompanyModel companyModel) {
        CompanyModel result = companyService.create(companyModel);

        if (result.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateCompany( @Valid @RequestBody CompanyModel companyModel) {
        try {
            return ResponseEntity.ok(companyService.update(companyModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByCompanyName")
    public ResponseEntity<CompanyModel> getByCompanyName( @RequestParam("companyName")
                                                                 String companyName) {
        try {
            return ResponseEntity.ok(companyService.getByCompanyName(companyName));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<CompanyModel>> getAll() {
        try {
            return ResponseEntity.ok(companyService.getAll());
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<Boolean> deleteCompany( @Valid @RequestBody CompanyModel companyModel) {
        try {
            return ResponseEntity.ok(companyService.delete(companyModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
