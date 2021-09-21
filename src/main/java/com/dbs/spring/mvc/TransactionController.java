package com.dbs.spring.mvc;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbs.spring.model.Bank;
import com.dbs.spring.model.Customer;
import com.dbs.spring.model.Logger;
import com.dbs.spring.model.Message;
import com.dbs.spring.model.Result;
import com.dbs.spring.model.Transaction;
import com.dbs.spring.model.TransferData;
import com.dbs.spring.constants.Constants;
import com.dbs.spring.model.TransferData;
import com.dbs.spring.service.BankService;
import com.dbs.spring.service.CurrencyService;
import com.dbs.spring.service.CustomerService;
import com.dbs.spring.service.LoggerService;
import com.dbs.spring.service.MessageService;
import com.dbs.spring.service.RequestServiceImpl;
import com.dbs.spring.service.TransactionService;
import com.dbs.spring.service.TransfertypeService;

/**
 * Transfer functionality
 * 
 * 1. Sender Data 
 * 		1.1 senderid --> sender data | Frontend validation: no account
 * 		found , 
 * 2. Reciever Data 
 * 		2.1 Reciever bic --> get bank name | no bank found ,
 * 3. Transfer Details: 
 * 		3.1 Transfer types and amount | restrict bank own trans
 * 		then recieverBic must be one of HDFC bank bic, 3.2.take message code 4.
 * 4. Amount: Todo : get transfer fee rate 
 * 		4.1 Transfer Amount | no overdraft or exceeds amount etc... 
 * 		4.2 Calculate and Display automatically at frontend but
 * 		cal at backend internally 4.3 Currency select INR Default
 * 
 * summary of transferTransactionData and post transferTransaction Data upon
 * create a transaction and save internally
 * 
 */
@RestController
@RequestMapping("/transfer")
@CrossOrigin()
public class TransactionController {

	@Autowired
	private BankService bankService;

	public TransactionController() {
		// TODO Auto-generated constructor stub
	}

	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private RequestServiceImpl requestService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private LoggerService loggerService;
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private TransfertypeService transfertypeService;
	private Customer getCustomer(String id) {
		return this.customerService.findCustomerById(id);
	}

	@PostMapping("/initTransfer")
	public ResponseEntity<Object> initTransaction(@RequestBody TransferData transferData,HttpServletRequest request) {
		Result result = new Result();
		
		boolean isvalidTransactionData = false;
		try {
			if (getCustomer(transferData.getSendCustomerId()) != null
					&& this.bankService.findBankById(transferData.getreceiverBIC()) != null
					&& this.transfertypeService.findById(transferData.getTransferTypeId()) != null) {

				Bank recieverBank = this.bankService.findBankById(transferData.getreceiverBIC());

				if (isValidTransferType(transferData, recieverBank)) {
					
					Customer customer = getCustomer(transferData.getSendCustomerId());
					double totalDeductionAmount = transferData.getTransferAmount() + getTransferFee(transferData.getTransferAmount());
					
					if(customer.getOverdraftflag() ||  (!customer.getOverdraftflag() && totalDeductionAmount <= customer.getClearbalance()) ) {
						customer.setClearbalance(customer.getClearbalance() - totalDeductionAmount);			
						this.customerService.updateCustomer(customer);
						
						Transaction transaction = new Transaction(2,customerService.findCustomerById(transferData.sendCustomerId),
								bankService.findBankById(transferData.senderBIC),
								bankService.findBankById(transferData.receiverBIC),
								currencyService.findCurrencyById(transferData.currencyCode)
								,transferData.receiverAccountNumber,transfertypeService.findById(transferData.transferTypeId),transferData.receiverAccHolderName,
								messageService.findById(transferData.messagecode),transferData.transferAmount,1,1,LocalDate.now());

						int transactionID = this.transactionService.insertTransaction(transaction);
						
						// TODO: create logger object and save it
						
						System.out.println(requestService.getClientIp(request));
								

						
						
						result.setStatus(true);
						result.setMessage("Transaction Successfull");
						transaction.setTransactionid(transactionID);
						result.data = transaction;
						return ResponseEntity.status(HttpStatus.OK).body(result);
						
					}
					else {
						// incorrect transfer type: 
						result.setStatus(false);
						result.setMessage("Insufficient Balance");
						return ResponseEntity.status(HttpStatus.OK).body(result);
					}
				}else {
					// incorrect transfer type: 
					result.setStatus(false);
					result.setMessage("Invalid Transfer Type.");
					return ResponseEntity.status(HttpStatus.OK).body(result);
				}
			}
			
			if(!isvalidTransactionData) {
				throw new Exception("Is not valid Transaction");
			}
			
		} catch (Exception e) {
			result.setStatus(false);
			result.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(result);
		}
		
		return null;
	}

	private Double getTransferFee(Double transferAmount) {
		
		return Constants.TRANSFER_FEE_RATE*transferAmount;
	}
	// TODO: Check in DB Do Bank has extra attribute call isinternalBank 
	private boolean isValidTransferType(TransferData transferData, Bank recieverBank) {

		return true;
//		return true;(transferData.transferTypeId.equals(Constants.CUSTOMER_TRANSFER_TYPE) && !recieverBank.isInternalBank())
//				|| (transferData.transferTypeId.equals(Constants.BANK_OWN_TRANSFER_TYPE)
//						&& recieverBank.isInternalBank());
	}
	@GetMapping("/{cid}")
	public List<Transaction> getAllById(@PathVariable String cid){
        return this.transactionService.getAllById(cid);
    }
	
}
