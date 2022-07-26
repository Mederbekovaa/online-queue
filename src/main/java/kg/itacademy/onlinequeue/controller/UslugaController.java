package kg.itacademy.onlinequeue.controller;

import kg.itacademy.onlinequeue.entity.UslugaEntity;
import kg.itacademy.onlinequeue.mapper.UslugaMapper;
import kg.itacademy.onlinequeue.model.CompanyModel;
import kg.itacademy.onlinequeue.model.UslugaModel;
import kg.itacademy.onlinequeue.service.UslugaService;
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
@RequestMapping("/api/usluga")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UslugaController {
    @Autowired
    UslugaService uslugaService;

    @PostMapping(path = "/create")
    public ResponseEntity<UslugaModel> createNewUsluga( @RequestBody UslugaModel uslugaModel) {
        UslugaModel result = UslugaMapper.INSTANCE.toModel(uslugaService.create(uslugaModel));

        if (result.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateUsluga( @Valid @RequestBody UslugaModel uslugaModel) {
        try {
            return ResponseEntity.ok(uslugaService.update(uslugaModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByUslugaName")
    public ResponseEntity<UslugaModel> getByUslugaName( @RequestParam("uslugaName")
                                                               String uslugaName) {
        try {
            return ResponseEntity.ok(uslugaService.getByUslugaName(uslugaName));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getAllUsluga")
    public ResponseEntity<List<UslugaModel>> getAllUsluga() {
        try {
            return ResponseEntity.ok(uslugaService.getAllUsluga());
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<Boolean> deleteCompany( @Valid @RequestBody UslugaModel uslugaModel) {
        try {
            return ResponseEntity.ok(uslugaService.delete(uslugaModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}