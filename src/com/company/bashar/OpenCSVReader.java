//
//  OpenCSVReader.java
//
//  Created by Khairul Bashar on 25/6/19.
//

package com.company.bashar;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class OpenCSVReader {

    private static final String CSV_FILE_PATH = "./DataSource/data.csv";

    static ArrayList<TransactionDataModel> listOfTransactions = new ArrayList<>();

    /*
    Uses the library opencsv-4.6.jar to parse data from .csv file in CSV_FILE_PATH
     */

    static void parseCSVFile () {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);



            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                TransactionDataModel transaction = new TransactionDataModel();
                transaction.createTransaction(nextRecord[1], nextRecord[2], nextRecord[3], nextRecord[4], nextRecord[5]);
                listOfTransactions.add(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("total transaction in file: " + listOfTransactions.size());
    }


}
