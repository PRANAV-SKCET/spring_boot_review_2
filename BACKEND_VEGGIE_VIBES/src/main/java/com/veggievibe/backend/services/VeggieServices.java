package com.veggievibe.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

import com.veggievibe.backend.model.CustomerOrder;
import com.veggievibe.backend.model.DairyDetails;
import com.veggievibe.backend.model.FruitDetails;
import com.veggievibe.backend.model.SignUp;
import com.veggievibe.backend.model.UserDetails;
import com.veggievibe.backend.model.VegetableDetails;
import com.veggievibe.backend.repository.CustomerOrderRepo;
import com.veggievibe.backend.repository.DairyRepo;
import com.veggievibe.backend.repository.FruiteRepo;
import com.veggievibe.backend.repository.SignUpRepo;
import com.veggievibe.backend.repository.UserDetailsRepo;
import com.veggievibe.backend.repository.VeggieRepo;

@Service
public class VeggieServices {

    @Autowired
    private VeggieRepo veggieRepo;

    @Autowired
    private FruiteRepo fruiteRepo;

    @Autowired
    private DairyRepo dairyRepo;

    @Autowired
    private SignUpRepo signUpRepo;

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired 
    private CustomerOrderRepo customerOrderRepo;

    public boolean addSignUp(SignUp signup) {
        try {
            signUpRepo.save(signup);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addOrder(CustomerOrder customerOrder) {
        try {
            customerOrderRepo.save(customerOrder);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addUserDetails(UserDetails userDetails) {
        try {
            userDetailsRepo.save(userDetails);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public VegetableDetails saveVegeteable(VegetableDetails vegetableDetails) {
        veggieRepo.save(vegetableDetails);
        return vegetableDetails;
    }

    public FruitDetails saveFruits(FruitDetails fruitDetails) {
        fruiteRepo.save(fruitDetails);
        return fruitDetails;
    }

    public DairyDetails saveDairy(DairyDetails dairyDetails) {
        dairyRepo.save(dairyDetails);
        return dairyDetails;
    }

    public List<VegetableDetails> getVegetables() {
        return veggieRepo.findAll();
    }

    public List<FruitDetails> getFruits() {
        return fruiteRepo.findAll();
    }

    public List<DairyDetails> getDairies() {
        return dairyRepo.findAll();
    }

    public VegetableDetails searchVeggieById(int id) {
        return veggieRepo.findById(id).orElse(null);
    }

    public FruitDetails searchFruiteById(int id) {
        return fruiteRepo.findById(id).orElse(null);
    }

    public DairyDetails searchDairyById(int id) {
        return dairyRepo.findById(id).orElse(null);
    }

    public List<VegetableDetails> searchVeggieByName(String name) {
        return veggieRepo.findByName(name);
    }

    public List<FruitDetails> searchFruiteByName(String name) {
        return fruiteRepo.findByName(name);
    }

    public List<DairyDetails> searchDairyDetails(String name) {
        return dairyRepo.findByName(name);
    }

    public Boolean updateVeggie(int id, VegetableDetails vegetableDetails) {
        if (this.searchVeggieById(id) == null)
            return false;

        try {
            veggieRepo.save(vegetableDetails);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateFruite(int id, FruitDetails fruitDetails) {
        if (this.searchFruiteById(id) == null)
            return false;

        try {
            fruiteRepo.save(fruitDetails);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateDairy(int id, DairyDetails dairyDetails) {
        if (this.searchDairyById(id) == null)
            return false;

        try {
            dairyRepo.save(dairyDetails);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteVeggie(int id) {
        if (this.searchVeggieById(id) == null)
            return false;

        try {
            veggieRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteFruite(int id) {
        if (this.searchFruiteById(id) == null)
            return false;

        try {
            fruiteRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteDairy(int id) {
        if (this.searchDairyById(id) == null)
            return false;

        try {
            dairyRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<VegetableDetails> SortVeggieByPriceAsc() {
        return veggieRepo.sortByPriceAsc();
    }

    public List<FruitDetails> SortFruiteByPriceAsc() {
        return fruiteRepo.sortByPriceAsc();
    }

    public List<DairyDetails> SortDairyByPriceAsc() {
        return dairyRepo.sortByPriceAsc();
    }

    public List<VegetableDetails> SortVeggieByPriceDesc() {
        return veggieRepo.sortByPriceDesc();
    }

    public List<FruitDetails> SortFruiteByPriceDesc() {
        return fruiteRepo.sortByPriceDesc();
    }

    public List<DairyDetails> SortDairyByPriceDesc() {
        return dairyRepo.sortByPriceDesc();
    }

    public List<VegetableDetails> SortVeggieByNameAsc() {
        return veggieRepo.sortByNameAsc();
    }

    public List<FruitDetails> SortFruiteByNameAsc() {
        return fruiteRepo.sortByNameAsc();
    }

    public List<DairyDetails> SortDairyByNameAsc() {
        return dairyRepo.sortByNameAsc();
    }

    public List<VegetableDetails> SortVeggieByNameDesc() {
        return veggieRepo.sortByNameDesc();
    }

    public List<FruitDetails> SortFruiteByNameDesc() {
        return fruiteRepo.sortByNameDesc();
    }

    public List<DairyDetails> SortDairyByNameDesc() {
        return dairyRepo.sortByNameDesc();
    }

    public List<SignUp> getSignUp(int offset,int pageSize,String field) {
        return signUpRepo.findAll(PageRequest.of(offset, pageSize,Sort.by(Sort.Direction.ASC,field))).getContent();
    }

    public boolean login(String userName, String password) {
        @SuppressWarnings("null")
        SignUp signUp = signUpRepo.findById(userName).orElse(null);
        String s = signUp.getPassword();

        if (s.equals(password) && signUp != null) {
            return true;
        }

        else {
            return false;
        }
    }

    public SignUp getSignUpByUserName(String userName)
    {
        return signUpRepo.findById(userName).orElse(null);
    }

    public boolean checkUserName(String userName)
    {
        SignUp signUp = signUpRepo.findById(userName).orElse(null);
        if(signUp==null)
        {
            return true;
        }
        return false;
    }

    public boolean deleteSignUp(String userName)
    {
        if(checkUserName(userName)==true)
        {
            return false;
        }
        signUpRepo.deleteById(userName);
        return true;      
    }

    public boolean editSignUp(String userName,UserDetails userDetails)
    {
        if(checkUserName(userName)==true)
        {
            return false;
        }
        userDetailsRepo.save(userDetails);
        return true;       
    }

    public boolean editOrder(String userName,int orderId,String status)
    {
        if(checkUserName(userName)==true)
        {
            return false;
        }
        var p = customerOrderRepo.updateStatus(userName,orderId,status);
        System.out.println(p);
        return true;       
    }
}
