```aidl

for(Transaction transaction : transactions){
    if(Character.isDigit(transaction.getReferenceCode().charAt(0))){
        transactions.remove(transaction);
    }
} 
```

-> 왜 에러발생 : transaction은 iterator type 이기에
