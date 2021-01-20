package org.si.service;

import org.si.entities.Operation;

public interface OperationMetier {
  public Operation deposit(String code,double amount,Long codeEmp);
  public Operation withraw(String code,double amount,Long codeEmp);
  public boolean virement(String cpt1,String copt2,double montant,Long emp);	
}
