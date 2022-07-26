package kg.itacademy.onlinequeue.service;

import kg.itacademy.onlinequeue.entity.CompanyEntity;
import kg.itacademy.onlinequeue.model.CompanyModel;

import java.util.List;

public interface CompanyService  {

    CompanyModel create(CompanyModel companyModel);


    boolean update(CompanyModel companyModel);

    CompanyModel getByCompanyName(String companyName);

    boolean delete(CompanyModel companyModel);

    List<CompanyModel> getAll();
}
