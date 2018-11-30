/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.triviaExchange.accountService.account;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dwin
 */
@RestController
public class AccountController {
    
    @Autowired
    private AccountRepo accountRepo;

    
    
    
    @GetMapping("/account/{accountId}")
    public Account nameDoesntMatter(@PathVariable Integer accountId) {
        return accountRepo.findById(accountId).get();
    }
    
    @GetMapping("/accounts")
    public List<Account> otherName() {
        return accountRepo.findAll();
    }
   
    @PostMapping("/account/{accountId}")
    public void save(@PathVariable Integer accountId, @Valid @RequestBody Account act) {
        accountRepo.save(act);
    }
    
    @PutMapping("/account/{accountId}")
    public void otherSave(@PathVariable Integer accountId, @Valid @RequestBody Account act) {
        accountRepo.save(act);
    }
    
    @DeleteMapping("/account/{accountId}")
    public void del(@PathVariable Integer accountId) {
        accountRepo.deleteById(accountId);
    }
    
    
    
    
    
    
    ////////////////////
    
    public AccountRepo getAccountRepo() {
        return accountRepo;
    }

    public void setAccountRepo(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
}
