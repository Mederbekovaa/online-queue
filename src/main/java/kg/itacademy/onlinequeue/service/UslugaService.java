package kg.itacademy.onlinequeue.service;

import kg.itacademy.onlinequeue.entity.UslugaEntity;
import kg.itacademy.onlinequeue.model.UslugaModel;

import java.util.List;

public interface UslugaService {
    UslugaEntity create(UslugaModel uslugaModel);

    boolean update(UslugaModel uslugaModel);

    UslugaModel getByUslugaName(String uslugaName);

    boolean delete(UslugaModel uslugaModel);

    List<UslugaModel> getAllUsluga();
}
