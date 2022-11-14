//package com.example.demo.domain;
//
//import com.example.demo.dto.TransactionDTO;
//import com.example.demo.repository.TransactionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//@Component
//public class UniqueIdValidator implements ConstraintValidator<UniqueId, TransactionDTO> {
//    @Autowired
//    TransactionRepository transactionRepository;
//    @Override
//    public boolean isValid(TransactionDTO transactionDTO, ConstraintValidatorContext constraintValidatorContext) {
//       Transaction trans = transactionRepository.findByUniqueId(transactionDTO.getUniqueId());
//       if (trans == null){
//           return true;
//       }
//       return false;
//    }
//}
