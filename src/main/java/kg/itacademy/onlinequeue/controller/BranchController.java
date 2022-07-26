package kg.itacademy.onlinequeue.controller;

import kg.itacademy.onlinequeue.entity.BranchEntity;
import kg.itacademy.onlinequeue.model.BranchModel;
import kg.itacademy.onlinequeue.model.CompanyModel;
import kg.itacademy.onlinequeue.service.BranchService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin(maxAge = 3600, origins = "*")
@RequestMapping("/api/branch/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchController {
    @Autowired
    BranchService branchService;

    @PostMapping(path = "/create")
    public ResponseEntity<BranchModel> createNewBranch(@RequestBody BranchModel branchModel) {
        BranchModel result = branchService.create(branchModel);

        if (result.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateBranch(@Valid @RequestBody BranchModel branchModel) {
        try {
            return ResponseEntity.ok(branchService.update(branchModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByBranchName")
    public ResponseEntity<BranchModel> getByBranchName(@RequestParam("branchName")
                                                               String branchName) {
        try {
            return ResponseEntity.ok(branchService.getByBranchName(branchName));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getAllBranch")
    public ResponseEntity<List<BranchEntity>> getAllBranch() {
        try {
            return ResponseEntity.ok(branchService.getAllBranch());
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Boolean> deleteBranch(@Valid @RequestBody BranchModel branchModel) {
        try {
            return ResponseEntity.ok(branchService.delete(branchModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}

