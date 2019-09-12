//
//  TransactionDataModel.java
//  A data model class, blueprint of an object that represent a transaction
//
//  Created by Khairul Bashar on 25/6/19.
//

package com.company.bashar;

class TransactionDataModel {

    private String stockCode;
    private String desc;
    private String quantity;
    private String invoiceDate;
    private String unitPrice;

    void createTransaction (String stock, String detail, String total, String invoice, String price) {

        stockCode = stock;
        desc = detail;
        quantity = total;
        invoiceDate = invoice;
        unitPrice = price;
    }

    String buildStringFromTransactions() {
        StringBuilder concatenateStrings = new StringBuilder();
        concatenateStrings.append(stockCode);
        concatenateStrings.append(desc);
        concatenateStrings.append(quantity);
        concatenateStrings.append(invoiceDate);
        concatenateStrings.append(unitPrice);

        return concatenateStrings.toString();

    }

    void printTransactions() {

        printItem(stockCode);
        printItem(desc);
        printItem(quantity);
        printItem(invoiceDate);
        printItem(unitPrice);

        System.out.println();
    }

    private void printItem(String item) {
        System.out.print(item + ", ");
    }


}
